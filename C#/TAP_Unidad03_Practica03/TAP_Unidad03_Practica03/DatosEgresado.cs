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
    public partial class DatosEgresado : Form
    {
        Egresado egresado=null;

        public DatosEgresado()
        {
            InitializeComponent();
        }

        public DatosEgresado(string numCont, String nomreCompleto, String fechaEgreso, String carrera)
        {
            InitializeComponent();

            Carrera car = new Carrera();
            car.NombreCarrera = carrera;

            this.egresado = new Egresado(numCont, nomreCompleto, fechaEgreso, car);
        }

        private void DatosEgresado_Load(object sender, EventArgs e)
        {
            textBoxNumCont.Text = egresado.NumControl;
            textBoxNomCom.Text = egresado.NombreCompleto;
            textBoxFecEgr.Text = egresado.FechaEgreso;
            textBoxCar.Text = egresado.Carrera.NombreCarrera;
        }
    }
}
