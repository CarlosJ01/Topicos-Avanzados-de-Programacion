using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace TAP_Unidad03_Practica03.Models
{
    class Alumno
    {
        //Numero de Control
        private String numControl;
        public String NumControl
        {
            get { return numControl; }
            set { numControl = value; }
        }

        //Nombre Completo
        private String nombreCompleto;
        public String NombreCompleto
        {
            get { return nombreCompleto; }
            set { nombreCompleto = value; }
        }

        //Semestre
        private int semestre;
        public int Semestre
        {
            get { return semestre; }
            set { semestre = value; }
        }

        //Carrera
        private Carrera carrera;
        public Carrera Carrera
        {
            get { return carrera; }
            set { carrera = value; }
        }

        // Constructor (Snippet ctor + tab)
        public Alumno()
        {
        }

        // Constructor
        public Alumno(String numControl, String nombreCompleto, int semestre, Carrera carrera)
        {
            this.numControl = numControl;
            this.nombreCompleto = nombreCompleto;
            this.semestre = semestre;
            this.carrera = carrera;
        }

        //Busca a un alumno de una lista
        public Alumno buscar(List<Alumno> lista, String numCont)
        {
            foreach (Alumno encontrado in lista)
            {
                if (numCont == encontrado.numControl)
                {
                    return encontrado;
                }
            }
            return null;
        }

        //Decide si se puede eliminar
        public bool puedeEliminar(String numCont ,List<Calificaciones> calificaciones)
        {
            foreach(Calificaciones calf in calificaciones)
            {
                if (numCont == calf.Alumno.numControl)
                {
                    return false;
                }
            }
            return true;
        }

        public bool repite(List<Alumno> lista, String numCont)
        {
            foreach (Alumno item in lista)
            {
                if (numCont==item.numControl)
                {
                    return false;
                }
            }
            return true;
        }
    }
}
