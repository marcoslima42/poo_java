package poov.um;

public class Motor {
    private int numCilindros;
    private int potencia;

    public Motor(){
        numCilindros = 10;
        potencia = 100;
    }

    public Motor(int numCilindros, int potencia){   
        this.numCilindros = numCilindros;
        this.potencia = potencia;
    }

    public void setNumCilindros(int numCilindros) {
        this.numCilindros = numCilindros;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    @Override
    public String toString() {
        return "Motor [numCilindros=" + numCilindros + ", potencia=" + potencia + "]";
    }
}

