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
public class Cargar extends Thread{
    private Celular cel;
    private int bateria;
    
    public Cargar(Celular cel, int bateria){
        this.cel=cel;
        this.bateria=bateria;
    }

    @Override
    public void run() {
        for (int i = 0; i <=100; i++) {
            cel.cargar(i);
            System.out.println("Cargando -> %Carga: "+cel.getBateria());
        }
    }
}
