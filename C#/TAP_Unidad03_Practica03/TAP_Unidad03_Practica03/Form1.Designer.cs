namespace TAP_Unidad03_Practica03
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
            this.menuStrip1 = new System.Windows.Forms.MenuStrip();
            this.alumnosToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.reportesToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.avanceDeCalificacionesToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.top10PromediosToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.porcentajeReprobacionToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.buscarAlumnoToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.toolStripSeparator1 = new System.Windows.Forms.ToolStripSeparator();
            this.refrescarToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.egresadosToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.reportesToolStripMenuItem1 = new System.Windows.Forms.ToolStripMenuItem();
            this.listadoToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.recientesPorCarreraToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.kardexToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.individualToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.top10PorCarreraToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.porGeneraciónToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.buscarEgresadoToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.salirToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.dataGridView1 = new System.Windows.Forms.DataGridView();
            this.NumControl = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Nombre = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Semestre = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Carrera = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Calificaciones = new System.Windows.Forms.DataGridViewButtonColumn();
            this.btnInscribir = new System.Windows.Forms.Button();
            this.btnEliminar = new System.Windows.Forms.Button();
            this.btnMostrar = new System.Windows.Forms.Button();
            this.saveFileDialog1 = new System.Windows.Forms.SaveFileDialog();
            this.button1 = new System.Windows.Forms.Button();
            this.menuStrip1.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).BeginInit();
            this.SuspendLayout();
            // 
            // menuStrip1
            // 
            this.menuStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.alumnosToolStripMenuItem,
            this.egresadosToolStripMenuItem,
            this.salirToolStripMenuItem});
            this.menuStrip1.Location = new System.Drawing.Point(0, 0);
            this.menuStrip1.Name = "menuStrip1";
            this.menuStrip1.Size = new System.Drawing.Size(580, 24);
            this.menuStrip1.TabIndex = 5;
            this.menuStrip1.Text = "menuStrip1";
            // 
            // alumnosToolStripMenuItem
            // 
            this.alumnosToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.reportesToolStripMenuItem,
            this.buscarAlumnoToolStripMenuItem,
            this.toolStripSeparator1,
            this.refrescarToolStripMenuItem});
            this.alumnosToolStripMenuItem.Name = "alumnosToolStripMenuItem";
            this.alumnosToolStripMenuItem.Size = new System.Drawing.Size(67, 20);
            this.alumnosToolStripMenuItem.Text = "Alumnos";
            // 
            // reportesToolStripMenuItem
            // 
            this.reportesToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.avanceDeCalificacionesToolStripMenuItem,
            this.top10PromediosToolStripMenuItem,
            this.porcentajeReprobacionToolStripMenuItem});
            this.reportesToolStripMenuItem.Name = "reportesToolStripMenuItem";
            this.reportesToolStripMenuItem.Size = new System.Drawing.Size(162, 22);
            this.reportesToolStripMenuItem.Text = "Reportes";
            // 
            // avanceDeCalificacionesToolStripMenuItem
            // 
            this.avanceDeCalificacionesToolStripMenuItem.Name = "avanceDeCalificacionesToolStripMenuItem";
            this.avanceDeCalificacionesToolStripMenuItem.Size = new System.Drawing.Size(205, 22);
            this.avanceDeCalificacionesToolStripMenuItem.Text = "Avance de Calificaciones";
            this.avanceDeCalificacionesToolStripMenuItem.Click += new System.EventHandler(this.avanceDeCalificacionesToolStripMenuItem_Click);
            // 
            // top10PromediosToolStripMenuItem
            // 
            this.top10PromediosToolStripMenuItem.Name = "top10PromediosToolStripMenuItem";
            this.top10PromediosToolStripMenuItem.Size = new System.Drawing.Size(205, 22);
            this.top10PromediosToolStripMenuItem.Text = "Top 10 promedios";
            this.top10PromediosToolStripMenuItem.Click += new System.EventHandler(this.top10PromediosToolStripMenuItem_Click);
            // 
            // porcentajeReprobacionToolStripMenuItem
            // 
            this.porcentajeReprobacionToolStripMenuItem.Name = "porcentajeReprobacionToolStripMenuItem";
            this.porcentajeReprobacionToolStripMenuItem.Size = new System.Drawing.Size(205, 22);
            this.porcentajeReprobacionToolStripMenuItem.Text = "Porcentaje reprobacion";
            this.porcentajeReprobacionToolStripMenuItem.Click += new System.EventHandler(this.porcentajeReprobacionToolStripMenuItem_Click);
            // 
            // buscarAlumnoToolStripMenuItem
            // 
            this.buscarAlumnoToolStripMenuItem.Name = "buscarAlumnoToolStripMenuItem";
            this.buscarAlumnoToolStripMenuItem.Size = new System.Drawing.Size(162, 22);
            this.buscarAlumnoToolStripMenuItem.Text = "Buscar alumno...";
            this.buscarAlumnoToolStripMenuItem.Click += new System.EventHandler(this.buscarAlumnoToolStripMenuItem_Click);
            // 
            // toolStripSeparator1
            // 
            this.toolStripSeparator1.Name = "toolStripSeparator1";
            this.toolStripSeparator1.Size = new System.Drawing.Size(159, 6);
            // 
            // refrescarToolStripMenuItem
            // 
            this.refrescarToolStripMenuItem.Name = "refrescarToolStripMenuItem";
            this.refrescarToolStripMenuItem.Size = new System.Drawing.Size(162, 22);
            this.refrescarToolStripMenuItem.Text = "Refrescar";
            this.refrescarToolStripMenuItem.Click += new System.EventHandler(this.refrescarToolStripMenuItem_Click);
            // 
            // egresadosToolStripMenuItem
            // 
            this.egresadosToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.reportesToolStripMenuItem1,
            this.buscarEgresadoToolStripMenuItem});
            this.egresadosToolStripMenuItem.Name = "egresadosToolStripMenuItem";
            this.egresadosToolStripMenuItem.Size = new System.Drawing.Size(72, 20);
            this.egresadosToolStripMenuItem.Text = "Egresados";
            // 
            // reportesToolStripMenuItem1
            // 
            this.reportesToolStripMenuItem1.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.listadoToolStripMenuItem,
            this.recientesPorCarreraToolStripMenuItem,
            this.kardexToolStripMenuItem,
            this.porGeneraciónToolStripMenuItem});
            this.reportesToolStripMenuItem1.Name = "reportesToolStripMenuItem1";
            this.reportesToolStripMenuItem1.Size = new System.Drawing.Size(169, 22);
            this.reportesToolStripMenuItem1.Text = "Reportes";
            // 
            // listadoToolStripMenuItem
            // 
            this.listadoToolStripMenuItem.Name = "listadoToolStripMenuItem";
            this.listadoToolStripMenuItem.Size = new System.Drawing.Size(186, 22);
            this.listadoToolStripMenuItem.Text = "Listado";
            this.listadoToolStripMenuItem.Click += new System.EventHandler(this.listadoToolStripMenuItem_Click);
            // 
            // recientesPorCarreraToolStripMenuItem
            // 
            this.recientesPorCarreraToolStripMenuItem.Name = "recientesPorCarreraToolStripMenuItem";
            this.recientesPorCarreraToolStripMenuItem.Size = new System.Drawing.Size(186, 22);
            this.recientesPorCarreraToolStripMenuItem.Text = "Recientes por Carrera";
            this.recientesPorCarreraToolStripMenuItem.Click += new System.EventHandler(this.recientesPorCarreraToolStripMenuItem_Click);
            // 
            // kardexToolStripMenuItem
            // 
            this.kardexToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.individualToolStripMenuItem,
            this.top10PorCarreraToolStripMenuItem});
            this.kardexToolStripMenuItem.Name = "kardexToolStripMenuItem";
            this.kardexToolStripMenuItem.Size = new System.Drawing.Size(186, 22);
            this.kardexToolStripMenuItem.Text = "Kardex";
            // 
            // individualToolStripMenuItem
            // 
            this.individualToolStripMenuItem.Name = "individualToolStripMenuItem";
            this.individualToolStripMenuItem.Size = new System.Drawing.Size(171, 22);
            this.individualToolStripMenuItem.Text = "Individual";
            this.individualToolStripMenuItem.Click += new System.EventHandler(this.individualToolStripMenuItem_Click);
            // 
            // top10PorCarreraToolStripMenuItem
            // 
            this.top10PorCarreraToolStripMenuItem.Name = "top10PorCarreraToolStripMenuItem";
            this.top10PorCarreraToolStripMenuItem.Size = new System.Drawing.Size(171, 22);
            this.top10PorCarreraToolStripMenuItem.Text = "Top 10 por Carrera";
            this.top10PorCarreraToolStripMenuItem.Click += new System.EventHandler(this.top10PorCarreraToolStripMenuItem_Click);
            // 
            // porGeneraciónToolStripMenuItem
            // 
            this.porGeneraciónToolStripMenuItem.Name = "porGeneraciónToolStripMenuItem";
            this.porGeneraciónToolStripMenuItem.Size = new System.Drawing.Size(186, 22);
            this.porGeneraciónToolStripMenuItem.Text = "Por generación";
            this.porGeneraciónToolStripMenuItem.Click += new System.EventHandler(this.porGeneraciónToolStripMenuItem_Click);
            // 
            // buscarEgresadoToolStripMenuItem
            // 
            this.buscarEgresadoToolStripMenuItem.Name = "buscarEgresadoToolStripMenuItem";
            this.buscarEgresadoToolStripMenuItem.Size = new System.Drawing.Size(169, 22);
            this.buscarEgresadoToolStripMenuItem.Text = "Buscar egresado...";
            this.buscarEgresadoToolStripMenuItem.Click += new System.EventHandler(this.buscarEgresadoToolStripMenuItem_Click);
            // 
            // salirToolStripMenuItem
            // 
            this.salirToolStripMenuItem.Name = "salirToolStripMenuItem";
            this.salirToolStripMenuItem.Size = new System.Drawing.Size(41, 20);
            this.salirToolStripMenuItem.Text = "Salir";
            this.salirToolStripMenuItem.Click += new System.EventHandler(this.salirToolStripMenuItem_Click);
            // 
            // dataGridView1
            // 
            this.dataGridView1.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            this.dataGridView1.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dataGridView1.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.NumControl,
            this.Nombre,
            this.Semestre,
            this.Carrera,
            this.Calificaciones});
            this.dataGridView1.Location = new System.Drawing.Point(12, 40);
            this.dataGridView1.Name = "dataGridView1";
            this.dataGridView1.SelectionMode = System.Windows.Forms.DataGridViewSelectionMode.CellSelect;
            this.dataGridView1.Size = new System.Drawing.Size(555, 246);
            this.dataGridView1.TabIndex = 6;
            this.dataGridView1.CellClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.dataGridView1_CellClick);
            // 
            // NumControl
            // 
            this.NumControl.HeaderText = "N° de control";
            this.NumControl.Name = "NumControl";
            // 
            // Nombre
            // 
            this.Nombre.HeaderText = "Nombre Completo";
            this.Nombre.Name = "Nombre";
            // 
            // Semestre
            // 
            this.Semestre.HeaderText = "Semestre";
            this.Semestre.Name = "Semestre";
            // 
            // Carrera
            // 
            this.Carrera.HeaderText = "Carrera";
            this.Carrera.Name = "Carrera";
            // 
            // Calificaciones
            // 
            this.Calificaciones.FlatStyle = System.Windows.Forms.FlatStyle.Popup;
            this.Calificaciones.HeaderText = "Calificaciones";
            this.Calificaciones.Name = "Calificaciones";
            this.Calificaciones.Resizable = System.Windows.Forms.DataGridViewTriState.True;
            this.Calificaciones.SortMode = System.Windows.Forms.DataGridViewColumnSortMode.Automatic;
            this.Calificaciones.Text = "Ver";
            // 
            // btnInscribir
            // 
            this.btnInscribir.BackColor = System.Drawing.Color.MediumAquamarine;
            this.btnInscribir.FlatStyle = System.Windows.Forms.FlatStyle.Popup;
            this.btnInscribir.ForeColor = System.Drawing.Color.White;
            this.btnInscribir.Location = new System.Drawing.Point(315, 323);
            this.btnInscribir.Name = "btnInscribir";
            this.btnInscribir.Size = new System.Drawing.Size(118, 39);
            this.btnInscribir.TabIndex = 9;
            this.btnInscribir.Text = "Inscribir";
            this.btnInscribir.UseVisualStyleBackColor = false;
            this.btnInscribir.Click += new System.EventHandler(this.btnInscribir_Click);
            // 
            // btnEliminar
            // 
            this.btnEliminar.BackColor = System.Drawing.Color.Red;
            this.btnEliminar.FlatStyle = System.Windows.Forms.FlatStyle.Popup;
            this.btnEliminar.ForeColor = System.Drawing.Color.White;
            this.btnEliminar.Location = new System.Drawing.Point(439, 323);
            this.btnEliminar.Name = "btnEliminar";
            this.btnEliminar.Size = new System.Drawing.Size(118, 39);
            this.btnEliminar.TabIndex = 8;
            this.btnEliminar.Text = "Eliminar";
            this.btnEliminar.UseVisualStyleBackColor = false;
            this.btnEliminar.Click += new System.EventHandler(this.btnEliminar_Click);
            // 
            // btnMostrar
            // 
            this.btnMostrar.Location = new System.Drawing.Point(12, 323);
            this.btnMostrar.Name = "btnMostrar";
            this.btnMostrar.Size = new System.Drawing.Size(167, 39);
            this.btnMostrar.TabIndex = 7;
            this.btnMostrar.Text = "Mostrar con Egresados";
            this.btnMostrar.UseVisualStyleBackColor = true;
            this.btnMostrar.Click += new System.EventHandler(this.btnMostrar_Click);
            // 
            // button1
            // 
            this.button1.Location = new System.Drawing.Point(604, 40);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(75, 23);
            this.button1.TabIndex = 10;
            this.button1.Text = "Alimentar";
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.button1_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(580, 374);
            this.Controls.Add(this.button1);
            this.Controls.Add(this.btnInscribir);
            this.Controls.Add(this.btnEliminar);
            this.Controls.Add(this.btnMostrar);
            this.Controls.Add(this.dataGridView1);
            this.Controls.Add(this.menuStrip1);
            this.Name = "Form1";
            this.Text = "Sistema Escolar";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.menuStrip1.ResumeLayout(false);
            this.menuStrip1.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.MenuStrip menuStrip1;
        private System.Windows.Forms.ToolStripMenuItem alumnosToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem reportesToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem avanceDeCalificacionesToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem top10PromediosToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem porcentajeReprobacionToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem buscarAlumnoToolStripMenuItem;
        private System.Windows.Forms.ToolStripSeparator toolStripSeparator1;
        private System.Windows.Forms.ToolStripMenuItem refrescarToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem egresadosToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem reportesToolStripMenuItem1;
        private System.Windows.Forms.ToolStripMenuItem listadoToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem recientesPorCarreraToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem kardexToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem individualToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem top10PorCarreraToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem porGeneraciónToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem buscarEgresadoToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem salirToolStripMenuItem;
        private System.Windows.Forms.DataGridView dataGridView1;
        private System.Windows.Forms.DataGridViewTextBoxColumn NumControl;
        private System.Windows.Forms.DataGridViewTextBoxColumn Nombre;
        private System.Windows.Forms.DataGridViewTextBoxColumn Semestre;
        private System.Windows.Forms.DataGridViewTextBoxColumn Carrera;
        private System.Windows.Forms.DataGridViewButtonColumn Calificaciones;
        private System.Windows.Forms.Button btnInscribir;
        private System.Windows.Forms.Button btnEliminar;
        private System.Windows.Forms.Button btnMostrar;
        private System.Windows.Forms.SaveFileDialog saveFileDialog1;
        private System.Windows.Forms.Button button1;
    }
}

