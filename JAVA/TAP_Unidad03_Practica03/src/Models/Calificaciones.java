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
public class Calificaciones {
    
    private int id = 0;
    private Alumno alumno = null;
    private float calificacion;
    private Materia materia=null;

    public Calificaciones(){
        id = 0;
        alumno = new Alumno();
        calificacion = 0;
        materia = new Materia();
    }

    //Saca la lista de calificaciones por materia
    public ArrayList<Calificaciones> listaMateria(ArrayList<Calificaciones> listaCalif,String nomMateria){
        ArrayList<Calificaciones> lista = new ArrayList<>();
        
        for (Calificaciones indice:listaCalif){
            if (indice.getMateria().getNombre_materia().equalsIgnoreCase(nomMateria)){
                lista.add(indice);
            }
        }

        return lista;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public float getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(float calificacion) {
        this.calificacion = calificacion;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }
}
