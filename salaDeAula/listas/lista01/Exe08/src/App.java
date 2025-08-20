import java.util.Random;
import java.util.Scanner;

// 8) Vetores
// a) Criar um vetor de tamanho 20 de inteiros CHECK!
// b) Preencher os 10 primeiros valores do vetor com números digitados pelo usuário via teclado
// c) Preencher os 10 últimos valores do vetor com números aleatórios entre 1 e 100
// d) Mostrar o vetor inteiro na tela
// e) Mostrar o vetor de trás para frente na tela
// f) Calcular e mostrar a média dos valores do vetor
// g) Encontrar e mostrar o maior valor e o menor valor do vetor 
// h) Mostrar os valores das posições pares do vetor
// i) Mostrar os valores das posições ímpares do vetor
// j) Mostrar os valores pares do vetor
// k) Mostrar os valores ímpares do vetor
// l) Verificar se há elementos repetidos no vetor e exibir uma mensagem em caso afirmativo
// m) Solicitar um valor ao usuário e verificar se esse valor existe no vetor. Se existir exibir a posição em que ele está, senão exibir uma mensagem de valor não encontrado 
// n) Verificar se o vetor está em ordem crescente, ou seja, se a[0] <= a[1] <= a[2] <= ... para todos elementos do vetor 

public class App {

    public static Boolean crescente(int[] numbers){
        Boolean crescente = true; 

        for(int i=0; i<numbers.length-1; i++){
            if(numbers[i] > numbers[i+1])
                return false;
        }
        return crescente;
    }
    
    public static Boolean repetido(int[] numbers){

        for(int i=0; i<numbers.length; i++){

            for(int j=i+1; j<numbers.length; j++){

                if(numbers[i] == numbers[j])
                    return true;
            }
        }
        return false;
    }

    public static int buscaSequencia(int[] numbers, int num){

        for(int i=0; i<numbers.length; i++){
            if(num == numbers[i])
                return i;
        }
        return -1;
    }
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);

        int numbers[];
        numbers = new int[20];
        Random r = new Random();

        //B
        for(int i=0; i<((numbers.length)/2); i++){
            numbers[i] = s.nextInt();
        }

        //C
        for(int i=(numbers.length/2); i<numbers.length; i++){
            numbers[i] = r.nextInt(101);
        }

        //D
        System.out.println("Vetor");
        for(int i : numbers)
            System.out.print(i + " ");

        System.out.println();

        //E
        System.out.println("Vetor invertido");
        for(int i = numbers.length-1; i >= 0; i--){
            System.out.print(numbers[i] + " ");
        }
        System.out.println();

        //F
        double media = 0;
        int count=0;
        for(int aux: numbers){
            count++;
            media += aux;
        }
        System.out.println("A média do vetor é: " + (media/count));

        //G
        int maior = numbers[0];
        for(int aux : numbers){
            if(maior < aux)
                maior = aux;
        }
        System.out.println("O maior número é " + maior);
        
        int menor = numbers[0]; 
        for(int aux : numbers){
            if(menor > aux)
                menor = aux;
        }
        System.out.println("O menor número é " + menor);

        //H
        System.out.println("Posições Impares");
        for(int i=0; i<numbers.length; i++){
            if(i%2 != 0)
                System.out.print(numbers[i] + " ");
        }
        System.out.println();

        //I
        System.out.println("Posições Pares");
        for(int i=0; i<numbers.length; i++){
            if(i%2 == 0)
                System.out.print(numbers[i] + " ");
        }
        System.out.println();

        //J
        System.out.println("Números Pares");
        //num pares
        for(int aux : numbers){
            if(aux % 2 == 0)
                System.out.print(aux + " ");
        }
        System.out.println();

        //K
        System.out.println("Números impares");
        //num impar
        for(int aux : numbers){
            if(aux % 2 != 0)
                System.out.print(aux + " ");
        }
        System.out.println();

        //L
        System.out.println("Número repetido?");
        
        if(repetido(numbers))
            System.out.println("Seu array tem elemento repetido!");
        else
            System.out.println("Seu array não tem elemento repetido!");
    
        //M
        int x = s.nextInt(), existe = buscaSequencia(numbers, x);

        if(existe != -1)
            System.out.println("Seu número está na posição [" + existe + "]");
        else
            System.out.println("Seu número não foi encontrado!");

        //N
        int vetando[] = {1, 2, 1, 4, 5};

        System.out.println("Vetor crescente?");
        if(crescente(vetando))
            System.out.println("CRESCENTE!");
        else 
            System.out.println("NÃO CRESCENTE!");

        s.close();
    }
}