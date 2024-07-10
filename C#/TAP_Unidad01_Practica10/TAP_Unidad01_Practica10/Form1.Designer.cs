namespace TAP_Unidad01_Practica10
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
            this.tblProducto = new System.Windows.Forms.DataGridView();
            this.ptrBoxImagen = new System.Windows.Forms.PictureBox();
            this.btnComprar = new System.Windows.Forms.Button();
            this.ColumNombre = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.ColumPrecio = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.ColumCantidad = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Imagen = new System.Windows.Forms.DataGridViewTextBoxColumn();
            ((System.ComponentModel.ISupportInitialize)(this.tblProducto)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.ptrBoxImagen)).BeginInit();
            this.SuspendLayout();
            // 
            // tblProducto
            // 
            this.tblProducto.BackgroundColor = System.Drawing.Color.FromArgb(((int)(((byte)(192)))), ((int)(((byte)(192)))), ((int)(((byte)(0)))));
            this.tblProducto.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.tblProducto.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.ColumNombre,
            this.ColumPrecio,
            this.ColumCantidad,
            this.Imagen});
            this.tblProducto.GridColor = System.Drawing.Color.FromArgb(((int)(((byte)(64)))), ((int)(((byte)(64)))), ((int)(((byte)(0)))));
            this.tblProducto.Location = new System.Drawing.Point(24, 179);
            this.tblProducto.Name = "tblProducto";
            this.tblProducto.SelectionMode = System.Windows.Forms.DataGridViewSelectionMode.FullRowSelect;
            this.tblProducto.Size = new System.Drawing.Size(340, 150);
            this.tblProducto.TabIndex = 0;
            this.tblProducto.CellClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.dataGridView1_CellClick);
            // 
            // ptrBoxImagen
            // 
            this.ptrBoxImagen.Image = global::TAP_Unidad01_Practica10.Properties.Resources.Imagen01;
            this.ptrBoxImagen.Location = new System.Drawing.Point(13, 12);
            this.ptrBoxImagen.Name = "ptrBoxImagen";
            this.ptrBoxImagen.Size = new System.Drawing.Size(172, 144);
            this.ptrBoxImagen.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.ptrBoxImagen.TabIndex = 1;
            this.ptrBoxImagen.TabStop = false;
            // 
            // btnComprar
            // 
            this.btnComprar.Font = new System.Drawing.Font("Comic Sans MS", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnComprar.Location = new System.Drawing.Point(213, 43);
            this.btnComprar.Name = "btnComprar";
            this.btnComprar.Size = new System.Drawing.Size(151, 86);
            this.btnComprar.TabIndex = 2;
            this.btnComprar.Text = "Comprar";
            this.btnComprar.UseVisualStyleBackColor = true;
            this.btnComprar.Click += new System.EventHandler(this.btnComprar_Click);
            // 
            // ColumNombre
            // 
            this.ColumNombre.HeaderText = "Nombre";
            this.ColumNombre.Name = "ColumNombre";
            this.ColumNombre.ReadOnly = true;
            // 
            // ColumPrecio
            // 
            this.ColumPrecio.HeaderText = "Precio";
            this.ColumPrecio.Name = "ColumPrecio";
            this.ColumPrecio.ReadOnly = true;
            // 
            // ColumCantidad
            // 
            this.ColumCantidad.HeaderText = "Cantidad";
            this.ColumCantidad.Name = "ColumCantidad";
            this.ColumCantidad.ReadOnly = true;
            // 
            // Imagen
            // 
            this.Imagen.HeaderText = "Imagen";
            this.Imagen.Name = "Imagen";
            this.Imagen.ReadOnly = true;
            this.Imagen.Visible = false;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.Yellow;
            this.ClientSize = new System.Drawing.Size(391, 341);
            this.Controls.Add(this.btnComprar);
            this.Controls.Add(this.ptrBoxImagen);
            this.Controls.Add(this.tblProducto);
            this.Name = "Form1";
            this.Text = "Form1";
            this.Load += new System.EventHandler(this.Form1_Load);
            ((System.ComponentModel.ISupportInitialize)(this.tblProducto)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.ptrBoxImagen)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.DataGridView tblProducto;
        private System.Windows.Forms.PictureBox ptrBoxImagen;
        private System.Windows.Forms.Button btnComprar;
        private System.Windows.Forms.DataGridViewTextBoxColumn ColumNombre;
        private System.Windows.Forms.DataGridViewTextBoxColumn ColumPrecio;
        private System.Windows.Forms.DataGridViewTextBoxColumn ColumCantidad;
        private System.Windows.Forms.DataGridViewTextBoxColumn Imagen;
    }
}

