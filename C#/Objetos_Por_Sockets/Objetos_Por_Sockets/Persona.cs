using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Objetos_Por_Sockets
{
    class Persona
    {
        private String nombre;
        private int edad;
        private bool trabajador;

        public Persona()
        {
            nombre = "";
            edad = 0;
            trabajador = false;
        }

        public string Nombre { get => nombre; set => nombre = value; }
        public int Edad { get => edad; set => edad = value; }
        public bool Trabajador { get => trabajador; set => trabajador = value; }

        public String obtenerCadena
        {
            get
            {
                String cad = nombre + "\t" + edad + "\t" + trabajador;
                return cad;
            }
        }

        public void ingresar(String cad)
        {
            String sub="";
            int ind = 0;

            for (int i = 0; i < cad.Length; i++)
            {   
                if (cad[i] == '\t')
                {
                    if (ind == 0)
                    {
                        nombre = sub.Trim();
                    }
                    if (ind == 1)
                    {
                        edad = int.Parse(sub.Trim());
                    }
                    sub = "";
                    ind++;
                }
                else
                {
                    sub += cad[i];
                }
            }

            trabajador = bool.Parse(sub.Trim());

        }
    }
}
