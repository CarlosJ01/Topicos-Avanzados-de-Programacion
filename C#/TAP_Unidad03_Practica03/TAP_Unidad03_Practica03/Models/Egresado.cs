using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace TAP_Unidad03_Practica03.Models
{
    class Egresado
    {
        //Numero de Control
        private String numControl;
        public String NumControl
        {
            get { return numControl; }
            set { numControl = value; }
        }

        //Nombre completo
        private String nombreCompleto;
        public String NombreCompleto
        {
            get { return nombreCompleto; }
            set { nombreCompleto = value; }
        }

        //Fecha de Egreso
        private String fechaEgreso;
        public String FechaEgreso
        {
            get { return fechaEgreso; }
            set { fechaEgreso = value; }
        }

        //Carrera
        private Carrera carrera;
        public Carrera Carrera
        {
            get { return carrera; }
            set { carrera = value; }
        }

        //Generacion 
        String generacion;
        public String Generacion
        {
            get { return generacion; }
            set { generacion = value; }
        }

        // Constructor (Snippet ctor + tab)
        public Egresado()
        {
        }
        
        // Constructor
        public Egresado(String numControl, String nombreCompleto, String fechaEgreso, Carrera carrera)
        {
            this.numControl = numControl;
            this.nombreCompleto = nombreCompleto;
            this.fechaEgreso = fechaEgreso;
            this.carrera = carrera;
        }

        public Egresado buscar(List<Egresado> lista, String numCont)
        {
            foreach (Egresado encontrado in lista)
            {
                if(numCont == encontrado.numControl)
                {
                    return encontrado;
                }
            }
            return null;
        }

        public bool Existe(String numCont, List<Egresado> lista)
        {
            foreach (Egresado item in lista)
            {
                if (numCont == item.numControl)
                {
                    return true;
                }    
            }
            return false;
        }

        public List<Calificaciones> CalifiEgresados(List<Calificaciones> lista, List<Egresado> egresados)
        {
            for (int i = 0; i < lista.Count(); i++)
            {
                bool encontrado = false;

                foreach (Egresado egresado in egresados)
                {
                    if (egresado.numControl == lista[i].Alumno.NumControl)
                    {
                        encontrado = true;
                    }
                }

                if (encontrado == false)
                {
                    lista.RemoveAt(i);
                }
            }
            return lista;
        }

        //Sacar el año de ingreso
        public String SacarGeneracion(String fecha)
        {
            return fecha.Substring(6,4).Trim();
        }

        //Sacar Generaciones
        public List<String> generaciones(List<Egresado> egresados)
        {
            List<String> lista = new List<string>();

            foreach (Egresado egresado in egresados)
            {
                bool repetido = false;

                foreach(String generacion in lista)
                {
                    if (egresado.Generacion == generacion)
                    {
                        repetido = true;
                    }
                }
                if (repetido == false)
                {
                    lista.Add(egresado.Generacion);
                }
            }

            return lista;
        }

        //Ordenar por generacion
        public List<Egresado> ordenarGeneracion(List<Egresado> lista)
        {
            List<Egresado> ordenada = new List<Egresado>();

            while (lista.Count()!=0)
            {
                int i = -1;
                int indice = -1;
                int max = 0;

                foreach (Egresado item in lista)
                {
                    i++;
                    if (int.Parse(item.Generacion)>=max)
                    {
                        max = int.Parse(item.Generacion);
                        indice = i;
                    }
                }

                ordenada.Add(lista[indice]);
                lista.RemoveAt(indice);
            }

            return ordenada;
        }
    }
}
