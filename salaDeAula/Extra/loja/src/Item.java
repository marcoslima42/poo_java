import java.math.BigDecimal;

public class Item {
    private long codigo;
    private int quantidade;
    private BigDecimal valor;
    private Produto produto;

    public Item(long codigo, int quantidade, BigDecimal valor, Produto produto) {
        this.codigo = codigo;
        this.quantidade = quantidade;
        this.valor = valor;
        this.produto = produto;
    }

    public long getCodigo() {
        return codigo;
    }
    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public BigDecimal getValor() {
        return valor;
    }
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
    public Produto getProduto() {
        return produto;
    }
    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public String toString() {
        return "Item [codigo=" + codigo + ", quantidade=" + quantidade + ", valor=" + valor + ", produto=" + produto
                + "]";
    }    
}
