import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner s = new Scanner(System.in);
        
        StringBuilder nome = new StringBuilder(s.nextLine());
        StringBuilder inverso = new StringBuilder(nome);
        
        inverso.reverse();

        if((nome.toString()).equalsIgnoreCase(inverso.toString()))
            System.out.println("É palindromo :) ");
        else
            System.out.println("Não é palindromo :( ");

        s.close();
    }
}

