namespace TAP_Unidad03_Practica03
{
    partial class DatosAlumno
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
            this.textBoxCar = new System.Windows.Forms.TextBox();
            this.label4 = new System.Windows.Forms.Label();
            this.textBoxSem = new System.Windows.Forms.TextBox();
            this.label3 = new System.Windows.Forms.Label();
            this.textBoxNomCom = new System.Windows.Forms.TextBox();
            this.label2 = new System.Windows.Forms.Label();
            this.textBoxNumCont = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.pictureBox1 = new System.Windows.Forms.PictureBox();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).BeginInit();
            this.SuspendLayout();
            // 
            // textBoxCar
            // 
            this.textBoxCar.Location = new System.Drawing.Point(308, 225);
            this.textBoxCar.Name = "textBoxCar";
            this.textBoxCar.Size = new System.Drawing.Size(280, 20);
            this.textBoxCar.TabIndex = 16;
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(305, 209);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(41, 13);
            this.label4.TabIndex = 15;
            this.label4.Text = "Carrera";
            // 
            // textBoxSem
            // 
            this.textBoxSem.Location = new System.Drawing.Point(308, 162);
            this.textBoxSem.Name = "textBoxSem";
            this.textBoxSem.Size = new System.Drawing.Size(280, 20);
            this.textBoxSem.TabIndex = 14;
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(305, 145);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(51, 13);
            this.label3.TabIndex = 13;
            this.label3.Text = "Semestre";
            // 
            // textBoxNomCom
            // 
            this.textBoxNomCom.Location = new System.Drawing.Point(308, 93);
            this.textBoxNomCom.Name = "textBoxNomCom";
            this.textBoxNomCom.Size = new System.Drawing.Size(280, 20);
            this.textBoxNomCom.TabIndex = 12;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(305, 76);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(91, 13);
            this.label2.TabIndex = 11;
            this.label2.Text = "Nombre Completo";
            // 
            // textBoxNumCont
            // 
            this.textBoxNumCont.Location = new System.Drawing.Point(308, 29);
            this.textBoxNumCont.Name = "textBoxNumCont";
            this.textBoxNumCont.Size = new System.Drawing.Size(280, 20);
            this.textBoxNumCont.TabIndex = 10;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(305, 12);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(95, 13);
            this.label1.TabIndex = 9;
            this.label1.Text = "Numero de Control";
            // 
            // pictureBox1
            // 
            this.pictureBox1.Image = global::TAP_Unidad03_Practica03.Properties.Resources.ponys;
            this.pictureBox1.Location = new System.Drawing.Point(12, 12);
            this.pictureBox1.Name = "pictureBox1";
            this.pictureBox1.Size = new System.Drawing.Size(265, 242);
            this.pictureBox1.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pictureBox1.TabIndex = 17;
            this.pictureBox1.TabStop = false;
            // 
            // DatosAlumno
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(620, 277);
            this.Controls.Add(this.pictureBox1);
            this.Controls.Add(this.textBoxCar);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.textBoxSem);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.textBoxNomCom);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.textBoxNumCont);
            this.Controls.Add(this.label1);
            this.Name = "DatosAlumno";
            this.Text = "DatosAlumno";
            this.Load += new System.EventHandler(this.DatosAlumno_Load);
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.PictureBox pictureBox1;
        private System.Windows.Forms.TextBox textBoxCar;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.TextBox textBoxSem;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.TextBox textBoxNomCom;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.TextBox textBoxNumCont;
        private System.Windows.Forms.Label label1;
    }
}