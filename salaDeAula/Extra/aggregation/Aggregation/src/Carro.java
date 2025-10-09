public class Carro {
    private String modelo;
    private String cor;
    private boolean ligado;
    private Motor motor;

    public Carro(){
        modelo = "sem modelo";
        cor = "sem cor";
        motor = new Motor();
    }

    public Carro(String modelo, String cor, boolean ligado, Motor motor) {
        this.modelo = modelo;
        this.cor = cor;
        this.ligado = ligado;
        this.motor = motor;
    }

    public String getModelo() {
        return modelo;
    }

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public boolean isLigado() {
        return ligado;
    }

    public void ligar(boolean ligado) {
        ligado = true;
        motor.ligar();
    }

    public void desligado(boolean ligado){
        ligado = false;
        motor.desligar
    }

    @Override
    public String toString() {
        return "Carro [modelo=" + modelo + ", cor=" + cor + ", ligado=" + ligado + ", motor=" + motor + "]";
    }

}
