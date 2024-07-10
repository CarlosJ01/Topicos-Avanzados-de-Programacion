/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Examen;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;

/**
 *
 * @author Carlos J
 */

public class Servidor extends SwingWorker{

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
    
    //GNU
    private JTextArea imprimir;
    public boolean seguir=true;
    File archivo;
    private ArrayList<File> lista;

    public Servidor(JTextArea imp) {
        this.imprimir=imp;
        this.lista=new ArrayList<>();
    }
    
    public ArrayList<File> getLista(){
        return lista;
    }
    
    @Override
    protected Object doInBackground() throws Exception {
        servidor=new ServerSocket(1234);
        while(seguir){
            try {                       
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
                
                archivo = new File("C:\\Users\\Carlos J\\Documents\\Nube\\"+nomFile);
                
                //Convertir la cadena de bytes a Archivo
                OutputStream convertir = new FileOutputStream(archivo);
                convertir.write(buffer);
                convertir.close();

                this.publish(1);

                leerArchivo.close();
                leerNombre.close();

                System.out.println("Archivo Recivido: "+nomFile);
                
            } catch (Exception e) {
                System.out.println("Error en el servidor");
            }
        }
        return null;
    }

    @Override
    protected void process(List list) {
        imprimir.append(lista.size()+"\t"+nomFile);
        imprimir.append("\n");
        nomFile="";
        lista.add(archivo);
    }

    @Override
    protected void done() {
        JOptionPane.showMessageDialog(null,"Fin del programa");
    }
}
