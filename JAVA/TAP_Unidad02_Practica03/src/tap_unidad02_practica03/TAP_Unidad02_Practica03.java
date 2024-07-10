/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tap_unidad02_practica03;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Carlos J
 */
public class TAP_Unidad02_Practica03 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Receptor
        try {
            //*Llamada Bloqueante
            ServerSocket ss= new ServerSocket(12345);//Socket
            Socket canalCom = ss.accept();//Canal de comunicacion llamada bloqueante
            
            //Leer de memoria la peticion
            ObjectInputStream ois= new ObjectInputStream(canalCom.getInputStream());
            String msg = ois.readObject().toString();
            System.out.println("Recibi: "+msg);
            
            //Se cierra
            ois.close();
            canalCom.close();
            ss.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
