using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TAP_Unidad01_Practica02
{
    public class Persona
     {

        //Nombre de la persona
        private String nombre;

        public String Nombre
        {
            get { return nombre; }
            set { nombre = value; }
        }

        //Edad de la Persona
        private int edad;

        public int Edad
        {
            get { return edad; }
            set { edad = value; }
        }

    }
}