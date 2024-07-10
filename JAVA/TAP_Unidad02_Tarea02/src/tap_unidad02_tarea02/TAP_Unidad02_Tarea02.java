/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tap_unidad02_tarea02;

/**
 *
 * @author Carlos J
 */
public class TAP_Unidad02_Tarea02 {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        Celular celular = new Celular();
        Cargar car = new Cargar(celular,0);
        Descargar  des = new  Descargar(celular,100);
        
        car.start();
        des.start();
    }
    
}
