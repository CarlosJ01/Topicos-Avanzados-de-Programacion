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
public class Descargar extends Thread{
    private Celular cel;
    private int bateria;
    
    public Descargar(Celular cel,int bat){
        this.cel=cel;
        this.bateria=bat;
    }

    @Override
    public void run() {
        for (int i = 100; i >= 0; i--) {
            cel.descargar(i);
            System.out.println("\tDescargar -> %Carga: "+cel.getBateria());
        }
    }
    
}
