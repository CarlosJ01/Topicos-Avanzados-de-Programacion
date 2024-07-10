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
public class Egresado {
    private String numControl;
    private String nombreCompleto;    
    private String fechaEgreso;
    private Carrera carrera;
    private String generacion;

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

    public Egresado buscar(ArrayList<Egresado> lista, String numCont)
    {
        for(Egresado encontrado : lista)
        {
            if(numCont.equals(encontrado.getNumControl()))
            {
                return encontrado;
            }
        }
        return null;
    }

    public boolean Existe(String numCont, ArrayList<Egresado> lista)
    {
        for(Egresado item : lista)
        {
            if (numCont.equals(item.getNumControl()))
            {
                return true;
            }    
        }
        return false;
    }

    public ArrayList<Calificaciones> CalifiEgresados(ArrayList<Calificaciones> lista, ArrayList<Egresado> egresados)
    {
        for (int i = 0; i < lista.size(); i++)
        {
            boolean encontrado = false;

            for(Egresado egresado : egresados)
            {
                if (egresado.getNumControl().equals(lista.get(i).getAlumno().getNumeroControl()))
                {
                    encontrado = true;
                }
            }

            if (encontrado == false)
            {
                lista.remove(i);
            }
        }
        return lista;
    }

    //Sacar el año de ingreso
    public String SacarGeneracion(String fecha)
    {
        return fecha.substring(0,4).trim();
    }

    //Sacar Generaciones
    public ArrayList<String> generaciones(ArrayList<Egresado> egresados)
    {
        ArrayList<String> lista = new ArrayList<>();

        for (Egresado egresado : egresados)
        {
            boolean repetido = false;

            for(String generacion : lista)
            {
                if (egresado.getGeneracion().equals(generacion))
                {
                    repetido = true;
                }
            }
            if (repetido == false)
            {
                lista.add(egresado.getGeneracion());
            }
        }

        return lista;
    }

    //Ordenar por generacion
    public ArrayList<Egresado> ordenarGeneracion(ArrayList<Egresado> lista)
    {
        ArrayList<Egresado> ordenada = new ArrayList<>();

        while (lista.size()!=0)
        {
            int i = -1;
            int indice = -1;
            int max = 0;

            for (Egresado item : lista)
            {
                i++;
                if (Integer.parseInt(item.getGeneracion())>=max)
                {
                    max = Integer.parseInt(item.getGeneracion());
                    indice = i;
                }
            }

            ordenada.add(lista.get(indice));
            lista.remove(indice);
        }

        return ordenada;
    }

    public String getGeneracion() {
        return generacion;
    }

    public void setGeneracion(String generacion) {
        this.generacion = generacion;
    }

    public String getNumControl() {
        return numControl;
    }

    public void setNumControl(String numControl) {
        this.numControl = numControl;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getFechaEgreso() {
        return fechaEgreso;
    }

    public void setFechaEgreso(String fechaEgreso) {
        this.fechaEgreso = fechaEgreso;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }
}
