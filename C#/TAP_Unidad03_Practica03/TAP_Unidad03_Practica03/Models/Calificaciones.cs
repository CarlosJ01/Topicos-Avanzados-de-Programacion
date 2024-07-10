using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TAP_Unidad03_Practica03.Models
{
    class Calificaciones
    {
        int id = 0;
        Alumno alumno = null;
        float calificacion;
        Materia materia=null;

        public Calificaciones()
        {
            id = 0;
            alumno = new Alumno();
            calificacion = 0;
            materia = new Materia();
        }

        public int Id
        {
            get { return id; }
            set { id=value; }
        }

        public Alumno Alumno
        {
            get { return alumno; }
            set { alumno = value; }
        }

        public float Calificacion
        {
            get { return calificacion; }
            set { calificacion = value; }
        }

        public Materia Materia
        {
            get { return materia; }
            set { materia = value; }
        }

        public List<Calificaciones> listaMateria(List<Calificaciones> listaCalif,String nomMateria)
        {
            List<Calificaciones> lista = new List<Calificaciones>();
            foreach (Calificaciones indice in listaCalif)

            {
                if (indice.Materia.Nombre_materia == nomMateria)
                {
                    lista.Add(indice);
                }
            }

            return lista;
        }
    }
}
