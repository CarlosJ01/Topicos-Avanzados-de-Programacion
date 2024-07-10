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
public class Hilo_1  extends Thread/*Hereda de hilos*/{

    @Override
    public void run() {
        int cont=0;
        //Ciclo infinito con un mensaje
        while (true) {
            if (cont > 5) {
                try {
                    Thread.sleep(1000);//Tiempo en milisegundos tiempo para dormir el hilo
                } catch (InterruptedException ex) {
                    Logger.getLogger(Hilo_1.class.getName()).log(Level.SEVERE, null, ex);
                }
                cont=0;
            }
            else{         
                System.out.println("Soy el hilo 01");
                cont++;
            }
        }
    }
    
}