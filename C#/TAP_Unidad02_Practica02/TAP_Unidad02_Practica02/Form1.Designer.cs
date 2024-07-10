namespace TAP_Unidad02_Practica02
{
    partial class Form1
    {
        /// <summary>
        /// Variable del diseñador necesaria.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Limpiar los recursos que se estén usando.
        /// </summary>
        /// <param name="disposing">true si los recursos administrados se deben desechar; false en caso contrario.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Código generado por el Diseñador de Windows Forms

        /// <summary>
        /// Método necesario para admitir el Diseñador. No se puede modificar
        /// el contenido de este método con el editor de código.
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            this.Label01 = new System.Windows.Forms.Label();
            this.timer1 = new System.Windows.Forms.Timer(this.components);
            this.labelTiempo = new System.Windows.Forms.Label();
            this.backgroundWorkerbojack = new System.ComponentModel.BackgroundWorker();
            this.backgroundWorkerTiroalBlanco = new System.ComponentModel.BackgroundWorker();
            this.backgroundWorkerBronco = new System.ComponentModel.BackgroundWorker();
            this.meta = new System.Windows.Forms.PictureBox();
            this.bronco = new System.Windows.Forms.PictureBox();
            this.tiroAlBlanco = new System.Windows.Forms.PictureBox();
            this.bojack = new System.Windows.Forms.PictureBox();
            ((System.ComponentModel.ISupportInitialize)(this.meta)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.bronco)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.tiroAlBlanco)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.bojack)).BeginInit();
            this.SuspendLayout();
            // 
            // Label01
            // 
            this.Label01.AutoSize = true;
            this.Label01.Font = new System.Drawing.Font("Modern No. 20", 15.75F, ((System.Drawing.FontStyle)((System.Drawing.FontStyle.Bold | System.Drawing.FontStyle.Italic))), System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Label01.Location = new System.Drawing.Point(186, 27);
            this.Label01.Name = "Label01";
            this.Label01.Size = new System.Drawing.Size(92, 24);
            this.Label01.TabIndex = 0;
            this.Label01.Text = "Tiempo :";
            // 
            // timer1
            // 
            this.timer1.Interval = 1000;
            this.timer1.Tick += new System.EventHandler(this.timer1_Tick);
            // 
            // labelTiempo
            // 
            this.labelTiempo.AutoSize = true;
            this.labelTiempo.Font = new System.Drawing.Font("Modern No. 20", 15.75F, ((System.Drawing.FontStyle)((System.Drawing.FontStyle.Bold | System.Drawing.FontStyle.Italic))), System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.labelTiempo.Location = new System.Drawing.Point(287, 27);
            this.labelTiempo.Name = "labelTiempo";
            this.labelTiempo.Size = new System.Drawing.Size(21, 24);
            this.labelTiempo.TabIndex = 1;
            this.labelTiempo.Text = "0";
            // 
            // backgroundWorkerbojack
            // 
            this.backgroundWorkerbojack.WorkerReportsProgress = true;
            this.backgroundWorkerbojack.WorkerSupportsCancellation = true;
            this.backgroundWorkerbojack.DoWork += new System.ComponentModel.DoWorkEventHandler(this.backgroundWorkerJuanCarlos_DoWork);
            this.backgroundWorkerbojack.ProgressChanged += new System.ComponentModel.ProgressChangedEventHandler(this.backgroundWorkerJuanCarlos_ProgressChanged);
            // 
            // backgroundWorkerTiroalBlanco
            // 
            this.backgroundWorkerTiroalBlanco.WorkerReportsProgress = true;
            this.backgroundWorkerTiroalBlanco.WorkerSupportsCancellation = true;
            this.backgroundWorkerTiroalBlanco.DoWork += new System.ComponentModel.DoWorkEventHandler(this.backgroundWorkerTiroalBlanco_DoWork);
            this.backgroundWorkerTiroalBlanco.ProgressChanged += new System.ComponentModel.ProgressChangedEventHandler(this.backgroundWorkerTiroalBlanco_ProgressChanged);
            // 
            // backgroundWorkerBronco
            // 
            this.backgroundWorkerBronco.WorkerReportsProgress = true;
            this.backgroundWorkerBronco.WorkerSupportsCancellation = true;
            this.backgroundWorkerBronco.DoWork += new System.ComponentModel.DoWorkEventHandler(this.backgroundWorkerBronco_DoWork);
            this.backgroundWorkerBronco.ProgressChanged += new System.ComponentModel.ProgressChangedEventHandler(this.backgroundWorkerBronco_ProgressChanged);
            // 
            // meta
            // 
            this.meta.Image = global::TAP_Unidad02_Practica02.Properties.Resources.ap_550x550_12x16_1_transparent_t_u1;
            this.meta.Location = new System.Drawing.Point(408, 12);
            this.meta.Name = "meta";
            this.meta.Size = new System.Drawing.Size(103, 48);
            this.meta.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.meta.TabIndex = 6;
            this.meta.TabStop = false;
            // 
            // bronco
            // 
            this.bronco.Image = global::TAP_Unidad02_Practica02.Properties.Resources.descarga;
            this.bronco.Location = new System.Drawing.Point(12, 287);
            this.bronco.Name = "bronco";
            this.bronco.Size = new System.Drawing.Size(95, 99);
            this.bronco.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.bronco.TabIndex = 4;
            this.bronco.TabStop = false;
            // 
            // tiroAlBlanco
            // 
            this.tiroAlBlanco.Image = global::TAP_Unidad02_Practica02.Properties.Resources.EntireOblongIndianringneckparakeet_size_restricted;
            this.tiroAlBlanco.Location = new System.Drawing.Point(12, 174);
            this.tiroAlBlanco.Name = "tiroAlBlanco";
            this.tiroAlBlanco.Size = new System.Drawing.Size(95, 107);
            this.tiroAlBlanco.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.tiroAlBlanco.TabIndex = 3;
            this.tiroAlBlanco.TabStop = false;
            // 
            // bojack
            // 
            this.bojack.Image = global::TAP_Unidad02_Practica02.Properties.Resources.tenor;
            this.bojack.Location = new System.Drawing.Point(12, 78);
            this.bojack.Name = "bojack";
            this.bojack.Size = new System.Drawing.Size(95, 90);
            this.bojack.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.bojack.TabIndex = 2;
            this.bojack.TabStop = false;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(523, 408);
            this.Controls.Add(this.meta);
            this.Controls.Add(this.bronco);
            this.Controls.Add(this.tiroAlBlanco);
            this.Controls.Add(this.bojack);
            this.Controls.Add(this.labelTiempo);
            this.Controls.Add(this.Label01);
            this.Name = "Form1";
            this.Text = "Form1";
            this.FormClosing += new System.Windows.Forms.FormClosingEventHandler(this.Form1_FormClosing);
            this.Load += new System.EventHandler(this.Form1_Load);
            ((System.ComponentModel.ISupportInitialize)(this.meta)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.bronco)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.tiroAlBlanco)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.bojack)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label Label01;
        private System.Windows.Forms.Timer timer1;
        private System.Windows.Forms.Label labelTiempo;
        private System.Windows.Forms.PictureBox bojack;
        private System.Windows.Forms.PictureBox tiroAlBlanco;
        private System.Windows.Forms.PictureBox bronco;
        private System.ComponentModel.BackgroundWorker backgroundWorkerbojack;
        private System.ComponentModel.BackgroundWorker backgroundWorkerTiroalBlanco;
        private System.ComponentModel.BackgroundWorker backgroundWorkerBronco;
        private System.Windows.Forms.PictureBox meta;
    }
}

