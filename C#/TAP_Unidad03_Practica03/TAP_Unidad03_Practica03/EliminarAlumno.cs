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
    public partial class EliminarAlumno : Form
    {
        Alumno alumno;

        public EliminarAlumno()
        {
            InitializeComponent();
        }

        public EliminarAlumno(string numCont, String nomreCompleto, int semestre, String carrera)
        {
            InitializeComponent();

            Carrera car = new Carrera();
            car.NombreCarrera = carrera;

            this.alumno = new Alumno(numCont, nomreCompleto, semestre, car);
        }

        private void EliminarAlumno_Load(object sender, EventArgs e)
        {
            textBoxNumCont.Text = alumno.NumControl;
            textBoxNomCom.Text = alumno.NombreCompleto;
            textBoxSem.Text = "" + alumno.Semestre;
            textBoxCar.Text = alumno.Carrera.NombreCarrera;
        }

        private void btnEliminar_Click(object sender, EventArgs e)
        {
            try
            {
                ManejadorBD manejador = new ManejadorBD();
                if (manejador.eliminarAlumno(alumno.NumControl))
                {
                    MessageBox.Show("Alumno Eliminado correctamente");
                }
                else
                {
                    MessageBox.Show("El alumno no se pudo eliminar");
                }
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex);
            }
            Dispose();
        }
    }
}
