/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tap_unidad02_practica03;

import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javax.swing.JOptionPane;

/**
 *
 * @author Carlos J
 */
public class Cliente {
    
    public static void main(String[] args) {
        //Emisor
        try {
            Socket s = new Socket("127.0.0.1",12345);//localhost = 127.0.0.1
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
}
