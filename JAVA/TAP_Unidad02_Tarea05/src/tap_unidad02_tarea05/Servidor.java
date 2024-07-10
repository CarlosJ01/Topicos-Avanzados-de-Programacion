/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tap_unidad02_tarea05;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Carlos J
 */
public class Servidor extends Thread{
    //Servidor
    private ServerSocket servidor;
    private Socket canal;
 
    private DataInputStream leerNombre;
    private BufferedInputStream salida;
    private BufferedOutputStream leerArchivo;
 
    //Buffer
    private byte[] buffer;
    private int ind;
    private String nomFile;

    @Override
    public void run() {
        try {
            servidor=new ServerSocket(1234);              
            //Crear el canal
            canal = servidor.accept();

            //Crear el Buffer de 1024 bytes
            buffer = new byte[1024];
            salida = new BufferedInputStream(canal.getInputStream());
            leerNombre=new DataInputStream(canal.getInputStream());

            //Leemos el nombre del fichero
            nomFile = leerNombre.readUTF();
            nomFile = nomFile.substring(nomFile.indexOf('\\')+1,nomFile.length());

            //Para guardar fichero recibido
            leerArchivo = new BufferedOutputStream(new FileOutputStream(nomFile));
            while ((ind = salida.read(buffer)) != -1){
                salida.read(buffer,0,ind);
            }
            
            //Convertir la cadena de bytes a Archivo
            OutputStream convertir = new FileOutputStream(nomFile);
            convertir.write(buffer);
            convertir.close();

            leerArchivo.close();
            leerNombre.close();

            System.out.println("Archivo Recivido: "+nomFile);
        } catch (Exception e) {
            System.out.println("Error en el servidor");
        }
    }
    
}
