using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace TAP_Unidad03_Practica03.Models
{
    class ManejadorBD
    {
        private MySqlConnectionStringBuilder constructor;//Informacion de la coneccion
        private MySqlConnection conn = null;//Coneccion

        //Construcctor
        public ManejadorBD()
        {
            constructor = new MySqlConnectionStringBuilder();
            constructor.Server = "localhost";
            constructor.Database = "tap_unidad03_practica03";
            constructor.UserID = "root";
            constructor.Password = "";
        }

        //Abrir el enlace
        private void abrir()
        {
            try
            {
                conn = new MySqlConnection(constructor.ToString());
                conn.Open();
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex);
            }
        }

        //Cerrar el enlace
        private void cerrar()
        {
            try
            {
                conn.Close();
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex);
            }
        }

        //Mostrar todas las carreras
        public void mostarCarreras(DataGridView dgv)
        {
            abrir();

            String qry = "SELECT * FROM carreras";
            MySqlDataAdapter adapter = new MySqlDataAdapter();
            adapter.SelectCommand = new MySqlCommand(qry, conn);

            DataTable dt = new DataTable();
            adapter.Fill(dt);

            BindingSource bs = new BindingSource();
            bs.DataSource = dt;

            dgv.DataSource = bs;

            cerrar();
        }

        //Regresa una Carrera recive el id
        public Carrera mostrarCarrera(int id)
        {
            abrir();

            String qry = "SELECT * FROM carreras WHERE id=" + id;
            MySqlCommand cmd = new MySqlCommand(qry, conn);
            MySqlDataReader reader = cmd.ExecuteReader();

            Carrera carrera = null;
            if (reader.Read())
            {
                carrera = new Carrera(reader.GetInt32("id"), reader.GetString("carrera"));
            }

            cerrar();

            return carrera;
        }

        //Insertar un alumno recive un alumno
        public int nuevoAlumno(Alumno alumno)
        {
            abrir();

            String qry = "INSERT INTO alumnos VALUES(@var1,@var2,@var3,@var4)";
            MySqlCommand cmd = new MySqlCommand(qry, conn);
            cmd.Parameters.AddWithValue("@var1", alumno.NumControl);
            cmd.Parameters.AddWithValue("@var2", alumno.NombreCompleto);
            cmd.Parameters.AddWithValue("@var3", alumno.Semestre);
            cmd.Parameters.AddWithValue("@var4", alumno.Carrera.Id);
            cmd.Prepare();

            int resultado = cmd.ExecuteNonQuery();

            cerrar();

            return resultado;
        }

        //Regresa a todos los alumnos
        public List<Alumno> mostrarAlumnos()
        {
            abrir();

            String qry = "SELECT a.*, c.carrera AS nombre_carrera FROM alumnos a JOIN carreras c ON a.carrera = c.id";
            MySqlCommand cmd = new MySqlCommand(qry, conn);
            MySqlDataReader reader = cmd.ExecuteReader();

            List<Alumno> alumnos = new List<Alumno>();
            while (reader.Read())
            {
                Alumno a = new Alumno();
                a.NumControl = reader.GetString("num_control");
                a.NombreCompleto = reader.GetString("nombre_completo");
                a.Semestre = reader.GetInt32("semestre");
                a.Carrera = new Carrera(reader.GetInt32("carrera"), reader.GetString("nombre_carrera"));

                alumnos.Add(a);
            }

            cerrar();

            return alumnos;
        }

        //Regresa a todos los engresados
        public List<Egresado> mostrarEgresados()
        {
            abrir();

            String qry = "SELECT e.*, c.carrera AS nombre_carrera FROM egresados e JOIN carreras c ON e.carrera = c.id";
            MySqlCommand cmd = new MySqlCommand(qry, conn);
            MySqlDataReader reader = cmd.ExecuteReader();

            List<Egresado> egresados = new List<Egresado>();
            while (reader.Read())
            {
                Egresado e = new Egresado();
                e.NumControl = reader.GetString("num_control");
                e.NombreCompleto = reader.GetString("nombre_completo");
                e.FechaEgreso = reader.GetString("fecha_egreso");
                e.Carrera = new Carrera(reader.GetInt32("carrera"), reader.GetString("nombre_carrera"));

                egresados.Add(e);
            }

            cerrar();

            return egresados;
        }

        //Muestra a todos los alumnos y egresados
        public void mostarAlumnosYEgresados(DataGridView dgv)
        {
            abrir();

            String qry = "(";
            qry += "SELECT a.num_control, a.nombre_completo, concat('Actualmente en semestre: ',a.semestre) AS actualidad, c.carrera AS nombre_carrera, 'Activo' AS estatus ";
            qry += " FROM alumnos a ";
            qry += "    INNER JOIN carreras c ON c.id = a.carrera ";
            qry += " WHERE a.num_control NOT IN (SELECT num_control FROM egresados) ";
            qry += ") UNION (";
            qry += "SELECT e.num_control, e.nombre_completo, concat('Egreso en: ', e.fecha_egreso) AS actualidad, c.carrera AS nombre_carrera, 'Egresado' AS estatus ";
            qry += " FROM egresados e ";
            qry += "    INNER JOIN carreras c ON c.id = e.carrera ";
            qry += ")";

            MySqlDataAdapter adapter = new MySqlDataAdapter();
            adapter.SelectCommand = new MySqlCommand(qry, conn);

            DataTable dt = new DataTable();
            adapter.Fill(dt);

            BindingSource bs = new BindingSource();
            bs.DataSource = dt;

            dgv.DataSource = bs;

            cerrar();
        }

        //Regresa un listado de las carreras
        public List<Carrera> ListaCarreras()
        {
            abrir();

            String qry = "SELECT * FROM carreras";
            MySqlCommand cmd = new MySqlCommand(qry, conn);
            MySqlDataReader reader = cmd.ExecuteReader();

            List<Carrera> lista = new List<Carrera>();
            while (reader.Read())
            {
                Carrera car = new Carrera();
                car.Id = reader.GetInt32("id");
                car.NombreCarrera = reader.GetString("carrera");

                lista.Add(car);
            }

            cerrar();

            return lista;
        }

        //Regresa una lista de calificaciones
        public List<Calificaciones> listaCalificaciones()
        {
            abrir();

            String qry = "SELECT c.*, m.nombre AS nombre_materia FROM calificaciones c JOIN materias m ON c.materia = m.id";
            MySqlCommand cmd = new MySqlCommand(qry, conn);
            MySqlDataReader reader = cmd.ExecuteReader();
     
            List<Calificaciones> lista = new List<Calificaciones>();
            while (reader.Read())
            {
                Calificaciones cal = new Calificaciones();
                cal.Id = reader.GetInt32("id");
                cal.Alumno.NumControl = reader.GetString("alumno");
                cal.Calificacion = reader.GetFloat("calificacion");
                cal.Materia.Nombre_materia = reader.GetString("nombre_materia");
                lista.Add(cal);
            }

            cerrar();

            return lista;
        }

        //Eliminar un alumno
        public bool eliminarAlumno(String numCont)
        {
            abrir();

            try
            {
                string sentencia = "DELETE FROM alumnos WHERE num_control='" + numCont + "'";
                MySqlCommand cmd = new MySqlCommand(sentencia, conn);
                cmd.ExecuteNonQuery();
            }
            catch (Exception)
            {
                return false;
            }

            cerrar();

            return true;
        }

        //Regresa una lista con las calificaciones de un alumno
        public List<Calificaciones> mostrarCalificaciones(String numCont)
        {
            abrir();

            List<Calificaciones> lista = new List<Calificaciones>();
            String SentenciaLista = "SELECT c.*,m.nombre AS nombre_materia FROM calificaciones c JOIN materias m WHERE c.alumno = " + numCont+" AND c.materia=m.id;";
            MySqlCommand cmd = new MySqlCommand(SentenciaLista, conn);
            MySqlDataReader reader = cmd.ExecuteReader();

            while (reader.Read())
            {
                Calificaciones cal = new Calificaciones();
                cal.Id = reader.GetInt32("id");
                cal.Alumno.NumControl = reader.GetString("alumno");
                cal.Calificacion = reader.GetFloat("calificacion");
                cal.Materia.Nombre_materia = reader.GetString("nombre_materia");
                lista.Add(cal);
            }

            cerrar();

            return lista;
        }

        //Eliminar una calificacion
        public bool eliminarCalificacion(int id)
        {
            abrir();

            string sentencia = "DELETE FROM calificaciones WHERE id='" + id + "'";
            try
            {
                MySqlCommand cmd = new MySqlCommand(sentencia, conn);
                cmd.ExecuteNonQuery();
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex);
                return false;
            }

            cerrar();

            return true;
        }

        //Modificar una calificacion
        public bool modificarCalificacion(String id,String calif)
        {
            String sentencia = "UPDATE calificaciones SET calificacion = '"+calif+"' WHERE id = '"+id+"';";

            abrir();

            try
            {
                MySqlCommand cmd = new MySqlCommand(sentencia, conn);
                cmd.ExecuteNonQuery();
                //MessageBox.Show("Id: " + id + " Calificacion " + calif);
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex);
                return false;
            }

            cerrar();

            return true;
        }

        //Regresa una lista de las materias existentes
        public List<Materia> listaMaterias()
        {
            List<Materia> lista = new List<Materia>();
            String sentencia = "Select * from materias;";

            abrir();

            MySqlCommand cmd = new MySqlCommand(sentencia, conn);
            MySqlDataReader reader = cmd.ExecuteReader();

            while (reader.Read())
            {
                Materia mat = new Materia();
                mat.Id = reader.GetInt32("id");
                mat.Nombre_materia = reader.GetString("nombre");
                lista.Add(mat);
            }

            cerrar();
            return lista;
        }
     
        //Agregar una Calificacion
        public void agregarCalificacion(String alumno,int calificacion,int materia)
        {
            abrir();

            String qry = "INSERT INTO calificaciones VALUES(DEFAULT,"+alumno+","+calificacion+","+materia+");";
            MySqlCommand cmd = new MySqlCommand(qry, conn);
            cmd.ExecuteNonQuery();

            cerrar();
        }

        //Agregar un Egresado
        public void agregarEgresado(String numCont,String nom,String fech,int carrera)
        {
            abrir();
            String qry = "insert into  egresados values('"+numCont+"','"+nom+"','"+fech+"','"+carrera+"');";
            MySqlCommand cmd = new MySqlCommand(qry, conn);
            cmd.ExecuteNonQuery();
            cerrar();
        }
    }
}
