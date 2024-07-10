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

namespace TAP_Unidad01_Practica10
{
    public partial class Form1 : Form
    {
        private JArray publiaciones=null;

        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            try
            {
                StreamReader lector = new StreamReader(@"C:\Users\Carlos J\Documents\NetBeansProjects\TAP_Unidad01_Practica09\Publicaciones.json");//Opjeto para leer un archivo @para quitar la \\
                String datos = lector.ReadToEnd();//Leer todo el archivo
                lector.Close();

                publiaciones = JArray.Parse(datos);//Convertir la cadena al arreglo de JSON
                tblProducto.RowCount = publiaciones.Count;
                //Mostrar los json
                for (int i = 0; i < publiaciones.Count/*Longitud del arreglo*/; i++)
                {
                    //Console.WriteLine("Publicacion" + i);
                    JObject publicacion = publiaciones[i].Value<JObject>();//Convertir el JArray en JObject
                    JObject producto = publicacion["Producto"].Value<JObject>();
                    tblProducto[0,i].Value = producto["Nombre"];
                    //Console.WriteLine(producto["Nombre"]);
                   
                    tblProducto[1,i].Value = producto["Precio"];
                    //Console.WriteLine(producto["Precio"]);
                    
                    tblProducto[2, i].Value = producto["Cantidad"];
                    //Console.WriteLine(producto["Precio"]);

                    tblProducto[3, i].Value = producto["Imagen"];
                    //Console.WriteLine(producto["Imagen"]);

                    //Console.WriteLine("\n");
                }
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }
        }

        private void dataGridView1_CellClick(object sender, DataGridViewCellEventArgs e)
        {

            int row = tblProducto.SelectedRows[0].Index;
            switch (tblProducto[3,row].Value.ToString())
            {
                case "Imagen01":
                        ptrBoxImagen.Image = global::TAP_Unidad01_Practica10.Properties.Resources.Imagen01;
                    break;
                case "Imagen02":
                        ptrBoxImagen.Image = global::TAP_Unidad01_Practica10.Properties.Resources.Imagen02;
                    break;
                case "Imagen03":
                        ptrBoxImagen.Image = global::TAP_Unidad01_Practica10.Properties.Resources.Imagen03;
                    break;
                case "Imagen04":
                        ptrBoxImagen.Image = global::TAP_Unidad01_Practica10.Properties.Resources.Imagen04;
                    break;
                case "Imagen05":
                        ptrBoxImagen.Image = global::TAP_Unidad01_Practica10.Properties.Resources.Imagen05;
                    break;
            }
        }

        private void btnComprar_Click(object sender, EventArgs e)
        {
            int row = tblProducto.SelectedRows[0].Index;
            JObject publicacion = publiaciones[row].Value<JObject>();//Convertir el JArray en JObject
            JObject producto = publicacion["Producto"].Value<JObject>();
            int cantidad = int.Parse(producto["Cantidad"].ToString());
            cantidad--;
            producto["Cantidad"] = cantidad;
            for (int i = 0; i < publiaciones.Count; i++)
            {
                publicacion = publiaciones[i].Value<JObject>();
                producto = publicacion["Producto"].Value<JObject>();
                tblProducto[0, i].Value = producto["Nombre"];
                tblProducto[1, i].Value = producto["Precio"];
                tblProducto[2, i].Value = producto["Cantidad"];
                tblProducto[3, i].Value = producto["Imagen"];
            }
            sobreEscribir();
        }

        private void sobreEscribir()
        {
            try
            {
                StreamWriter escritor = new StreamWriter(@"C:\Users\Carlos J\Documents\NetBeansProjects\TAP_Unidad01_Practica09\Publicaciones.json");//Abrir el Archivo
                escritor.WriteLine(publiaciones.ToString());
                escritor.Close();
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }
        }

        private void tblProducto_SelectionChanged(object sender, EventArgs e)
        {
            this.dataGridView1_CellClick(null,null);
        }
    }
}
