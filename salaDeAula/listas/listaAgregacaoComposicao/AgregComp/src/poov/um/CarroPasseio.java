package poov.um;

public class CarroPasseio extends Veiculo{
    private String cor;
    private String modelo;
    
    public CarroPasseio() {
        cor = "Branco";
        modelo = "batmobile";
    }

    public CarroPasseio(int peso, int velocMax, double preco, Motor motor, String cor, String modelo) {
        super(peso, velocMax, preco, motor);
        this.cor = cor;
        this.modelo = modelo;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "CarroPasseio [cor=" + cor + ", modelo=" + modelo + ", toString()=" + super.toString() + "]";
    }

}
