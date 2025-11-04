import java.time.LocalDate;

public class Conta {
    private long codigo;
    private LocalDate criacao;
    private double saldo;

    public Conta(long codigo, LocalDate criacao, double saldo){
        this.codigo = codigo;
        this.criacao = criacao;
        this.saldo = saldo;
    }

    public Conta() {

    }

    public long getCodigo() {
        return codigo;
    }

    public LocalDate getCriacao() {
        return criacao;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Conta [codigo=" + codigo + ", criacao=" + criacao + ", saldo=" + saldo + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (codigo ^ (codigo >>> 32));
        result = prime * result + ((criacao == null) ? 0 : criacao.hashCode());
        long temp;
        temp = Double.doubleToLongBits(saldo);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Conta other = (Conta) obj;
        if (codigo != other.codigo)
            return false;
        if (criacao == null) {
            if (other.criacao != null)
                return false;
        } else if (!criacao.equals(other.criacao))
            return false;
        if (Double.doubleToLongBits(saldo) != Double.doubleToLongBits(other.saldo))
            return false;
        return true;
    }

    


}
