/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tap_unidad02_practica03;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JOptionPane;

/**
 *
 * @author Carlos J
 */
public class ClienteServidor {
    
    public ClienteServidor(){
        //Se inicializa primero el servidor
        new Server().start();
        
        //Codigo del Cliente
        //Emisor
        try {
            Socket s = new Socket("127.0.0.1",9125);//localhost = 127.0.0.1
            if (s.isConnected()) {
                String msg = JOptionPane.showInputDialog("Mensaje a enviar: ");
                
                //Escribe mensaje en memoria
                ObjectOutputStream oss = new ObjectOutputStream(s.getOutputStream());
                oss.writeObject(msg);
                oss.close();
            }
            //Se cierra
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public static void main(String[] args) {
        new ClienteServidor();
    }
    
    //Clase para el hilo
    class Server extends Thread{

        @Override
        public void run() {
            //Receptor
            try {
                //*Llamada Bloqueante
                ServerSocket ss= new ServerSocket(9125);//Socket
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
}
