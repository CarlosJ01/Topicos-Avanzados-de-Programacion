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

namespace TAP_Unidad03_Practica03
{
    public partial class MostrarCalificaciones : Form
    {
        String numeroControl;
        String nombre;
        List<Calificaciones> lista;

        public MostrarCalificaciones()
        {
            InitializeComponent();
        }

        public MostrarCalificaciones(String numCont, String nombre)
        {
            InitializeComponent();
            this.numeroControl = numCont;
            this.nombre = nombre;
        }

        private void MostrarCalificaciones_Load(object sender, EventArgs e)
        {
            textNumCont.Text = numeroControl;
            textNombre.Text = nombre;

            try
            {
                ManejadorBD manejador = new ManejadorBD();
                lista = manejador.mostrarCalificaciones(numeroControl);

                dataGridView1.RowCount = lista.Count;
              
                for (int i = 0; i < lista.Count; i++)
                {
                    dataGridView1[0, i].Value = lista.ElementAt(i).Id; 
                    dataGridView1[1, i].Value = lista.ElementAt(i).Materia.Nombre_materia;
                    dataGridView1[2, i].Value = lista.ElementAt(i).Calificacion;
                    dataGridView1[3, i].Value = "Eliminar";
                }
    
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex);
            }
        }

        private void dataGridView1_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            try
            {
                DataGridViewButtonCell cell = (DataGridViewButtonCell)dataGridView1.SelectedCells[0];
                ManejadorBD manejador = new ManejadorBD();
                manejador.eliminarCalificacion(lista.ElementAt(cell.RowIndex).Id);
                MostrarCalificaciones_Load(null, null);
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex);
            }
        }

        private void button1_Click(object sender, EventArgs e)
        {
            String id = InputDialog.mostrar("Numero de la Calificacion: ");
            String calif = InputDialog.mostrar("Nueva Calificacion: ");
            try
            {
                ManejadorBD manejador = new ManejadorBD();
                if (manejador.modificarCalificacion(id.Trim(), calif.Trim()))
                {
                    MessageBox.Show("Modificado");
                    MostrarCalificaciones_Load(null, null);
                }
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex);
            }
        }
    }
}
