package salaDeAula;

import java.util.Scanner;

public class Palindromo {
    public static void main (String args[]) {
    Scanner s = new Scanner(System.in);
    
    StringBuilder nome = new StringBuilder(s.nextLine());
    StringBuilder inverso;
    
    inverso = nome.reverse();

    if((nome.toString()).equals(inverso.toString()))
        System.out.println("É palindromo :) ");
    else
        System.out.println("Não é palindromo :( ");

    s.close();
}
}
