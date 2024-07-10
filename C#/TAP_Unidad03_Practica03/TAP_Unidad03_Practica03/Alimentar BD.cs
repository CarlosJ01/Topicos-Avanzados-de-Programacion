using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using TAP_Unidad03_Practica03.Models;

namespace TAP_Unidad03_Practica03
{
    public partial class Alimentar_BD : Form
    {
        String[] nombres = {"JUAN","JOSÉ LUIS","JOSÉ","MARÍA GUADALUPE","FRANCISCO","GUADALUPE","MARÍA","JUANA",
                            "ANTONIO","JESÚS","MIGUEL ÁNGEL","PEDRO","ALEJANDRO","MANUEL","MARGARITA","MARÍA DEL CARMEN",
                            "JUAN CARLOS","ROBERTO","FERNANDO","DANIEL","CARLOS"};
        String[] apellidos = {"González","Rodríguez","Gómez","Huertas","López","Díaz","Martínez","Pérez","García","Sánchez"
                             ,"Romero","Sosa","Álvarez","Torres","Ruiz","Ramírez","Flores","Acosta","Benítez","Medina"};

        public Alimentar_BD()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            Random ram = new Random();
            String numCont = "";
            String nom = "";
            int semestre = 0;
            int carrera = 0;
            Alumno alumno = null;
            int generados = 0;
            for (int i = 0; i < 100; i++)
            {
                try
                {
                    ManejadorBD manejador = new ManejadorBD();
                    numCont = numeroControl();
                    List<Alumno> alumnos = manejador.mostrarAlumnos();

                    if (new Alumno().repite(alumnos, numCont))
                    {
                        nom = nombre();
                        semestre = ram.Next(1, 9);
                        carrera = ram.Next(1, 10);
                        alumno = new Alumno(numCont, nom, semestre, new Carrera(carrera, ""));
                        //MessageBox.Show(numCont + " " + nom + " " + semestre + " " + carrera);
                        manejador.nuevoAlumno(alumno);
                        generados++;
                    }

                }
                catch (Exception)
                {
                    Console.WriteLine("Error al agregar un alumno");
                }
            }
            MessageBox.Show("Se generaron "+generados+" Alumnos");
        }

        //Genera un numero de Control
        private String numeroControl()
        {
            String numCont="";
            Random ram = new Random();

            for (int i = 0; i < 8; i++)
            {
                int num = ram.Next(0, 9);
                numCont += "" + num;
            }
            return numCont;
        }

        //Genera el nombre
        private String nombre()
        {
            String nom="";
            Random ram = new Random();

            nom += nombres[ram.Next(0, nombres.Length)];
            nom += " "+apellidos[ram.Next(0, apellidos.Length)];
            nom += " "+apellidos[ram.Next(0, apellidos.Length)];

            return nom;
        }

        private void button3_Click(object sender, EventArgs e)
        {
            Random ram = new Random();
            ManejadorBD manejador = new ManejadorBD();
            List<Alumno> alumnos = null;
            String alumno = "";
            int calif = 0;
            int materia = 0;
            
            int generados = 0;
            for (int i = 0; i < 100; i++)
            {
                try
                {
                    alumnos = manejador.mostrarAlumnos();
                    alumno = alumnos[ram.Next(0, alumnos.Count())].NumControl;
                    calif = ram.Next(40,100);
                    materia = ram.Next(1, 10);
                    
                    manejador.agregarCalificacion(alumno,calif,materia);
                    
                    generados++;
                    //MessageBox.Show(alumno + " " + calif + " " + materia);
                }
                catch (Exception)
                {
                    Console.WriteLine("Error al agregar una calificacion");
                }
            }
            MessageBox.Show("Se generaron " + generados + "Calificaciones");
        }

        private void button2_Click(object sender, EventArgs e)
        {
            Random ram = new Random();
            ManejadorBD manejador = new ManejadorBD();
            List<Alumno> alumnos = null;

            Alumno alumno = null;
            String fech="";

            int generados = 0;
            for (int i = 0; i < 100; i++)
            {
                try
                {
                    alumnos = manejador.mostrarAlumnos();
                    
                    alumno = alumnos[ram.Next(0, alumnos.Count())];
                    fech = fecha();

                    manejador.agregarEgresado(alumno.NumControl,alumno.NombreCompleto,fech,alumno.Carrera.Id);

                    //MessageBox.Show(alumno.NumControl + " " + alumno.NombreCompleto + " " + fech + " " + alumno.Carrera.Id);
                    generados++;
                    
                }
                catch (Exception)
                {
                    Console.WriteLine("Error al agregar una Egresado");
                }
            }
            MessageBox.Show("Se generaron " + generados + " Egresados");
        }

        //Genera una fecha
        private String fecha()
        {
            Random ram = new Random();
            String fecha = "";
            fecha += ram.Next(1980, 2020)+"-";

            int mes = ram.Next(1, 12);
            if(mes/10 < 1)
            {
                fecha += "0"+mes+"-";
            }
            else
            {
                fecha += mes + "-";
            }

            int dia = ram.Next(1, 31);
            if (dia / 10 < 1)
            {
                fecha += "0" + dia;
            }
            else
            {
                fecha +=""+dia;
            }

            return fecha;

        }
    }
}
