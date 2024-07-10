/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tap_unidad02_tarea03;

import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author Carlos J
 */
public class Cliente {
    
    public void enviar(Persona prs){
        try {
           //Iniciamos el cliente
            Socket reiner = new Socket("127.0.0.1",9909);
            
            //Verificamos si esta conectado y enviamos un objeto
            if (reiner.isConnected()) {
                //Enviamos el objeto
                ObjectOutputStream mensajero = new ObjectOutputStream(reiner.getOutputStream());
                mensajero.writeObject(prs);
                mensajero.close();
                System.out.println("\t<OBJETO ENVIADO>");
                System.out.println(prs.toString());
            }
            
            //Cerramos el cliente
            reiner.close();
        } catch (Exception e) {
            System.out.println("Error en el cliente");
        }
    }
    
}
