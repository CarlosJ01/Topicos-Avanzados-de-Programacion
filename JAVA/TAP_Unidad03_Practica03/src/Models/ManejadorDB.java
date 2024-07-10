/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Carlos J
 */
public class ManejadorDB {
    private Connection conexion;
    private Statement sentencia;

    //Abrir Enlace
    private void abrir() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/tap_unidad03_practica03","root",null);
        sentencia = (Statement) conexion.createStatement();
    }
    
    //Cerrar Enlace
    private void cerrar() throws Exception{
        sentencia.close();
        conexion.close();
    }
    
    //Regresa una lista con todos los alumnos
    public ArrayList<Alumno> mostrarAlumnos() throws Exception{
        
        abrir();

        String qry = "SELECT a.*, c.carrera AS nombre_carrera FROM alumnos a JOIN carreras c ON a.carrera = c.id";
        ResultSet rs = sentencia.executeQuery(qry);
        
        ArrayList<Alumno> alumnos = new ArrayList<>();
        
        while (rs.next())
        {
            Alumno a = new Alumno();
            a.setNumeroControl(rs.getString("num_control"));
            a.setNombreCompleto(rs.getString("nombre_completo"));
            a.setSemestre(rs.getInt("semestre"));
            a.setCarrera(new Carrera(rs.getInt("carrera"),rs.getString("nombre_carrera")));
            alumnos.add(a);
        }

        cerrar();

        return alumnos;
    }
    
    //Muestra a todos los alumnos y egresados
    public void mostarAlumnosYEgresados(JTable tabla) throws Exception{
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

        ResultSet rs = sentencia.executeQuery(qry);
        //Cargar Interfas
        String datos[][]={};
        String colum[]={"Numero de Control","Nombre Completo","Actualidad","Carrera","Estatus"};
        DefaultTableModel modelo = new DefaultTableModel(datos,colum);
        tabla.setModel(modelo);

        //Cargar Datos
        int filas=0;
        while(rs.next()){
            modelo.insertRow(filas,new Object[]{});
            modelo.setValueAt(rs.getString("num_control"),filas,0);
            modelo.setValueAt(rs.getString("nombre_completo"),filas,1);
            modelo.setValueAt(rs.getString("actualidad"),filas,2);
            modelo.setValueAt(rs.getString("nombre_carrera"),filas,3);
            modelo.setValueAt(rs.getString("estatus"),filas,4);
            filas++;
        }
        
        cerrar();
    }
    
    //Mostrar todas las carreras
    public void mostarCarreras(JTable tabla) throws Exception{
        String qry = "SELECT * FROM carreras";

        abrir();
        ResultSet rs = sentencia.executeQuery(qry);

        //Cargar Interfas
        String datos[][]={};
        String colum[]={"Id","Carrera"};
        DefaultTableModel modelo = new DefaultTableModel(datos,colum);
        tabla.setModel(modelo);

        //Cargar Datos
        int filas=0;
        while(rs.next()){
            modelo.insertRow(filas,new Object[]{});
            modelo.setValueAt(rs.getInt("id"),filas,0);
            modelo.setValueAt(rs.getString("carrera"),filas,1);
            filas++;
        }

        cerrar();
    }
    
    //Insertar un alumno
    public int nuevoAlumno(Alumno alumno) throws Exception{
        abrir();

        String qry = "INSERT INTO alumnos VALUES(?,?,?,?)";
        PreparedStatement ps = conexion.clientPrepareStatement(qry);
        
        ps.setString(1,alumno.getNumeroControl());
        ps.setString(2,alumno.getNombreCompleto());
        ps.setInt(3,alumno.getSemestre());
        ps.setInt(4,alumno.getCarrera().getId());
            
        int resultado = ps.executeUpdate();

        cerrar();

        return resultado;
    }
    
    //Regresa una lista con las calificaciones de un alumno
    public ArrayList<Calificaciones> mostrarCalificaciones(String numCont) throws Exception{
        abrir();

        ArrayList<Calificaciones> lista = new ArrayList<>();
        
        String SentenciaLista = "SELECT c.*,m.nombre AS nombre_materia FROM calificaciones c JOIN materias m WHERE c.alumno = " + numCont+" AND c.materia=m.id;";
        ResultSet rs = sentencia.executeQuery(SentenciaLista);
        
        while (rs.next())
        {
            Calificaciones c = new Calificaciones();
            c.setId(rs.getInt("id"));
            c.getAlumno().setNumeroControl(rs.getString("alumno"));
            c.setCalificacion(rs.getFloat("calificacion"));
            c.getMateria().setNombre_materia(rs.getString("nombre_materia"));
            lista.add(c);
        }

        cerrar();
        return lista;
    }
    
    //Eliminar una calificacion
    public boolean eliminarCalificacion(int id) throws Exception{
        String qry = "DELETE FROM calificaciones WHERE id='" + id + "'";
        abrir();

        try {    
            sentencia.executeUpdate(qry);
        } catch (Exception e) {
            return false;
        }
        
        cerrar();
        return true;
    }
    
    //Modificar una calificacion
    public boolean modificarCalificacion(String id,String calif) throws Exception
    {
        String qry = "UPDATE calificaciones SET calificacion = '"+calif+"' WHERE id = '"+id+"';";
        abrir();
        
        try{
            sentencia.executeUpdate(qry);
        }
        catch (Exception ex){
            return false;
        }

        cerrar();
        return true;
    }
    
    //Regresa una lista de calificaciones
    public ArrayList<Calificaciones> listaCalificaciones() throws Exception{
        abrir();

        ArrayList<Calificaciones> lista = new ArrayList<>();

        String qry = "SELECT c.*, m.nombre AS nombre_materia FROM calificaciones c JOIN materias m ON c.materia = m.id";
        ResultSet rs = sentencia.executeQuery(qry);

        while (rs.next()){
            Calificaciones c = new Calificaciones();
            c.setId(rs.getInt("id"));
            c.getAlumno().setNumeroControl(rs.getString("alumno"));
            c.setCalificacion(rs.getFloat("calificacion"));
            c.getMateria().setNombre_materia(rs.getString("nombre_materia"));
            lista.add(c);
        }

        cerrar();

        return lista;
    }
    
        //Eliminar un alumno
    public boolean eliminarAlumno(String numCont) throws Exception{
        abrir();

        try
        {
            String qry = "DELETE FROM alumnos WHERE num_control='" + numCont + "'";
            sentencia.executeUpdate(qry);
        }
        catch (Exception e)
        {
            return false;
        }

        cerrar();
        return true;
    }
        
        //Regresa a todos los engresados
    public ArrayList<Egresado> mostrarEgresados() throws Exception{
        abrir();

        String qry = "SELECT e.*, c.carrera AS nombre_carrera FROM egresados e JOIN carreras c ON e.carrera = c.id";
        ResultSet rs = sentencia.executeQuery(qry);

        ArrayList<Egresado> egresados = new ArrayList<>();
        
        while (rs.next()){
            Egresado e = new Egresado();
            e.setNumControl(rs.getString("num_control"));
            e.setNombreCompleto(rs.getString("nombre_completo"));
            e.setFechaEgreso(rs.getString("fecha_egreso"));
            e.setCarrera(new Carrera(rs.getInt("carrera"),rs.getString("nombre_carrera")));
            egresados.add(e);
        }

        cerrar();
        return egresados;
    }
    
    //Regresa una lista de las materias existentes
    public ArrayList<Materia> listaMaterias() throws Exception
    {
        ArrayList<Materia> lista = new ArrayList<>();
        String qry = "Select * from materias;";

        abrir();

        ResultSet rs = sentencia.executeQuery(qry);
        while (rs.next()){
            Materia m = new Materia();
            m.setId(rs.getInt("id"));
            m.setNombre_materia(rs.getString("nombre"));
            lista.add(m);
        }

        cerrar();
        return lista;
    }
    
    //Regresa un listado de las carreras
    public ArrayList<Carrera> ListaCarreras() throws Exception
    {
        abrir();

        String qry = "SELECT * FROM carreras";
        ResultSet rs = sentencia.executeQuery(qry);

        ArrayList<Carrera> lista = new ArrayList<>();
        
        while (rs.next()){
            Carrera c = new Carrera();
            c.setId(rs.getInt("id"));
            c.setNombreCarrera(rs.getString("carrera"));
            lista.add(c);
        }

        cerrar();
        return lista;
    }
    
    //Agregar una Calificacion
    public void agregarCalificacion(String alumno,int calificacion,int materia) throws Exception
    {
        abrir();

        String qry = "INSERT INTO calificaciones VALUES(DEFAULT,"+alumno+","+calificacion+","+materia+");";
        sentencia.executeUpdate(qry);

        cerrar();
    }
/*
    
    

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

        

        //Agregar un Egresado
        public void agregarEgresado(String numCont,String nom,String fech,int carrera)
        {
            abrir();
            String qry = "insert into  egresados values('"+numCont+"','"+nom+"','"+fech+"','"+carrera+"');";
            MySqlCommand cmd = new MySqlCommand(qry, conn);
            cmd.ExecuteNonQuery();
            cerrar();
        }
    */
}
