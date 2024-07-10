using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TAP_Unidad03_Practica03.Models
{
    class Carrera
    {
        //Id
        private int id;
        public int Id
        {
            get { return id; }
            set { id = value; }
        }

        //Nombre de la Carrera
        private String nombreCarrera;
        public String NombreCarrera
        {
            get { return nombreCarrera; }
            set { nombreCarrera = value; }
        }

        // Constructor
        public Carrera() { }

        // Constructor con parametros
        public Carrera(int id, String nombreCarrera)
        {
            this.id = id;
            this.nombreCarrera = nombreCarrera;
        }
    }
}
