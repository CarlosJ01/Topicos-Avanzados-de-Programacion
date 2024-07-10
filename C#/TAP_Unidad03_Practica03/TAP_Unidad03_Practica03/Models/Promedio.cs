using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TAP_Unidad03_Practica03.Models
{
    class Promedio
    {
        Alumno alumno;
        Egresado egresado;
        float prom;
        

        public Alumno Alumno
        {
            get { return alumno;}
            set { alumno = value;}
        }

        public float Prom
        {
            get { return prom; }
            set { prom = value; }
        }

        public Egresado Egresado
        {
            get { return egresado; }
            set { egresado = value; }
        }

        public Promedio()
        {

        }

        public Promedio(Alumno alum,float prome)
        {
            this.alumno = alum;
            this.prom = prome;
        }

        public Promedio(Egresado egr, float prome)
        {
            this.egresado = egr;
            this.prom = prome;
        }


        public List<Promedio> listaPromedios(List<Alumno> listaAlumnos,List<Calificaciones> listaCalificaciones)
        {
            List<Promedio> lista = new List<Promedio>();

            foreach (Alumno egresado in listaAlumnos)
            {
                float promedio=0;
                int cont =0;

                foreach (Calificaciones calificacion in listaCalificaciones)
                {
                    if (egresado.NumControl == calificacion.Alumno.NumControl)
                    {
                        promedio += calificacion.Calificacion;
                        cont++;
                    }
                }

                if (promedio > 0 && cont > 0)
                {
                    promedio = promedio / cont;
                }

                lista.Add(new Promedio(egresado,promedio));
            }
            
            return lista;
        }

        public List<Promedio> listaPromedios(List<Egresado> egresados, List<Calificaciones> calificaciones)
        {
            List<Promedio> lista = new List<Promedio>();

            foreach (Egresado alumno in egresados)
            {
                float promedio = 0;
                int cont = 0;

                foreach (Calificaciones calificacion in calificaciones)
                {
                    if (alumno.NumControl == calificacion.Alumno.NumControl)
                    {
                        promedio += calificacion.Calificacion;
                        cont++;
                    }
                }

                if (promedio > 0 && cont > 0)
                {
                    promedio = promedio / cont;
                }

                lista.Add(new Promedio(alumno, promedio));
            }

            return lista;
        }

        public List<Promedio> top10(List<Promedio> listaPromedios)
        {
            List<Promedio> lista = new List<Promedio>();
            for (int i = 0; i < 10; i++)

            {
                float mayor = 0;
                int indice = -1;
                int sacar = -1;

                foreach (Promedio prome in listaPromedios)
                {
                    indice++;

                    if (prome.prom >= mayor)
                    {
                        mayor = prome.prom;
                        sacar = indice;
                    }
                }

                if(sacar > -1)
                {
                    lista.Add(listaPromedios[sacar]);
                    listaPromedios.RemoveAt(sacar);
                }
                
            }

            return lista;
        }

        public List<Promedio> top10(List<Promedio> listaPromedios, String carrera)
        {
            List<Promedio> lista = new List<Promedio>();
            for (int i = 0; i < 10; i++)

            {
                float mayor = 0;
                int indice = -1;
                int sacar = -1;

                foreach (Promedio prome in listaPromedios)
                {
                    indice++;

                    if ((prome.prom >= mayor) && (prome.Egresado.Carrera.NombreCarrera == carrera))
                    {
                        mayor = prome.prom;
                        sacar = indice;
                    }
                }
                
                if(sacar > -1)
                {
                    lista.Add(listaPromedios[sacar]);
                    listaPromedios.RemoveAt(sacar);
                }
            }

            return lista;
        }
    }
}
