import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        Scanner s = new Scanner(System.in);
        char opc;
        double num1=0, num2=0, resp=0;
        boolean exec = true;

        while (exec) {
            System.out.println("+ Soma");
            System.out.println("- Subtração");
            System.out.println("* Multiplicação ");
            System.out.println("/ Divisão");
            System.out.println("% Módulo");
            System.out.println("S Sair");

            System.out.println("Digite sua opção: ");
            opc = s.next().charAt(0);     
            
            if(opc != 'S'){
                System.out.println("Digite o numero 1: ");
                num1 = s.nextDouble();
                System.out.println("Digite o numero 2: ");
                num2 = s.nextDouble();
            }
            
            switch (opc) {
                case '+':
                    resp = num1 + num2;
                    System.out.println("Resultado: " + resp);
                    break;
                case '-':
                    resp = num1 - num2;
                    System.out.println("Resultado: " + resp);
                    break;
                case '*':
                    resp = num1 * num2;
                    System.out.println("Resultado: " + resp);
                    break;
                case '/':
                    resp = num1 / num2;
                    System.out.println("Resultado: " + resp);
                    break;
                case '%':
                    resp = num1 % num2;
                    System.out.println("Resultado: " + resp);
                    break;
                case 'S':
                    exec=false;
                    break;
            }

        }

        s.close();
    }
}
