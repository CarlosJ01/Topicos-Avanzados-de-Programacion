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
public class Celular {
   private int bateria=0;
   private boolean cargador =false;
   
   public synchronized void descargar(int bat){
       while (cargador==false) {           
           try {
               wait();
           } catch (Exception e) {
           }
       }
       bateria=bat;
       cargador=false;
       notifyAll();
   }
   
   public synchronized void cargar(int bat){
       while (cargador==true) {           
           try {
               wait();
           } catch (Exception e) {
           }
       }
       bateria=bat;
       cargador=true;
       notifyAll();
   }
   
   public int getBateria(){
       return bateria;
   }
}
