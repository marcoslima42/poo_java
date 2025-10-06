package iftm.poov;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        double valor;
        String escalaTexto;

        ArrayList <Temperatura> listaTemperatura = new ArrayList<>();
        
        for(int i=0; i<3; i++){
            for(int j=0; j<3; i++){
                valor = s.nextInt();
                s.nextInt();
                escalaTexto = s.nextLine().toUpperCase();

                listaTemperatura.add(new Temperatura(EscalaTemperatura.valueOf(escalaTexto), valor));
            }

        }

        

        

        System.out.println(listaTemperatura.get(0).getEscala()); 
        s.close();
    }
}
