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

public class Materia {
    
    private int id;
    private String nombre_materia;
    
    //Saca una lista con el porcentaje de reprovacion
    public ArrayList<Float> porcentajeReprovacion(ArrayList<Float> lista, ArrayList<Calificaciones> listaCalificaciones){
        float porcentaje = 0;
        int reprobados = 0;

        for (Calificaciones item : listaCalificaciones){
            if (item.getCalificacion() < 70){
                reprobados++;
            }
        }

        if (listaCalificaciones.size()>0){
            porcentaje = (float)reprobados / listaCalificaciones.size();
            porcentaje *= 100;
        }

        lista.add(porcentaje);

        return lista;
    }

    public boolean existe(String nom,ArrayList<Materia> lista){
        
        for(Materia item : lista){
            if(item.getNombre_materia().equals(nom)){
                return true;
            }
        }
        
        return false;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_materia() {
        return nombre_materia;
    }

    public void setNombre_materia(String nombre_materia) {
        this.nombre_materia = nombre_materia;
    }
}
