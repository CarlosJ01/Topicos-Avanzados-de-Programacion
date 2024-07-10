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
    public partial class DatosAlumno : Form
    {
        Alumno alumno;

        public DatosAlumno()
        {
            InitializeComponent();
        }

        public DatosAlumno(string numCont, String nomreCompleto,int semestre, String carrera)
        {
            InitializeComponent();

            Carrera car = new Carrera();
            car.NombreCarrera = carrera;

            this.alumno = new Alumno(numCont,nomreCompleto,semestre,car);
        }

        private void DatosAlumno_Load(object sender, EventArgs e)
        {
            textBoxNumCont.Text = alumno.NumControl;
            textBoxNomCom.Text = alumno.NombreCompleto;
            textBoxSem.Text = ""+alumno.Semestre;
            textBoxCar.Text = alumno.Carrera.NombreCarrera;
        }
    }
}
