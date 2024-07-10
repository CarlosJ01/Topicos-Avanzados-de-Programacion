/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Tarea06;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.Socket;
import org.json.simple.JSONObject;

/**
 *
 * @author Carlos J
 */
public class Cliente {
    private String nombre;

    public Cliente(String nom) {
        this.nombre=nom;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void enviar(){
        try {
            
            JSONObject json = new JSONObject();
            json.put("Lenguaje","Java");
            json.put("Flotante",123.55);
            json.put("Recive","C#");
            
            //Dormimos para esperar al servidor Creamos el Socket
            Socket mensajero = new Socket("127.0.0.1",1235);
            //Verificamos si esta conectado y enviamos el mensaje
            if (mensajero.isConnected()) {
                //Enviamos el mensaje
                BufferedWriter entrada = new BufferedWriter(new OutputStreamWriter(mensajero.getOutputStream()));
                entrada.write(json.toJSONString());
                entrada.close();
            }
            mensajero.close();
        } catch (Exception e) {
            System.out.println("Error al enviar el mensaje cliente "+nombre);
        }
    }
    
}
