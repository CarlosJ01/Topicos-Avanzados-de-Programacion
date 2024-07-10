/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tap_unidad02_tarea04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Carlos J
 */
public class Servidor extends Thread{

    private String mensaje;
    public boolean seguir=true;
    private ServerSocket servidor; 
    private Socket canal;

    public Servidor() {
        this.mensaje="";
    }
    public void terminar(){
        seguir=false;
        System.out.println("-------------------------------------------------------------------------------------");
        new Cliente("ROOT").enviar("CONVERSACION FINALIZADA");
    }
    
    @Override
    public void run() {
        while(seguir){
            try {
                servidor = new ServerSocket(1234);
                canal = servidor.accept();
                //Leer del canal
                BufferedReader salida =  new BufferedReader(new InputStreamReader(canal.getInputStream()));
                while((mensaje=salida.readLine())!=null){
                    System.out.println(mensaje);
                }
                System.out.println("");

                salida.close();
                canal.close();
                servidor.close();
            } catch (Exception e) {
                System.out.println("Error en el Servidor");
            }
        }
    }
   
}
