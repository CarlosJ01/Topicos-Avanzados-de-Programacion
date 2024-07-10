/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingWorker;

/**
 *
 * @author Carlos J
 */
public class Server extends SwingWorker{

    private String mensaje="";
    public boolean seguir=true;
    private ServerSocket servidor; 
    private Socket canal;
    private JTextField imprimir;

    public Server(JTextField textFiel) {
        this.imprimir=textFiel;
    }
    
    public void terminar(){
        seguir=false;
        System.out.println("-------------------------------------------------------------------------------------");
        new Cliente("ROOT").enviar("CONVERSACION FINALIZADA");
    }
    
    @Override
    protected Object doInBackground() throws Exception {
        while(seguir){
            try {
                String msg;
                servidor = new ServerSocket(1234);
                System.out.println("Esperando...");
                canal = servidor.accept();
                System.out.println("Aceptado...");
                
                //Leer del canal
                BufferedReader salida =  new BufferedReader(new InputStreamReader(canal.getInputStream()));
                while((msg=salida.readLine())!=null){    
                    mensaje+=msg;
                }
                
                this.publish(1);
                
                salida.close();
                canal.close();
                servidor.close();
            } catch (Exception e) {
                System.out.println("Error en el Servidor");
            }   
        }
    return null;
    }

    @Override
    protected void process(List list) {
        imprimir.setText(mensaje);
    }

    @Override
    protected void done() {
        System.out.println("Fin del servidor");
    }
    
}
