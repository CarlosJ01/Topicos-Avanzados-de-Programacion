/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tap_unidad02_tarea05;

/**
 *
 * @author Carlos J
 */
public class TAP_Unidad02_Tarea05 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String nombre = "C:\\Users\\Carlos J\\Documents\\Archivo.txt";
        Cliente usuario = new Cliente();
        Servidor maria = new Servidor();
        maria.start();
        usuario.enviar(nombre);
    }
    
}
