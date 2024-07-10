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
public class Alumno {
    
    private String numeroControl;
    private String nombreCompleto;
    private int semestre;
    private Carrera carrera;

    public String getNumeroControl() {
        return numeroControl;
    }

    public void setNumeroControl(String numeroControl) {
        this.numeroControl = numeroControl;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }
    
    // Constructor (Snippet ctor + tab)
    public Alumno(){
    }

    // Constructor
    public Alumno(String numControl, String nombreCompleto, int semestre, Carrera carrera){
        this.numeroControl = numControl;
        this.nombreCompleto = nombreCompleto;
        this.semestre = semestre;
        this.carrera = carrera;
    }

    //Busca a un alumno de una lista
    public Alumno buscar(ArrayList<Alumno> lista, String numCont){
        
        for(Alumno calf : lista){
            if (numCont.equalsIgnoreCase(calf.getNumeroControl()))
            {
                return calf;
            }
        }
        
        return null;
    }

    //Decide si se puede eliminar
    public boolean puedeEliminar(String numCont ,ArrayList<Calificaciones> calificaciones){
        for(Calificaciones calf : calificaciones){
            if (numCont.equalsIgnoreCase(calf.getAlumno().getNumeroControl())){
                return false;
            }
        }
        return true;
    }

    //Verifica si un alumno se repite en una lista
    public boolean repite(ArrayList<Alumno> lista, String numCont){
        for(Alumno item : lista){
            if (numCont.equalsIgnoreCase(item.getNumeroControl())){
                return false;
            }
        }
        return true;
    }
    
}
