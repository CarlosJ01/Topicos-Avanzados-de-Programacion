package pruebas;
import java.util.Random;
import java.util.Scanner;
public class Pruebas {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        Random ram = new Random();
        String semilla, snumero2, snumero3;
        
        int tam1,tam2, primerc,sumat=0;
        long numero1,numero2;
        String suma;
        int conv;
        
        System.out.println("Escriba semila: ");
        semilla=leer.next();
        
        tam1=semilla.length();
        System.out.println("Cantidad de digitos: "+tam1);
        
        numero1=Integer.parseInt(semilla);
        
        for (int j = 0; j < 27; j++) {
            numero2=(long)Math.pow(numero1, 2);
            snumero2=Long.toString(numero2);
            tam2=snumero2.length();
            primerc=(tam2-tam1)/2;
            snumero3=snumero2.substring(primerc,primerc+tam1);
            System.out.println((j+1)+"\t0."+snumero3);
             suma=("0."+snumero3);
             conv=Integer.parseInt(suma);
             sumat=sumat+conv;
            numero1=Integer.parseInt(snumero3);
            
        }
        System.out.println(sumat);
    }   
}