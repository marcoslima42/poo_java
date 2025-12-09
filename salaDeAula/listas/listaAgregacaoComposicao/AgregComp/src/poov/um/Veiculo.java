package poov.um;

public class Veiculo {
    private int peso; 
    private int velocMax;
    private double preco;
    Motor motor = new Motor();


    public Veiculo(){
        peso = 10;
        velocMax = 100;
        preco = 100.5;
        motor.setNumCilindros(10);
        motor.setPotencia(1000);
    }

    public Veiculo(int peso, int velocMax, double preco, Motor motor){
        this.peso = peso;
        this.velocMax = velocMax;
        this.preco = preco;
        this.motor = motor;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public void setVelocMax(int velocMax) {
        this.velocMax = velocMax;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    @Override
    public String toString() {
        return "Veiculo [peso=" + peso + ", velocMax=" + velocMax + ", preco=" + preco + ", motor=" + motor + "]";
    }

    
}
