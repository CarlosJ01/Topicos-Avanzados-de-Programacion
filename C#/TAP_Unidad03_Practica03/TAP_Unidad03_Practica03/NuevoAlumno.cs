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
    public partial class NuevoAlumno : Form
    {

        private int idCarrera;//Aguarda el id de la carrera
        private String carrera;//Aguarda la carrera

        public NuevoAlumno(int v)
        {
            InitializeComponent();
        }

        //Construcctor para recivir los datos
        public NuevoAlumno(int idCarrera, String carrera)
        {
            InitializeComponent();

            this.idCarrera = idCarrera;
            this.carrera = carrera;

            Console.WriteLine("Id Carrera: " + idCarrera);
            Console.WriteLine("Carrera: " + carrera);
        }

        private void NuevoAlumno_FormClosing(object sender, FormClosingEventArgs e)
        {
            Dispose();
        }

        private void btnGuardar_Click(object sender, EventArgs e)
        {
            Alumno alumno = new Alumno();
            alumno.NumControl = tbNumControl.Text;
            alumno.NombreCompleto = tbNombre.Text;
            alumno.Semestre = (int)numericSemestre.Value;
            alumno.Carrera = new Carrera(idCarrera, carrera);

            try
            {
                ManejadorBD manager = new ManejadorBD();
                if (manager.nuevoAlumno(alumno) > 0)
                {
                    MessageBox.Show("Se inscribio un nuevo alumno a la carrera de " + carrera);
                }
                else
                {
                    MessageBox.Show("Hubo un error, intentelo más tade");
                }
                Dispose();
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex);
            }
        }
    }
}
