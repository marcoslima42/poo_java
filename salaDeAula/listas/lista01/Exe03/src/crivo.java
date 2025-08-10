import java.util.Arrays;

public class crivo {
    
    public static void main(String[] args) throws Exception {
        int n = 100;
        n++;
        int primos[] = new int[n];

        Arrays.fill(primos, -1);

        for(int i=2; i * i < n; i++){ //loop ate a raiz de n, dara a quantidade de primos para marcar os compostos

            if(primos[i] == -1){ //se for indefinido
                // primos[i] = 1;  

                //marcar somente os numeros compostos
                for(int j=i*i; j < n; j+=i){
                    primos[j] = 0;
                }
            }
        }
        
        for(int i=2; i < n; i++){
            if(primos[i] != 0)
                System.out.print(i + " ");
        }
    }

}
//2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89 e 97