/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tap_unidad02_tarea03;

/**
 *
 * @author Carlos J
 */
public class TAP_Unidad02_Tarea03 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Crear objetos
        Servidor maria = new Servidor();
        Cliente reiner = new Cliente();
        Persona eren = new Persona(12345,"Eren",25,"Soldado","Masculino");
        
        //Recivir y enviar
        maria.start();//Iniciar el servidor
        reiner.enviar(eren);//Enviamos el objeto
    }
    
}
