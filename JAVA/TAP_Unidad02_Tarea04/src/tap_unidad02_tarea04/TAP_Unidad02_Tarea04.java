/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tap_unidad02_tarea04;

import javax.swing.JOptionPane;

/**
 *
 * @author Carlos J
 */
public class TAP_Unidad02_Tarea04 {

    public static boolean seguir=true;
    
    public static void main(String[] args) {
        //Creamos Servidor y Usuarios que van a hablar
        Servidor whatsUp = new Servidor();
        Cliente usuario01 = new Cliente("Skynet");
        Cliente usuario02 = new Cliente("HAL 9000");
        
        //Iniciamos el Servidor
        whatsUp.start();
        
        //Conversacion
        while(seguir){
            escribir(usuario01);
            escribir(usuario02);
            seguir=terminar();
        }
        
        //Cerrar el Servidor
        whatsUp.terminar();
    }
    
    public static void escribir(Cliente clt){
        String msg = JOptionPane.showInputDialog("Mensaje a enviar ("+clt.getNombre()+") : ");
        clt.enviar(msg);
    }
    
    public static boolean terminar(){
        int ter = JOptionPane.showConfirmDialog(null,"Terminar la conversacion: ","", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
        return ter != 0;
    }
}
