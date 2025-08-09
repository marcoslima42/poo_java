package salaDeAula;
import java.math.BigInteger;
import java.util.Scanner;

// ALT + SHIFT O
public class Fatorial {

    public static void main (String args[]) {

        Scanner s = new Scanner(System.in);
        BigInteger numero, fatorial;

        System.out.println("Digite o número: ");
        numero = s.nextBigInteger(); 
        fatorial = numero;

        
        for(numero = numero.subtract(BigInteger.ONE); 
            numero.compareTo(BigInteger.ONE) == 1;
            numero = numero.subtract(BigInteger.ONE)){
            
            fatorial = fatorial.multiply(numero);
        }

        System.out.println("Fatorial: " + fatorial);
        s.close();
    }
}
