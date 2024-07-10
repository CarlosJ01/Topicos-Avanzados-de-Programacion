/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tap_unidad02_tarea05;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.Socket;

/**
 *
 * @author Carlos J
 */
public class Cliente {
    //Cliente
    private Socket cliente;
    private DataOutputStream mensajero;
    private BufferedInputStream entrada;
    private BufferedOutputStream salida;
    
    //Buffer
    private byte[] buffer;
    private int ind;
    
    public void enviar(String nombre){
        try {
            //Crear archivo
            File archivo =  new File(nombre);
            
            //Crear el Cliente
            cliente = new Socket("localhost",1234);
            
            //Crear la entrada y salida
            entrada = new BufferedInputStream(new FileInputStream(archivo));
            salida = new BufferedOutputStream(cliente.getOutputStream());
            
            //Enviamos el nombre del fichero
            mensajero=new DataOutputStream(cliente.getOutputStream());
            mensajero.writeUTF(archivo.getName());
            
            //Enviamos el fichero
            buffer = new byte[8192];
            while ((ind = entrada.read(buffer)) != -1){
                salida.write(buffer,0,ind);
            }
 
            salida.close();
            entrada.close();
            cliente.close();
            
            System.out.println("Arcvhio enviado: "+archivo.getName());
            
        } catch (Exception e) {
            System.out.println("Error en el Cliente");
        }
    }
}
