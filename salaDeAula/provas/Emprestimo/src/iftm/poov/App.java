package iftm.poov;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        int opc = 1;
        Scanner s = new Scanner(System.in);

        ArrayList <Emprestimo> listaEmprestimo = new ArrayList<>();
        String item, nomePessoa, data;
        LocalDate dataEmprestimo;
        DateTimeFormatter brasilFormatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        //loop principal

        do{

            System.out.println("1 - Cadastrar Empréstimo");
            System.out.println("2 - Sair\n\n");
            System.out.print("Opção: ");

            opc = s.nextInt();
            s.nextLine();

            if(opc != 1)
                break;

            item = s.nextLine();
            nomePessoa = s.nextLine();
            data = s.nextLine();
            dataEmprestimo = LocalDate.parse(data, brasilFormatador);

            listaEmprestimo.add(new Emprestimo(item, nomePessoa, dataEmprestimo));

            System.out.println("\n\n\n");

        }while(true);

        if(!listaEmprestimo.isEmpty()){
            listaEmprestimo.get(0).finalizar();
        }
        int countNDevolvidos = 0;
        for(Emprestimo elem : listaEmprestimo){
            if(!elem.isDevolvido()){
                countNDevolvidos++;
            }
        }

        System.out.println(countNDevolvidos + " emprestimos não foram devolvidos\n");

        for(Emprestimo elem : listaEmprestimo){
            if(!elem.isDevolvido()){
                System.out.println(elem.toString()); 
                System.out.println("Emprestado a " +  elem.diasEmprestado() + " dias");
                System.out.println("\n\n\n");
            }
        }

        s.close();
    }
}
