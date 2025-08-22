// 10) ArrayList

// a) Criar um ArrayList de inteiros
// b) Inserir 10 valores digitados pelo usuário no ArrayList
// c) Inserir 10 valores aleatórios entre 1 e 100 no ArrayList
// d) Mostrar o ArrayList inteiro na tela
// e) Mostrar o ArrayList de trás para frente na tela
// f) Calcular e mostrar a média dos valores do ArrayList
// g) Encontrar e mostrar o maior e o menor valores do ArrayList
// h) Mostrar os valores das posições pares do ArrayList
// i) Mostrar os valores das posições ímpares do ArrayList
// j) Mostrar os valores pares do ArrayList
// k) Mostrar os valores ímpares do ArrayList 
// l)Verificar se há elementos repetidos no ArrayList e exibir uma mensagem em caso afirmativo 
// m) Solicitar um valor ao usuário e verificar se esse valor existe no ArrayList. Se existir exibir a posição em que ele está, senão exibir uma mensagem de valor não encontrado 
// n) Verificar se o ArrayList está em ordem crescente, ou seja, se a[0] <= a[1] <= a[2] <= ... para todos elementos do ArrayList

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.ListIterator;
import java.util.Random;
import java.util.Scanner;

public class App {

    public static Boolean crescente(ArrayList<Integer> numbers){

        for(int i=0; i<numbers.size()-1; i++){
            if(numbers.get(i) > numbers.get(i+1))
                return false;
        }
        return true;
    }

    public static int buscaSequencia(ArrayList<Integer> numbers, int num){

        for(int i=0; i<numbers.size(); i++){
            if(num == numbers.get(i))
                return i;
        }
        return -1;
    }

    public static Boolean repetido(ArrayList<Integer> numbers){

        for(int i=0; i<numbers.size(); i++){

            for(int j=i+1; j<numbers.size(); j++){

                if(numbers.get(i) == numbers.get(j))
                    return true;
            }
        }
        return false;
    }
    public static void main(String[] args) throws Exception {
        Scanner keyboard = new Scanner(System.in);
        Random r = new Random();

        ArrayList<Integer> numbers;
        numbers = new ArrayList<>();
    
        for(int i=0; i<10; i++)
            numbers.add(keyboard.nextInt());
        
        for(int i=0; i<10; i++)
            numbers.add(r.nextInt(100)+1);
        
        System.out.println(numbers);

        ListIterator<Integer>  iterator = numbers.listIterator(numbers.size());
        
        while(iterator.hasPrevious())
            System.out.print(iterator.previous() + " ");
        
        //F
        double media = 0;
        for(Integer value: numbers){
            media += value;
        }
        System.out.println("A media do seu arraylist é: " + media/numbers.size());
        System.out.println();

        //G
        // int maior = numbers.get(0);
        // for(int aux : numbers){
        //     if(maior < aux)
        //         maior = aux;
        // }
        System.out.println("O maior número é " + Collections.max(numbers));


        // int menor = numbers.get(0); 
        // for(int aux : numbers){
        //     if(menor > aux)
        //         menor = aux;
        // }
        System.out.println("O menor número é " + Collections.min(numbers));

        System.out.println("Posições Impares");
        for(int i=1; i<numbers.size(); i+=2){
            System.out.print(numbers.get(i) + " ");
        }
        System.out.println();

        System.out.println("Posições Pares");
        for(int i=0; i<numbers.size(); i+=2){
            System.out.print(numbers.get(i) + " ");
        }
        System.out.println();

        System.out.println("Números Pares");
        //num pares
        for(int aux : numbers){
            if(aux % 2 == 0)
                System.out.print(aux + " ");
        }
        System.out.println();

        System.out.println("Números impares");
        //num impar
        for(int aux : numbers){
            if(aux % 2 != 0)
                System.out.print(aux + " ");
        }
        System.out.println();

        System.out.println("Número repetido?");
        
        if(repetido(numbers))
            System.out.println("Seu array tem elemento repetido!");
        else
            System.out.println("Seu array não tem elemento repetido!");
    

        
        
        // int x = keyboard.nextInt(), existe = buscaSequencia(numbers, x);

        // if(existe != -1)
        //     System.out.println("Seu número está na posição [" + existe + "]");
        // else
        //     System.out.println("Seu número não foi encontrado!");


        System.out.print("Digite um valor para encontrá-lo no Array: ");
        int n = keyboard.nextInt();

        if(numbers.contains(n))
            System.out.println("O valor existe no Array! Sua posição é " + numbers.indexOf(n));
        else
            System.out.println("O valor não existe no Array!");

        ArrayList<Integer> vetando = new ArrayList<>(Arrays.asList(1, 2, 1, 4, 5));

        System.out.println("Vetor crescente?");
        if(crescente(vetando))
            System.out.println("CRESCENTE!");
        else 
            System.out.println("NÃO CRESCENTE!");
        keyboard.close();
    }
}
