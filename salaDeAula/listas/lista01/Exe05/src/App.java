import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        String pass = "123456", in;
        Boolean loop = true;
        Scanner s = new Scanner(System.in);
        int count = 0;
        System.out.println("LOGIN");
        
        while(loop){

            System.out.println("Digite sua senha: ");
            in = s.nextLine();
            if(in.equals(pass) == false){
                System.out.println("SENHA INCORRETA!");
                count++;
            }
            else{
                System.out.println("Senha correta!");
                loop = false;
            }
            
            if(count == 3){
                System.out.println("Conta bloqueada, você errou 3 vezes a senha.");
                loop = false;
            }
        }

        s.close();
    }
}
