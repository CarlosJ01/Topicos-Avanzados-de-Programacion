/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Carlos J
 */
public class Carrera {
    private int id;
    private String nombreCarrera;

    // Constructor
    public Carrera() { }

    // Constructor con parametros
    public Carrera(int id, String nombreCarrera)
    {
        this.id = id;
        this.nombreCarrera = nombreCarrera;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }
}
