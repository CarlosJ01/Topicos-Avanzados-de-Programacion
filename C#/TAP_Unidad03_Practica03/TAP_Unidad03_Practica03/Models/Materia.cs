using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace TAP_Unidad03_Practica03.Models
{
    class Materia
    {
        int id;
        String nombre_materia;

        public int Id
        {
            get{return id;}
            set{id = value;}
        }

        public String Nombre_materia
        {
            get { return nombre_materia; }
            set { nombre_materia = value; }
        }

        public List<float> porcentajeReprovacion(List<float> lista, List<Calificaciones> listaCalificaciones)
        {
            float porcentaje = 0;
            int reprobados = 0;

            foreach (Calificaciones item in listaCalificaciones)
            {
                if (item.Calificacion < 70)
                {
                    reprobados++;
                }
            }
            
            if (listaCalificaciones.Count()>0)
            {
                porcentaje = (float)reprobados / listaCalificaciones.Count();
                porcentaje *= 100;
            }

            lista.Add(porcentaje);
            
            return lista;
        }
    }
}
