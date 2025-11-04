import java.time.LocalDate;

public class Poupanca extends Conta {
    private double rendimento;

    public Poupanca(long codigo, LocalDate criacao, double saldo, double rendimento) {
        super(codigo, criacao, saldo);
        this.rendimento = rendimento;
    }

    public double getRendimento() {
        return rendimento;
    }

    public void setRendimento(double rendimento) {
        this.rendimento = rendimento;
    }

    public void aplicarRendimento(){
        double res;

        res = super.getSaldo() + (getSaldo() * rendimento);
        super.setSaldo(res);
    }

    @Override
    public String toString() {
        return "Poupanca [rendimento=" + rendimento + ", toString()=" + super.toString() + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(rendimento);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Poupanca other = (Poupanca) obj;
        if (Double.doubleToLongBits(rendimento) != Double.doubleToLongBits(other.rendimento))
            return false;
        return true;
    }
}
