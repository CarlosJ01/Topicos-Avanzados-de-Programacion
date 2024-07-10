/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Modelos;

/**
 *
 * @author Carlos J
 */
public class DatosUsuario {
    
    private Usuario usuario;
    private String nombre;
    private String datos;
    private byte[] imagen;

    public DatosUsuario() {
    }

    public DatosUsuario(Usuario usuario, String nombre, String datos, byte[] imagen) {
        this.usuario = usuario;
        this.nombre = nombre;
        this.datos = datos;
        this.imagen = imagen;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDatos() {
        return datos;
    }

    public void setDatos(String datos) {
        this.datos = datos;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }
    
}
