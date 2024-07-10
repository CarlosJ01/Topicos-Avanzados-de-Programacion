/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.ArrayList;

/**
 *
 * @author Carlos J
 */
public class Promedio {
    private Alumno alumno;
    private Egresado egresado;
    private float prom;

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


    public ArrayList<Promedio> listaPromedios(ArrayList<Alumno> listaAlumnos,ArrayList<Calificaciones> listaCalificaciones)
    {
        ArrayList<Promedio> lista = new ArrayList<>();

        for (Alumno egresado : listaAlumnos)
        {
            float promedio=0;
            int cont =0;

            for (Calificaciones calificacion : listaCalificaciones)
            {
                if (egresado.getNumeroControl().equals(calificacion.getAlumno().getNumeroControl()))
                {
                    promedio += calificacion.getCalificacion();
                    cont++;
                }
            }

            if (promedio > 0 && cont > 0)
            {
                promedio = promedio / cont;
            }

            lista.add(new Promedio(egresado,promedio));
        }

        return lista;
    }

    public ArrayList<Promedio> listaPromediosE(ArrayList<Egresado> egresados,ArrayList<Calificaciones> calificaciones){
        ArrayList<Promedio> lista = new ArrayList<>();

        for (Egresado alu : egresados)
        {
            float promedio = 0;
            int cont = 0;

            for (Calificaciones calificacion : calificaciones)
            {
                if (alu.getNumControl().equals(calificacion.getAlumno().getNumeroControl()))
                {
                    promedio += calificacion.getCalificacion();
                    cont++;
                }
            }

            if (promedio > 0 && cont > 0)
            {
                promedio = promedio / cont;
            }

            lista.add(new Promedio(alu, promedio));
        }

        return lista;
    }

    public ArrayList<Promedio> top10(ArrayList<Promedio> listaPromedios)
    {
        ArrayList<Promedio> lista = new ArrayList<>();
        for (int i = 0; i < 10; i++)
        {
            float mayor = 0;
            int indice = -1;
            int sacar = -1;

            for (Promedio prome : listaPromedios)
            {
                indice++;

                if (prome.getProm() >= mayor)
                {
                    mayor = prome.prom;
                    sacar = indice;
                }
            }

            if(sacar > -1)
            {
                lista.add(listaPromedios.get(sacar));
                listaPromedios.remove(sacar);
            }
        }

        return lista;
    }

    public ArrayList<Promedio> top10C(ArrayList<Promedio> listaPromedios, String carrera)
    {
        ArrayList<Promedio> lista = new ArrayList<>();
        for (int i = 0; i < 10; i++)
        {
            float mayor = 0;
            int indice = -1;
            int sacar = -1;

            
            
            for (Promedio prome : listaPromedios)
            {
                indice++;

                if ((prome.getProm() >= mayor) && (prome.getEgresado().getCarrera().getNombreCarrera().equals(carrera)))
                {
                    mayor = prome.getProm();
                    sacar = indice;
                }
            }

            
            if(sacar > -1)
            {
                lista.add(listaPromedios.get(sacar));
                listaPromedios.remove(sacar);
            }
        }

        return lista;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Egresado getEgresado() {
        return egresado;
    }

    public void setEgresado(Egresado egresado) {
        this.egresado = egresado;
    }

    public float getProm() {
        return prom;
    }

    public void setProm(float prom) {
        this.prom = prom;
    }
}
