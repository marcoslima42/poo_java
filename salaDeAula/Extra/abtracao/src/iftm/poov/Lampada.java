package iftm.poov;
public class Lampada {

    private int tensao;
    private int potencia;
    private boolean acesa;  // false
    private boolean queimada;  // false
    private boolean quebrada;  // false

    public Lampada() {
        System.out.println("Construtor padrao da Lampada executado");
        tensao = 220;
        potencia = 60;
    }

    public Lampada(int tensao, int potencia) {
        System.out.println("Construtor de inicializacao 1 da Lampada executado");
        setTensao(this.tensao);
        setPotencia(this.potencia);
    }

    public Lampada(int tensao, int potencia, boolean acessa) {
        System.out.println("Construtor de inicializacao 2 da Lampada executado");
        setTensao(tensao);
        setPotencia(potencia);
        this.acesa = acessa;
    }

    public void setTensao(int tensao) {
        if (tensao == 127 || tensao == 220) {
            this.tensao = tensao;
        } else {
            System.out.println("Valor inválido de tensão. Usando o valor padrão 220V.");
            this.tensao = 220;
        }
    }

    public int getTensao() {
        return tensao;
    }

    public void setPotencia(int potencia) {
        if (potencia == 60 || potencia == 100 || potencia == 150) {
            this.potencia = potencia;
        } else {
            System.out.println("Valor inválido de potência. Usando o valor padrão 60W.");
            this.potencia = 60;
        }
    }

    public int getPotencia() {
        return potencia;
    }

    public void setAcesa(boolean acesa) {
        if (acesa) {  // quer acender
            if (!quebrada && !queimada) {
                this.acesa = acesa;
            } else {
                System.out.println("Impossível acender uma lâmpada quebrada/queimada");
                this.acesa =false;
            }
        } else {
            this.acesa = acesa;
        }
    }

    public boolean isAcesa() {
        return acesa;
    }

    public void setQuebrada(boolean quebrada) {
        this.quebrada = quebrada;
        if (quebrada) {  // quer quebrar
            if (acesa) {
                queimada = true;
                acesa = false;
            }
        }
    }

    public boolean isQuebrada() {
        return quebrada;
    }

    public void setQueimada(boolean queimada) {
        this.queimada = queimada;
        if (queimada) { // quer queimar
            if (acesa) {
                acesa = false;
            }
        } 
    }

    public boolean isQueimada() {
        return queimada;
    }

    public void acender() {
        setAcesa(true);
    }

    public void apagar() {
        // setAcesa(false);
        acesa = false;
    }

    public void quebrar() {
        setQuebrada(true);
    }

    public void queimar() {
        setQueimada(true);
    }

    public void mostrar() {
        System.out.println("Tensao: " + tensao + "V");
        System.out.println("Potencia: " + potencia + "W");
        System.out.println(acesa ? "Acesa" : "Apagada");
        if (queimada) {
            System.out.println("Queimada");
        }
        if (quebrada) {
            System.out.println("Quebrada");
        }
    }


}