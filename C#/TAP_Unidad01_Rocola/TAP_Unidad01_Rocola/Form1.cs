using Newtonsoft.Json;
using Newtonsoft.Json.Linq;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace TAP_Unidad01_Rocola
{
    public partial class Form1 : Form
    {
        private String url = @"C:\Users\Carlos J\source\repos\TAP_Unidad01_Rocola\Canciones";
        private String[] nomCanciones = null;
        private String[] urlCanciones = null;

        public Form1()
        {
            InitializeComponent();
            CenterToScreen();//Centrar la Ventana
            //Cambiar el fondo
            Bitmap fondo = new Bitmap("C:\\Users\\Carlos J\\source\\repos\\TAP_Unidad01_Rocola\\Imagenes\\Fondo.jpg");//Abrir la imagen
            this.BackgroundImage = fondo;//Asignar la imagen al fondo
            this.BackgroundImageLayout = ImageLayout.Center;//Centrar la imagen
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            
        }

        private void btnBuscar_Click(object sender, EventArgs e)
        {
            switch (comboBoxGenero.SelectedIndex)
            {
                case 1:
                        extraerCanciones("Clasicas");
                        imprimirEnLista();
                    break;
                case 2:
                        extraerCanciones("Fandub");
                        imprimirEnLista();
                    break;
                case 3:
                        extraerCanciones("Internacional");
                        imprimirEnLista();
                    break;
                case 4:
                        extraerCanciones("Japanese");
                        imprimirEnLista();
                    break;
                case 5:
                        extraerCanciones("K-Pop");
                        imprimirEnLista();
                    break;
                case 6:
                        extraerCanciones("Metal");
                        imprimirEnLista();
                    break;
                case 7:
                        extraerTodasCanciones();
                        imprimirEnLista();
                    break;
            }
        }

        private void imprimirEnLista()
        {
            string aux="";
            int k=0;
            nomCanciones=new string[urlCanciones.Length];
            for (int i = 0; i < urlCanciones.Length; i++)
            {
                for (int j = 0; j < urlCanciones[i].Length; j++)
                {
                    if (urlCanciones[i][j] != '\\')
                    {
                        aux += urlCanciones[i][j];
                    }
                    if (urlCanciones[i][j] == '\\')
                    {
                            aux = "";
                    }
                    if (urlCanciones[i][j] == '.')
                    {
                        nomCanciones[k] = aux;
                        k++;
                        break;
                    }
                }
            }
            listCanciones.Items.Clear();
            foreach (var nombre in nomCanciones)
            {
                listCanciones.Items.Add(nombre);//Recorre el arreglo de nombres de los archivos y las añade a la lista
            }

        }

        private void extraerTodasCanciones()
        {
            urlCanciones = Directory.GetFiles(url, "*.mp3", SearchOption.AllDirectories);
        }

        private void extraerCanciones(string genero)
        {
            urlCanciones = Directory.GetFiles(url+"\\"+genero,"*.mp3");
        }

        private void listCanciones_SelectedIndexChanged(object sender, EventArgs e)
        {
            reproductor.URL = urlCanciones[listCanciones.SelectedIndex];
        }

        private void comboBoxGenero_SelectedIndexChanged(object sender, EventArgs e)
        {

        }
    }
}
