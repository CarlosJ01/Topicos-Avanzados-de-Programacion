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
    public partial class ListaCarreras : Form
    {
        public ListaCarreras()
        {
            InitializeComponent();
        }

        //Mostramos la lista de carreras
        private void ListaCarreras_Load(object sender, EventArgs e)
        {
            try
            {
                ManejadorBD manager = new ManejadorBD();
                manager.mostarCarreras(dataGridView1);
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex);
            }
        }

        //Invocamos a la ventana de los alumnos
        private void dataGridView1_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            new NuevoAlumno(
                int.Parse(dataGridView1[0, dataGridView1.SelectedRows[0].Index].Value.ToString()),
                dataGridView1[1, dataGridView1.SelectedRows[0].Index].Value.ToString()
            ).Show();
            Dispose();
        }

        //Cerramos la ventana
        private void ListaCarreras_FormClosing(object sender, FormClosingEventArgs e)
        {
            Dispose();
        }
    }
}
