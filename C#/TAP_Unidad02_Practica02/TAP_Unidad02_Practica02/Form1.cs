using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace TAP_Unidad02_Practica02
{
    public partial class Form1 : Form
    {
        int contador = 120;
        int tiempo = 120;
        Thread h1;
        bool encontrado = false;
        String ganador = "";

        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            //Hilo Vercion 1
            h1 = new Thread(hiloV1);
            h1.Start();
            
            //Hilo vercion 2
            timer1.Start();

            //Hilo Vercion 3
            backgroundWorkerbojack.RunWorkerAsync();
            backgroundWorkerTiroalBlanco.RunWorkerAsync();
            backgroundWorkerBronco.RunWorkerAsync();
        }

        private void hiloV1()
        {
            while (contador > 0)
            {
                Console.WriteLine(contador + "...");
                Thread.Sleep(1000);
                contador--;
            }
        }

        private void timer1_Tick(object sender, EventArgs e)
        {
            if (tiempo > 0)
            {
                labelTiempo.Text = "" + tiempo;
                tiempo--;
            }
            else
            {
                timer1.Stop();
            }
        }

        private void Form1_FormClosing(object sender, FormClosingEventArgs e)
        {
            h1.Abort();
            timer1.Stop();
            backgroundWorkerbojack.CancelAsync();
            backgroundWorkerTiroalBlanco.CancelAsync();
            backgroundWorkerBronco.CancelAsync();
        }

        private void backgroundWorkerJuanCarlos_DoWork(object sender, DoWorkEventArgs e)
        {
            while(tiempo>0 && !backgroundWorkerbojack.CancellationPending)
            {
                backgroundWorkerbojack.ReportProgress(5);
                Thread.Sleep(new Random().Next(500));
            }
        }

        private void backgroundWorkerJuanCarlos_ProgressChanged(object sender, ProgressChangedEventArgs e)
        {
            bojack.Location = new Point(bojack.Location.X + e.ProgressPercentage, bojack.Location.Y);
            if (bojack.Location.X >= 400)
            {
                Form1_FormClosing(null, null);
                ganador = "Bojak";
                encontrado = true;
                gano();
            }
        }

        private void backgroundWorkerTiroalBlanco_DoWork(object sender, DoWorkEventArgs e)
        {
            while (tiempo > 0 && !backgroundWorkerTiroalBlanco.CancellationPending)
            {
                backgroundWorkerTiroalBlanco.ReportProgress(5);
                Thread.Sleep(new Random().Next(500));
            }
        }

        private void backgroundWorkerTiroalBlanco_ProgressChanged(object sender, ProgressChangedEventArgs e)
        {
            tiroAlBlanco.Location = new Point(tiroAlBlanco.Location.X + e.ProgressPercentage, tiroAlBlanco.Location.Y);
            if (tiroAlBlanco.Location.X >= 400)
            {
                Form1_FormClosing(null, null);
                ganador = "Tiro al blanco";
                encontrado = true;
                gano();
            }
        }

        private void backgroundWorkerBronco_DoWork(object sender, DoWorkEventArgs e)
        {
            while (tiempo > 0 && !backgroundWorkerBronco.CancellationPending)
            {
                backgroundWorkerBronco.ReportProgress(5);
                Thread.Sleep(new Random().Next(500));
            }
        }

        private void backgroundWorkerBronco_ProgressChanged(object sender, ProgressChangedEventArgs e)
        {
            bronco.Location = new Point(bronco.Location.X + e.ProgressPercentage, bronco.Location.Y);
            if (bronco.Location.X >= 400)
            {
                Form1_FormClosing(null, null);
                ganador = "Bronco";
                encontrado = true;
                gano();
            }
        }

        private void gano()
        {
            MessageBox.Show("Gano : " + ganador); 
        }

        private void backgroundWorkerbojack_RunWorkerCompleted(object sender, RunWorkerCompletedEventArgs e)
        {
            bojack.Location = new Point(bronco.Location.X, bronco.Location.Y);
        }
    }
}
