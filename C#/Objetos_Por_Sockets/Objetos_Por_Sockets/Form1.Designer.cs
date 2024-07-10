namespace Objetos_Por_Sockets
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
            this.label1 = new System.Windows.Forms.Label();
            this.textBoxEnviar = new System.Windows.Forms.TextBox();
            this.textBoxResive = new System.Windows.Forms.TextBox();
            this.label2 = new System.Windows.Forms.Label();
            this.Servidor = new System.ComponentModel.BackgroundWorker();
            this.button1 = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(12, 16);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(37, 13);
            this.label1.TabIndex = 0;
            this.label1.Text = "Enviar";
            // 
            // textBoxEnviar
            // 
            this.textBoxEnviar.Location = new System.Drawing.Point(15, 32);
            this.textBoxEnviar.Name = "textBoxEnviar";
            this.textBoxEnviar.Size = new System.Drawing.Size(265, 20);
            this.textBoxEnviar.TabIndex = 1;
            // 
            // textBoxResive
            // 
            this.textBoxResive.Location = new System.Drawing.Point(12, 241);
            this.textBoxResive.Name = "textBoxResive";
            this.textBoxResive.Size = new System.Drawing.Size(265, 20);
            this.textBoxResive.TabIndex = 3;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(9, 225);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(39, 13);
            this.label2.TabIndex = 2;
            this.label2.Text = "Resivir";
            // 
            // Servidor
            // 
            this.Servidor.WorkerReportsProgress = true;
            this.Servidor.WorkerSupportsCancellation = true;
            this.Servidor.DoWork += new System.ComponentModel.DoWorkEventHandler(this.Servidor_DoWork);
            this.Servidor.ProgressChanged += new System.ComponentModel.ProgressChangedEventHandler(this.Servidor_ProgressChanged);
            // 
            // button1
            // 
            this.button1.Location = new System.Drawing.Point(64, 116);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(177, 47);
            this.button1.TabIndex = 4;
            this.button1.Text = "Enviar";
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.button1_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(306, 324);
            this.Controls.Add(this.button1);
            this.Controls.Add(this.textBoxResive);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.textBoxEnviar);
            this.Controls.Add(this.label1);
            this.Name = "Form1";
            this.Text = "Form1";
            this.FormClosing += new System.Windows.Forms.FormClosingEventHandler(this.Form1_FormClosing);
            this.Load += new System.EventHandler(this.Form1_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox textBoxEnviar;
        private System.Windows.Forms.TextBox textBoxResive;
        private System.Windows.Forms.Label label2;
        private System.ComponentModel.BackgroundWorker Servidor;
        private System.Windows.Forms.Button button1;
    }
}

