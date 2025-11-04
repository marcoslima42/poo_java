import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        ArrayList <Conta> contas = new ArrayList<>();
        ArrayList <Poupanca> poupancas = new ArrayList<>();
        Scanner s = new Scanner(System.in);

        int opc = 4;
        long codigoNormal = 1L;
        long codigoPoupanca = 1L;
        LocalDate criacao;
        double saldo;
        double rendimento = 0.1;
        

        do{
            System.out.println("Que tipo de conta deseja criar?");
            System.out.println("1 - Conta normal");
            System.out.println("2 - Conta Poupanca");

            opc = s.nextInt();

            switch (opc){
                case 1:
                    criacao = LocalDate.now();
                    System.out.println("Depósito inicial: ");
                    saldo = s.nextDouble();
                    s.nextLine();
                    contas.add(new Conta(codigoNormal++, criacao, saldo));
                    break;

                case 2:
                    criacao = LocalDate.now();
                    System.out.println("Depósito inicial: ");
                    saldo = s.nextDouble();
                    s.nextLine();
                    Poupanca novo = new Poupanca (codigoPoupanca++, criacao, saldo, rendimento);
                    novo.aplicarRendimento();
                    contas.add(novo);
                    break;  
            }
        }while(opc!=3);

        System.out.println(contas);

        System.out.println("+++++++++++++++++++++++++++++++++++++++");
        System.out.println(poupancas);
    }
}
