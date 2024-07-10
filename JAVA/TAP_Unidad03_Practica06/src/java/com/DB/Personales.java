/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DB;

import java.io.Serializable;

/**
 *
 * @author Carlos J
 */
public class Personales implements Serializable{
    private int id;
    private String datos_peronales;
    private byte[] foto;
    private Usuario usuario;
    
    //Costructores
    public Personales(){}

    public Personales(int id, String datos_peronales, byte[] foto, Usuario usuario) {
        this.id = id;
        this.datos_peronales = datos_peronales;
        this.foto = foto;
        this.usuario = usuario;
    }

    //Gettes y Settes
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDatos_peronales() {
        return datos_peronales;
    }

    public void setDatos_peronales(String datos_peronales) {
        this.datos_peronales = datos_peronales;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
