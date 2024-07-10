using InputKey;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using TAP_Unidad03_Practica03.Models;
using TAP_Unidad03_Practica03.Reports;

namespace TAP_Unidad03_Practica03
{
    public partial class Form1 : Form
    {
        List<Alumno> listaAlumnos;

        public Form1()
        {
            InitializeComponent();
        }
        //Obtenemos la lista de alumnos
        private void Form1_Load(object sender, EventArgs e)
        {
            try
            {
                ManejadorBD manager = new ManejadorBD();
                List<Alumno> alumnos = manager.mostrarAlumnos();

                dataGridView1.RowCount = alumnos.Count;
                for (int i = 0; i < alumnos.Count; i++)
                {
                    dataGridView1[0, i].Value = alumnos.ElementAt(i).NumControl;
                    dataGridView1[1, i].Value = alumnos.ElementAt(i).NombreCompleto;
                    dataGridView1[2, i].Value = alumnos.ElementAt(i).Semestre;
                    dataGridView1[3, i].Value = alumnos.ElementAt(i).Carrera.NombreCarrera;
                    dataGridView1[4, i].Value = "Ver";
                }

                listaAlumnos = alumnos;
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex);
            }
        }

        //Muestra a todos
        private void btnMostrar_Click(object sender, EventArgs e)
        {
            try
            {
                dataGridView1.ColumnCount = 0;
                ManejadorBD manager = new ManejadorBD();
                manager.mostarAlumnosYEgresados(dataGridView1);
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex);
            }
        }

        //Invoca ventana para inscribir
        private void btnInscribir_Click(object sender, EventArgs e)
        {
            new ListaCarreras().Show();
        }
        
        //Modificar calificaciones
        private void dataGridView1_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            try
            {
                DataGridViewButtonCell cell = (DataGridViewButtonCell)dataGridView1.SelectedCells[0];
                // Si se pudo convertir            
                new MostrarCalificaciones(listaAlumnos[cell.RowIndex].NumControl, listaAlumnos[cell.RowIndex].NombreCompleto).Show();
            }
            catch (Exception ex)
            {
                // No se pudo convertir
                Console.WriteLine(ex);
            }
        }

        // Refrescar tabla
        private void refrescarToolStripMenuItem_Click(object sender, EventArgs e)
        {
            this.Controls.Clear(); // borra todo lo que tiene el formulario (ventana)
            InitializeComponent(); // inicializa todo lo que tiene el formulario (ventana)
            Form1_Load(sender, e); // invoca al evento de cargar
        }

        //Sale del programa
        private void salirToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }
        
        //Busca un Egresado
        private void buscarEgresadoToolStripMenuItem_Click(object sender, EventArgs e)
        {
            string numCon = InputDialog.mostrar("Ingresa el Numero de Control a buscar: ", "Buscar Egresado"); ;
            try
            {
                ManejadorBD manejador = new ManejadorBD();
                List<Egresado>  lista = manejador.mostrarEgresados();
                Egresado egr = new Egresado().buscar(lista,numCon);
                new DatosEgresado(egr.NumControl, egr.NombreCompleto, egr.FechaEgreso, egr.Carrera.NombreCarrera).Show();
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex);
            }
        }

        //Busca un alumno
        private void buscarAlumnoToolStripMenuItem_Click(object sender, EventArgs e)
        {
            string numCon = InputDialog.mostrar("Ingresa el Numero de Control a buscar: ","Buscar Alumno");
            try
            {
                ManejadorBD manejador = new ManejadorBD();
                List<Alumno> lista = manejador.mostrarAlumnos();
                Alumno alm = new Alumno().buscar(lista,numCon);
                new DatosAlumno(alm.NumControl, alm.NombreCompleto, alm.Semestre, alm.Carrera.NombreCarrera).Show();
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex);
            }
        }

        //Elimina un alumno
        private void btnEliminar_Click(object sender, EventArgs e)
        {
            string numCon = InputDialog.mostrar("Ingresa el Numero de Control a eliminar: ", "Eliminar Alumno");
            try
            {
                ManejadorBD manejador = new ManejadorBD();
                List<Calificaciones> cals = manejador.listaCalificaciones();
                if (new Alumno().puedeEliminar(numCon,cals))
                {
                    List<Alumno> lista = manejador.mostrarAlumnos();
                    Alumno alm = new Alumno().buscar(lista, numCon);
                    new EliminarAlumno(alm.NumControl, alm.NombreCompleto, alm.Semestre, alm.Carrera.NombreCarrera).Show();
                }
                else
                {
                    MessageBox.Show("El alumno no se puede eliminar");
                }
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex);
            }
        }

        // Genera el reporte Listado Egresados
        private void listadoToolStripMenuItem_Click(object sender, EventArgs e)
        {
            saveFileDialog1.Title = "Guardar listado de egresados";
            saveFileDialog1.FileName = "ListaEgresados.pdf";
            if (saveFileDialog1.ShowDialog() == DialogResult.OK)
            {
                try
                {
                    ManejadorBD manager = new ManejadorBD();

                    Egresados reportesE = new Egresados();

                    reportesE.listado(saveFileDialog1.FileName, manager.mostrarEgresados());

                    MessageBox.Show("Reporte Generado");
                }
                catch (Exception ex)
                {
                    MessageBox.Show("Error al generar el reporte");
                    Console.WriteLine(ex);
                }
            }
        }

        //Genera el reporte de recientes por carrera
        private void recientesPorCarreraToolStripMenuItem_Click(object sender, EventArgs e)
        {
            saveFileDialog1.Title = "Guardar Recientes por Carrera";
            saveFileDialog1.FileName = "RecientesPorCarrera.pdf";
            if (saveFileDialog1.ShowDialog() == DialogResult.OK)
            {
                try
                {
                    ManejadorBD manager = new ManejadorBD();//Manejador
                    List<Egresado> egresados = manager.mostrarEgresados();
                    foreach (Egresado item in egresados)
                    {
                        item.Generacion = item.SacarGeneracion(item.FechaEgreso);
                    }
                    egresados = new Egresado().ordenarGeneracion(egresados);

                    Egresados reportesE = new Egresados();//Para generar PDF

                    reportesE.recientes(saveFileDialog1.FileName,egresados, manager.ListaCarreras());//Crear el PDF

                    MessageBox.Show("Reporte Generado");
                }
                catch (Exception ex)
                {
                    MessageBox.Show("Error al generar el reporte");
                    Console.WriteLine(ex);
                }
            }
        }

        //Avance de calificaciones de un alumno
        private void avanceDeCalificacionesToolStripMenuItem_Click(object sender, EventArgs e)
        {
            string numCon = InputDialog.mostrar("Ingresa el Numero de Control: ", "Buscar Alumno");
            saveFileDialog1.Title = "Guardar Avance de Calificaciones";
            saveFileDialog1.FileName = "Avance de "+numCon+".pdf";

            if (saveFileDialog1.ShowDialog() == DialogResult.OK)
            {
                try
                {
                    ManejadorBD manejador = new ManejadorBD();
                    List<Calificaciones> listaCalificaciones = manejador.mostrarCalificaciones(numCon);
                    List<Alumno> listaAlumnos = manejador.mostrarAlumnos();
                    Alumno alumno = new Alumno().buscar(listaAlumnos, numCon);

                    float promedio = 0;
                    foreach (Calificaciones calf in listaCalificaciones)
                    {
                        promedio += calf.Calificacion;
                    }

                    if (promedio != 0)
                    {
                        promedio /= listaCalificaciones.Count();
                    }
                    
                    Alumnos reporte = new Alumnos();
                    reporte.AvanceCalif(saveFileDialog1.FileName,alumno, listaCalificaciones, promedio);

                    MessageBox.Show("Reporte Generado");
                }
                catch (Exception ex)
                {
                    MessageBox.Show("Error al generar el reporte");
                    Console.WriteLine(ex);
                }
            }
        }

        //Sacar los mejores 10 promedios
        private void top10PromediosToolStripMenuItem_Click(object sender, EventArgs e)
        {
            saveFileDialog1.Title = "Guardar Top 10 Calificaciones";
            saveFileDialog1.FileName = "Top 10 Calificaciones.pdf";
            if (saveFileDialog1.ShowDialog() == DialogResult.OK)
            {
                try
                {
                    ManejadorBD manejador = new ManejadorBD();
                    List<Alumno> listaAlumno = manejador.mostrarAlumnos();
                    List<Calificaciones> listaCalificaciones = manejador.listaCalificaciones();

                    List<Promedio> listaPromedios = new Promedio().listaPromedios(listaAlumno, listaCalificaciones);
                    List<Promedio> listaTop = new Promedio().top10(listaPromedios);

                    Alumnos reporte = new Alumnos();
                    reporte.Top10(saveFileDialog1.FileName, listaTop);

                    MessageBox.Show("Reporte Generado");
                }
                catch (Exception ex)
                {
                    MessageBox.Show("Error al generar el reporte");
                    Console.WriteLine(ex);
                }
            }
        }

        //Porcentaje de Reprobacion
        private void porcentajeReprobacionToolStripMenuItem_Click(object sender, EventArgs e)
        {
            saveFileDialog1.Title = "Guardar Porcentaje de Reprobacion";
            saveFileDialog1.FileName = "Porcentaje de Reprobacion.pdf";
            if (saveFileDialog1.ShowDialog() == DialogResult.OK)
            {
                try
                {
                    ManejadorBD manejador = new ManejadorBD();
                    List<Calificaciones> listaCalificaciones = manejador.listaCalificaciones();
                    List<Materia> listaMaterias = manejador.listaMaterias();

                    List<float> listaPorcentaje = new List<float>();
                    foreach (Materia materia in listaMaterias)
                    {
                        List<Calificaciones> listaCalifMateria = new Calificaciones().listaMateria(listaCalificaciones, materia.Nombre_materia);
                        listaPorcentaje = new Materia().porcentajeReprovacion(listaPorcentaje, listaCalifMateria);
                    }
                    Alumnos reporte = new Alumnos();
                    reporte.PorcentajeReprobacion(saveFileDialog1.FileName, listaPorcentaje, listaMaterias);
                    
                    MessageBox.Show("Reporte Generado");
                }
                catch (Exception ex)
                {
                    MessageBox.Show("Error al generar el reporte");
                    Console.WriteLine(ex);
                }
            }
        }

        //Kardex Individual
        private void individualToolStripMenuItem_Click(object sender, EventArgs e)
        {
            string numCon = InputDialog.mostrar("Ingresa el Numero de Control: ", "Buscar Alumno");
            try
            {
                ManejadorBD manejador = new ManejadorBD();
                List<Egresado> lista = manejador.mostrarEgresados();

                if (new Egresado().Existe(numCon, lista))
                {
                    saveFileDialog1.Title = "Guardar kardex de Calificaciones";
                    saveFileDialog1.FileName = "Kardex de " + numCon + ".pdf";

                    if (saveFileDialog1.ShowDialog() == DialogResult.OK)
                    {
                        Egresado datos = new Egresado().buscar(lista, numCon);
                        List<Calificaciones> calificaciones = manejador.mostrarCalificaciones(datos.NumControl);

                        float promedio = 0;
                        foreach (Calificaciones calf in calificaciones)
                        {
                            promedio += calf.Calificacion;
                        }
                        if (promedio != 0)
                        {
                            promedio /= calificaciones.Count();
                        }

                        Egresados reporte = new Egresados();
                        reporte.kardexCalificaciones(saveFileDialog1.FileName, datos, calificaciones, promedio);

                        MessageBox.Show("Reporte Generado");
                    }
                }
                else
                {
                    MessageBox.Show("No es un Egresado");
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show("Error al generar el reporte");
                Console.WriteLine(ex);
            }
        }

        //Top 10 por Carrera
        private void top10PorCarreraToolStripMenuItem_Click(object sender, EventArgs e)
        {
            saveFileDialog1.Title = "Guardar TOP 10 por Carrera";
            saveFileDialog1.FileName = "TOP 10 por Carrera.pdf";

            if (saveFileDialog1.ShowDialog() == DialogResult.OK)
            {

                try
                {
                    ManejadorBD manejador = new ManejadorBD();
                    List<Carrera> carreras = manejador.ListaCarreras();
                    List<Calificaciones> calificaciones = new Egresado().CalifiEgresados(manejador.listaCalificaciones(), manejador.mostrarEgresados());
                    List<Promedio> promedios = new Promedio().listaPromedios(manejador.mostrarEgresados(), calificaciones);
                    
                    List<List<Promedio>> tops = new List<List<Promedio>>();
                    foreach (Carrera car in carreras)
                    {
                        List<Promedio> top = new Promedio().top10(promedios, car.NombreCarrera);
                        tops.Add(top);
                    }

                    Egresados reporte = new Egresados();
                    reporte.Top10Carrera(saveFileDialog1.FileName, tops, carreras);

                    MessageBox.Show("Reporte Generado");
                }
                catch (Exception ex)
                {
                    MessageBox.Show("Error al generar el reporte");
                    Console.WriteLine(ex);
                }

            }   
        }

        //Reporte por Generacion
        private void porGeneraciónToolStripMenuItem_Click(object sender, EventArgs e)
        {
            saveFileDialog1.Title = "Guardar Egresados por Generacion";
            saveFileDialog1.FileName = "Egresados por Generacion.pdf";
            if (saveFileDialog1.ShowDialog() == DialogResult.OK)
            {
                try
                {
                    ManejadorBD manejador = new ManejadorBD();
                    List<Egresado> egresados = manejador.mostrarEgresados();

                    foreach (Egresado item in egresados)
                    {
                        item.Generacion = item.SacarGeneracion(item.FechaEgreso);
                    }
                    List<String> generaciones = new Egresado().generaciones(egresados);
                    generaciones = ordenarGeneraciones(generaciones);

                    Egresados reporte = new Egresados();
                    reporte.porGeneracion(saveFileDialog1.FileName, egresados, generaciones);
                    
                    MessageBox.Show("Reporte Generado");
                }
                catch (Exception ex)
                {
                    MessageBox.Show("Error al generar el reporte");
                    Console.WriteLine(ex);
                }
            }
        }

        //Ordenar las Generaciones
        private List<String> ordenarGeneraciones(List<String> lista)
        {
            //Convertir años a enteros
            List<int> listaEntera = new List<int>();
            foreach (String item in lista)
            {
                listaEntera.Add(int.Parse(item));
            }

            //Ordenar la lista de enteros
            List<int> listaOrdenada = new List<int>();

            while (listaEntera.Count() != 0)
            {
                int min = 10000;
                int indice = -1;

                for (int i = 0; i < listaEntera.Count(); i++)
                {
                    if (listaEntera[i] <= min)
                    {
                        min = listaEntera[i];
                        indice = i;
                    }
                }
                listaOrdenada.Add(listaEntera[indice]);
                listaEntera.RemoveAt(indice);
            }           
            
            //Convertir la lista ordenada a String
            lista = null;
            lista = new List<string>();
            foreach (int item in listaOrdenada)
            {
                lista.Add("" + item);
            }

            //Regresamos
            return lista;
        }

        private void button1_Click(object sender, EventArgs e)
        {
            new Alimentar_BD().Show();
        }
    }   
}
