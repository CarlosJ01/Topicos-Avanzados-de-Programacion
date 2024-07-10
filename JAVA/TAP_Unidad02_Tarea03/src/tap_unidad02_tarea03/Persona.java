/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tap_unidad02_tarea03;

import java.io.Serializable;

/**
 *
 * @author Carlos J
 */
public class Persona implements Serializable{
    private int ID;
    private String nombre;
    private int edad;
    private String ocupacion;
    private String sexo;

    public Persona(int id,String nom, int edd, String ocp, String sex) {
        this.ID=id;
        this.nombre=nom;
        this.edad=edd;
        this.ocupacion=ocp;
        this.sexo=sex;
    }

    @Override
    public String toString() {
        String cad="";
        cad+="Id: "+ID+"\n";
        cad+="Nombre: "+nombre+"\n";
        cad+="Edad: "+edad+"\n";
        cad+="Opupacion: "+ocupacion+"\n";
        cad+="Sexo: "+sexo;
        return cad;
    }
}
