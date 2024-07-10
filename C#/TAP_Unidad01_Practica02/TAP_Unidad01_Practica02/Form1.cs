using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace TAP_Unidad01_Practica02
{
    public partial class Form1 : Form
    {
        private Persona var=new Persona();

        public Form1()
        {
            InitializeComponent();
        }

        private void bottonSaludar_Click(object sender, EventArgs e)
        {
            var.Nombre = txtBoxNombre.Text;
            MessageBox.Show("Hola :"+ var.Nombre);
        }

        private void buttonFecha_Click(object sender, EventArgs e)
        {
            var.Edad = int.Parse(txtBoxEdad.Text);
            MessageBox.Show("Año de nacimiento: "+(2018-var.Edad));
        }
    }
}
