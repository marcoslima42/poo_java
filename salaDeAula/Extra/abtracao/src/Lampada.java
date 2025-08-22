public class Lampada {
    public int tensao;
    public int potencia;
    public boolean acesa;
    public boolean queimada;
    public boolean quebrada;

    public Lampada() {
        System.out.println("Construtor padrao da lampada executado");
        tensao = 220;
        potencia = 60;
    }

    public Lampada(int t, int p){
        System.out.println("Construtot de inicializacao 1 da lampada");
        tensao = t;
        potencia = p;
    }

    public Lampada(int t, int p, boolean a){
        System.out.println("Construtor da lampada 2");
        tensao = t;
        potencia = p;
        acesa = true;
    }

    public void mostrar() {
        System.out.println("Tensão: " + tensao + "V");
        System.out.println("Potência: " + potencia + "W");
        System.out.println(acesa ? "Acesa" : "Apagada");
        if(queimada){
            System.out.println("Queimada");
        }
        if(quebrada){
            System.out.println("Quebrada");
        }
        System.out.println();
    }
}
