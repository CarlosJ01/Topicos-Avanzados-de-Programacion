package tap_unidad01_tarea03;
import javax.swing.*;


public class TAP_Unidad01_Tarea03 extends JFrame{
    private JLabel label1;
    private JButton btn1;
    private JTextField txt;
    
    public TAP_Unidad01_Tarea03(){
        setLayout(null);//Inicializar
        label1=new JLabel("Nombre: ");//Crear el label
        label1.setBounds(0,0,100,150);//Cordenadas y Tamaño del label
        add(label1);//Añadir Label
        txt=new JTextField();
        txt.setBounds(50,100,300,50);
        add(txt);
        btn1=new JButton();
        btn1.setText("Hola");
        btn1.setBounds(100,200,100,25);
        add(btn1);
    }
    
    public static void main(String[] args) {
        TAP_Unidad01_Tarea03 pantalla = new TAP_Unidad01_Tarea03();//Empezar la pantalla
        pantalla.setBounds(0,0,400,300);//cordenadas y tamaño de la pantalla
        pantalla.setVisible(true);//Hacer visible la pantalla
        pantalla.setLocationRelativeTo(null);//Centrar la pantalla
    }
}
