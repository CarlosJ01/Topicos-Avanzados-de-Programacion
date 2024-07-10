using Newtonsoft.Json.Linq;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Net;
using System.Net.Sockets;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace TAP_Unidad02_Tarea06
{

    public partial class Form1 : Form
    {
        private String mensaje = "";

        public Form1()
        {
            InitializeComponent();
        }

        private void backgroundWorker1_DoWork(object sender, DoWorkEventArgs e)
        {

            while (!backgroundWorker1.CancellationPending)
            {
                try
                {
                    //Iniciar el servidor
                    Socket servidor = new Socket(AddressFamily.InterNetwork, SocketType.Stream, ProtocolType.Tcp);
                    IPEndPoint ip = new IPEndPoint(IPAddress.Parse("127.0.0.1"), 1235);

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

                    mensaje = msg;//Asignamos el mensaje
                    backgroundWorker1.ReportProgress(1);//Reporta progreso

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

        private void backgroundWorker1_ProgressChanged(object sender, ProgressChangedEventArgs e)
        {
            //Imprimir--------------------------------------------------
            Label label = new Label();
            label.Text = mensaje;
            label.TextAlign = ContentAlignment.MiddleRight;
            label.AutoSize = false;
            label.Size = new Size(flowLayoutPanel1.Width, 15);
            label.BackColor = Color.Black;
            label.ForeColor = Color.White;

            flowLayoutPanel1.Controls.Add(label);
            //------------------------------------------------------------
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            backgroundWorker1.RunWorkerAsync();
        }

        private void Form1_FormClosing(object sender, FormClosingEventArgs e)
        {
            if (backgroundWorker1.CancellationPending)
            {
                backgroundWorker1.CancelAsync();
            }
        }

        private void buttonEnviar_MouseClick(object sender, MouseEventArgs e)
        {
            JObject json = new JObject();
            json.Add("Lenguaje","C#");
            json.Add("Flotante", 123.45);
            json.Add("Resive","Java");

            String msg = json.ToString();

            Console.WriteLine(msg);

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
