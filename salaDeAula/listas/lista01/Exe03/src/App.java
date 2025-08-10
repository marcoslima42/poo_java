import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner s = new Scanner(System.in);
        
        System.out.println("Digite um numero para verificar se e primo: ");
        int num = s.nextInt(), i=2;
        boolean primo = true;

        while(i*i <= num){

            if(num%i == 0){
                primo = false;
                break;
            }
            i++;
        }

        if(primo && num > 1)
            System.out.println("Seu número é primo!");
        else
            System.out.println("Seu número não é primo!");

        s.close();
    }
}

//2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89 e 97