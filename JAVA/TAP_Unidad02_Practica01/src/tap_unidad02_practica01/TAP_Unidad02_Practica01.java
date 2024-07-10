/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tap_unidad02_practica01;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos J
 */
public class TAP_Unidad02_Practica01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Hilo_1 hilo = new Hilo_1();//Instanciar un Hilo_1
        hilo.start();//Invoca al run
        int cont=0;
        //Ciclo infinito con mensaje
        while (true) {
            if (cont < 5) {
                System.out.println("\tSoy el Main");
                cont++;
            }
            else{
                try {
                    Thread.sleep(1000);//Tiempo en milisegundos tiempo para dormir el hilo
                } catch (InterruptedException ex) {
                    Logger.getLogger(Hilo_1.class.getName()).log(Level.SEVERE, null, ex);
                }
                cont=0;
            }
        }
    }
    
}

/*
Dos ciclos compiten por el procesamiento
Por eso se imprimen dos un tiempo para uno y otoro para otro
*/