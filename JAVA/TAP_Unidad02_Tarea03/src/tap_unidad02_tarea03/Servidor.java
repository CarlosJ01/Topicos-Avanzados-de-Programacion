/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tap_unidad02_tarea03;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Carlos J
 */

//Clase para el servidor
public class Servidor extends Thread{

    @Override
    public void run() {
        try {
            //Iniciamos el servidor
            ServerSocket maria = new ServerSocket(9909);
            Socket canal = maria.accept();
            
            //Leer del canal
            ObjectInputStream lector = new ObjectInputStream(canal.getInputStream());
            Persona persona =(Persona)lector.readObject();
            System.out.println("\t<OBJETO RESIVIDO>");
            System.out.println(persona.toString());
            
            //Cerrar el Servidor
            lector.close();
            canal.close();
            maria.close();
        } catch (Exception e) {
            System.out.println("Error en el Servidor");
        }
    }
    
}
