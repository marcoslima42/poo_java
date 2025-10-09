public class Motor {
    private int potencia;
    private boolean ligado;

    public Motor(){
        potencia = 60;
    }
    public Motor(int potencia, boolean ligado) {
        this.potencia = potencia;
        this.ligado = ligado;
    }
    public int getPotencia() {
        return potencia;
    }
    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }
    public boolean isLigado() {
        return ligado;
    }
    public void setLigado(boolean ligado) {
        this.ligado = ligado;
    }

    

    @Override
    public String toString() {
        return "motor [potencia=" + potencia + ", ligado=" + ligado + "]";
    }
}
