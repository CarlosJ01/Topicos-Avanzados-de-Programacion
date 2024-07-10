using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using System.Windows.Forms;//Libreria de interfaces graficas

namespace TAP_Unidad01_Practica06
{
    class Program : Form//Hereda(:) de Form
    {
        public Program()
        {
            this.ClientSize = new System.Drawing.Size(400,400);//Dar tamaño a la ventana
            Button btn = new Button();//Crear un boton
            btn.Location = new System.Drawing.Point(200, 200);//Tamaño del boton 
            btn.Text = "Hola";//Dar nombre a un boton
            Controls.Add(btn);//Añadir el boton a los controles
            btn.Click += new System.EventHandler(this.miClick);//Añadir un evento al boton con un clik
        }

        private void miClick(object sender, EventArgs e)
        {
            MessageBox.Show("Hola GUI");
        }

        static void Main(string[] args)
        {
            Application.Run(new Program());//Crar una ventana y que pause el programa
        }
    }
}
