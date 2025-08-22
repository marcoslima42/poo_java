import java.util.Random;
import java.util.Scanner;

// 9) Matrizes

// a) Criar 5 matrizes 3x3
// b) Preencher as 2 primeiras matrizes com valores aleatórios entre 1 e 10
// c) Mostrar a 1ª matriz na tela no formato
// 	A	B	C
// 	D	E	F
// 	G	H	I
// d) Criar a matriz transposta da 1ª matriz na 3ª matriz e mostrá-la
// e) Achar e mostrar o maior e o menor elementos da 1ª matriz mostrando também suas posições
// f) Calcular e mostrar o determinante da 1ª matriz
// g) Somar as 2 primeiras matrizes na 4ª matriz e mostrá-la
// h) Multiplicar as 2 primeiras matrizes na 5ª matriz e mostrá-la

public class App {
    
    public static void multiMatrix(int m1[][], int m2[][], int m3[][]){
        

        for(int i=0; i<m1.length; i++){
            for(int j=0; j<m1.length; j++){   
                for(int k = 0; k< m1[i].length; k++){
                    m3[i][j] += m1[i][k]*m2[k][j];
                }
            }
        }
    }

    public static void imprimirMatrix(int m[][]){
        for(int i=0; i<m.length; i++){
            for(int j=0; j<m[i].length; j++){
                System.out.print("   " + m[i][j]);
            }
            System.out.println();
        }
    }

    public static int sarrus(int m[][]){
        int dPrincipal, dSecundaria;

        dPrincipal = m[0][0]*m[1][1]*m[2][2];
        dPrincipal += m[0][1]*m[1][2]*m[2][0];
        dPrincipal += m[0][2]*m[1][0]*m[2][1];

        dSecundaria = m[0][2]*m[1][1]*m[2][0];
        dSecundaria += m[0][0]*m[1][2]*m[2][1];
        dSecundaria += m[0][1]*m[1][0]*m[2][2];

        return dPrincipal - dSecundaria;
    }
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner (System.in);
        Random r = new Random();

        int matrix1 [][] = new int[3][3];
        int matrix2 [][] = new int[3][3];
        int matrix3 [][] = new int[3][3];
        int matrix4 [][] = new int[3][3];
        int matrix5 [][] = new int[3][3];

        //preencher matriz
        for(int i=0; i<matrix1.length; i++){
            for(int j=0; j<matrix1[i].length; j++){
                matrix1[i][j]= r.nextInt(10)+1;
                matrix2[i][j]= r.nextInt(10)+1;
            }
        }
        //imprimir matriz no formato padrao
        System.out.println("MATTRIZ 1: ");
        imprimirMatrix(matrix1);

        System.out.println();
        
        //criar transposta
        for(int i=0; i<matrix1.length; i++){
            for(int j=0; j<matrix1[i].length; j++){
                matrix3[i][j] = matrix1[j][i];
            }
        }
        //imprimir transposta
        System.out.println("MATRIZ 3, TRANSPOSTA: ");
        imprimirMatrix(matrix3);

        System.out.println();
        System.out.println();
        //achar menor e maior com posicoes
        int menor = matrix1[0][0], xMenor=0, yMenor=0;
        int maior = matrix1[0][0], xMaior=0, yMaior=0;

        for(int i=0; i<matrix1.length; i++){
            for(int j=0; j<matrix1[i].length; j++){
                if(maior < matrix1[i][j]){
                    maior = matrix1[i][j];
                    xMaior = i; yMaior = j;
                }
                
                if(menor > matrix1[i][j]){
                    menor = matrix1[i][j];
                    xMenor = i; yMenor = j;
                }
            }
        }

        System.out.println("Maior número da Matriz " + maior + " , na posição [" + xMaior + "]" + "[" + yMaior + "]");
        System.out.println("Menor número da Matriz " + menor + " , na posição [" + xMenor + "]" + "[" + yMenor + "]");

        System.out.println("\n");
        
        //determinante
        System.out.println("O Determinante da Matriz 1 é " + sarrus(matrix1));

        //somar matrizes
        for(int i=0; i<matrix1.length; i++){
            for(int j=0; j<matrix1[i].length; j++){
                matrix4[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        System.out.println("IMPRIMIR SOMA DAS MATRIZES, MATRIZ 4");
        imprimirMatrix(matrix4);

        //multipilcar matrizes 
        multiMatrix(matrix1, matrix2, matrix5);

        System.out.println();
        System.out.println("MULTIPLICACÃO DE MATRIZES");
        System.out.println("MATRIZ 1\n");
        imprimirMatrix(matrix1);
        System.out.println("MATRIZ 2\n");
        imprimirMatrix(matrix2);
        System.out.println("MATRIZ 5\n");
        imprimirMatrix(matrix5);



        s.close();
    }
}
