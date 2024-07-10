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

namespace Cliente
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void textBox1_KeyPress(object sender, KeyPressEventArgs e)
        {
            if(e.KeyChar == (char)Keys.Enter)
            {
                button1_MouseClick(sender, null);
            }
        }

        private void button1_MouseClick(object sender, MouseEventArgs e)
        {
            String msg = textBox1.Text;
            textBox1.Text = "";
            try
            {
                //Iniciar el cliente
                Socket cliente = new Socket(AddressFamily.InterNetwork, SocketType.Stream, ProtocolType.Tcp);
                IPEndPoint ip = new IPEndPoint(IPAddress.Parse("127.0.0.1"),1234);

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
