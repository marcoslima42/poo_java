package exe01;

import java.util.Scanner;

public class Exe01 {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        String s1, s2, s3;

        s1 = "guardaroupaloucoroupa";//s.next();
        s2 = "roupa";//s.next();
        s3 = "supimpa!";

        int indice = 0;//s1.indexOf(s2);
        int vet[20];

        int aux=0;
        //a
        while((indice = s1.indexOf(s2, indice)) != -1){
            indice += s2.length();
            aux++;
        }

        System.out.println(aux + "qtd");

        //b
        s1 = s1.replaceAll(s2, s3);

        //if(s1.contains(s2)){
        System.out.println(s1);
        s.close();
    }
}
