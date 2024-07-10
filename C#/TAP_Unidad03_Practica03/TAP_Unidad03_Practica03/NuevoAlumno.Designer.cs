namespace TAP_Unidad03_Practica03
{
    partial class NuevoAlumno
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
            this.btnGuardar = new System.Windows.Forms.Button();
            this.label3 = new System.Windows.Forms.Label();
            this.numericSemestre = new System.Windows.Forms.NumericUpDown();
            this.label2 = new System.Windows.Forms.Label();
            this.tbNumControl = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.tbNombre = new System.Windows.Forms.TextBox();
            ((System.ComponentModel.ISupportInitialize)(this.numericSemestre)).BeginInit();
            this.SuspendLayout();
            // 
            // btnGuardar
            // 
            this.btnGuardar.BackColor = System.Drawing.Color.MediumAquamarine;
            this.btnGuardar.FlatStyle = System.Windows.Forms.FlatStyle.Popup;
            this.btnGuardar.Location = new System.Drawing.Point(12, 142);
            this.btnGuardar.Name = "btnGuardar";
            this.btnGuardar.Size = new System.Drawing.Size(360, 49);
            this.btnGuardar.TabIndex = 13;
            this.btnGuardar.Text = "Guardar";
            this.btnGuardar.UseVisualStyleBackColor = false;
            this.btnGuardar.Click += new System.EventHandler(this.btnGuardar_Click);
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(216, 78);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(109, 13);
            this.label3.TabIndex = 12;
            this.label3.Text = "Semestre del Alumno:";
            // 
            // numericSemestre
            // 
            this.numericSemestre.Location = new System.Drawing.Point(219, 94);
            this.numericSemestre.Name = "numericSemestre";
            this.numericSemestre.Size = new System.Drawing.Size(153, 20);
            this.numericSemestre.TabIndex = 11;
            this.numericSemestre.Value = new decimal(new int[] {
            1,
            0,
            0,
            0});
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(12, 78);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(153, 13);
            this.label2.TabIndex = 10;
            this.label2.Text = "Número de Control del Alumno:";
            // 
            // tbNumControl
            // 
            this.tbNumControl.Location = new System.Drawing.Point(12, 94);
            this.tbNumControl.Name = "tbNumControl";
            this.tbNumControl.Size = new System.Drawing.Size(156, 20);
            this.tbNumControl.TabIndex = 9;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(12, 15);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(149, 13);
            this.label1.TabIndex = 8;
            this.label1.Text = "Nombre Completo del Alumno:";
            // 
            // tbNombre
            // 
            this.tbNombre.Location = new System.Drawing.Point(12, 31);
            this.tbNombre.Name = "tbNombre";
            this.tbNombre.Size = new System.Drawing.Size(360, 20);
            this.tbNombre.TabIndex = 7;
            // 
            // NuevoAlumno
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(393, 213);
            this.Controls.Add(this.btnGuardar);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.numericSemestre);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.tbNumControl);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.tbNombre);
            this.Name = "NuevoAlumno";
            this.Text = "Nuevo Alumno";
            this.FormClosing += new System.Windows.Forms.FormClosingEventHandler(this.NuevoAlumno_FormClosing);
            ((System.ComponentModel.ISupportInitialize)(this.numericSemestre)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button btnGuardar;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.NumericUpDown numericSemestre;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.TextBox tbNumControl;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox tbNombre;
    }
}