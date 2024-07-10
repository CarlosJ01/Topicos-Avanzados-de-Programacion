namespace TAP_Unidad03_Practica03
{
    partial class DatosEgresado
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.label1 = new System.Windows.Forms.Label();
            this.textBoxNumCont = new System.Windows.Forms.TextBox();
            this.textBoxNomCom = new System.Windows.Forms.TextBox();
            this.label2 = new System.Windows.Forms.Label();
            this.textBoxFecEgr = new System.Windows.Forms.TextBox();
            this.label3 = new System.Windows.Forms.Label();
            this.textBoxCar = new System.Windows.Forms.TextBox();
            this.label4 = new System.Windows.Forms.Label();
            this.pictureBox1 = new System.Windows.Forms.PictureBox();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).BeginInit();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(305, 6);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(95, 13);
            this.label1.TabIndex = 0;
            this.label1.Text = "Numero de Control";
            // 
            // textBoxNumCont
            // 
            this.textBoxNumCont.Location = new System.Drawing.Point(308, 23);
            this.textBoxNumCont.Name = "textBoxNumCont";
            this.textBoxNumCont.Size = new System.Drawing.Size(280, 20);
            this.textBoxNumCont.TabIndex = 1;
            // 
            // textBoxNomCom
            // 
            this.textBoxNomCom.Location = new System.Drawing.Point(308, 87);
            this.textBoxNomCom.Name = "textBoxNomCom";
            this.textBoxNomCom.Size = new System.Drawing.Size(280, 20);
            this.textBoxNomCom.TabIndex = 3;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(305, 70);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(91, 13);
            this.label2.TabIndex = 2;
            this.label2.Text = "Nombre Completo";
            // 
            // textBoxFecEgr
            // 
            this.textBoxFecEgr.Location = new System.Drawing.Point(308, 156);
            this.textBoxFecEgr.Name = "textBoxFecEgr";
            this.textBoxFecEgr.Size = new System.Drawing.Size(280, 20);
            this.textBoxFecEgr.TabIndex = 5;
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(305, 139);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(88, 13);
            this.label3.TabIndex = 4;
            this.label3.Text = "Fecha de Egreso";
            // 
            // textBoxCar
            // 
            this.textBoxCar.Location = new System.Drawing.Point(308, 219);
            this.textBoxCar.Name = "textBoxCar";
            this.textBoxCar.Size = new System.Drawing.Size(280, 20);
            this.textBoxCar.TabIndex = 7;
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(305, 203);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(41, 13);
            this.label4.TabIndex = 6;
            this.label4.Text = "Carrera";
            // 
            // pictureBox1
            // 
            this.pictureBox1.Image = global::TAP_Unidad03_Practica03.Properties.Resources.ponys;
            this.pictureBox1.Location = new System.Drawing.Point(12, 6);
            this.pictureBox1.Name = "pictureBox1";
            this.pictureBox1.Size = new System.Drawing.Size(265, 242);
            this.pictureBox1.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pictureBox1.TabIndex = 8;
            this.pictureBox1.TabStop = false;
            // 
            // DatosEgresado
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(600, 267);
            this.Controls.Add(this.pictureBox1);
            this.Controls.Add(this.textBoxCar);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.textBoxFecEgr);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.textBoxNomCom);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.textBoxNumCont);
            this.Controls.Add(this.label1);
            this.Name = "DatosEgresado";
            this.Text = "DatosEgresado";
            this.Load += new System.EventHandler(this.DatosEgresado_Load);
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox textBoxNumCont;
        private System.Windows.Forms.TextBox textBoxNomCom;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.TextBox textBoxFecEgr;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.TextBox textBoxCar;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.PictureBox pictureBox1;
    }
}