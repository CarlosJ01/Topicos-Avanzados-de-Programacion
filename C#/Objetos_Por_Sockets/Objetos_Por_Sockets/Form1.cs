using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Net;
using System.Net.Sockets;
using System.Runtime.Serialization;
using System.Runtime.Serialization.Formatters.Binary;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Objetos_Por_Sockets
{
    public partial class Form1 : Form
    {
        private Persona persona1;
        private Persona persona2;

        public Form1()
        {
            InitializeComponent();
            persona1 = new Persona();
            persona2 = new Persona();
            persona1.Nombre = "Eren";
            persona1.Edad = 12;
            persona1.Trabajador = true;
            textBoxEnviar.Text = persona1.obtenerCadena;
        }

        private void Servidor_DoWork(object sender, DoWorkEventArgs e)
        {
            while (!Servidor.CancellationPending)
            {
                try
                {
                    //Iniciar el servidor
                    Socket servidor = new Socket(AddressFamily.InterNetwork, SocketType.Stream, ProtocolType.Tcp);
                    IPEndPoint ip = new IPEndPoint(IPAddress.Parse("127.0.0.1"), 1234);

                    servidor.Bind(ip);//Iniciar conexion
                    servidor.Listen(1);//Cuantos mensajes a recibir
                    //Bloqueo

                    Socket canal = servidor.Accept();//Creacion del canal

                    //Leer del canal
                    byte[] buffer = new byte[1024];
                    String msg = "";
                    int bytesRecibidos = 0;
                    do
                    {
                        bytesRecibidos = canal.Receive(buffer, buffer.Length, 0);
                        msg += Encoding.UTF8.GetString(buffer, 0, bytesRecibidos);
                    } while (bytesRecibidos > 0);
                    
                    persona2.ingresar(msg);
                    Servidor.ReportProgress(1);//Reporta progreso

                    canal.Close();
                    servidor.Close();
                }
                catch (Exception ex)
                {
                    Console.WriteLine(ex.Message);
                    throw;
                }
            }
        }

        private void Servidor_ProgressChanged(object sender, ProgressChangedEventArgs e)
        {
            textBoxResive.Text = persona2.obtenerCadena;
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            Servidor.RunWorkerAsync();
        }

        private void Form1_FormClosing(object sender, FormClosingEventArgs e)
        {
            if (Servidor.CancellationPending)
            {
                Servidor.CancelAsync();
            }
        }

        private void button1_Click(object sender, EventArgs e)
        {
            String msg = persona1.obtenerCadena;
            try
            {
                //Iniciar el cliente
                Socket cliente = new Socket(AddressFamily.InterNetwork, SocketType.Stream, ProtocolType.Tcp);
                IPEndPoint ip = new IPEndPoint(IPAddress.Parse("127.0.0.1"), 1234);

                cliente.Connect(ip);

                if (cliente.Connected)
                {
                    byte[] buffer = Encoding.UTF8.GetBytes(msg);//Convertimos la cadena a bytes
                    cliente.Send(buffer, buffer.Length, 0);//Enviamos los bytes
                }

                cliente.Close();//Cerramos el cliente
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }
        }
    }
}
