import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Venda {
    private long codigo;
    private LocalDate data;
    private LocalTime hora;
    private BigDecimal valor;
    private Cliente cliente;
    private ArrayList <Item> itens = new ArrayList<>();

    public Venda(long codigo, LocalDate data, LocalTime hora, BigDecimal valor, Cliente cliente) {
        this.codigo = codigo;
        this.data = data;
        this.hora = hora;
        this.valor = valor;
        this.cliente = cliente;
    }



    public long getCodigo() {
        return codigo;
    }



    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }



    public LocalDate getData() {
        return data;
    }



    public void setData(LocalDate data) {
        this.data = data;
    }



    public LocalTime getHora() {
        return hora;
    }



    public void setHora(LocalTime hora) {
        this.hora = hora;
    }



    public BigDecimal getValor() {
        return valor;
    }



    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }



    public Cliente getCliente() {
        return cliente;
    }



    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }



    public ArrayList<Item> getItens() {
        return itens;
    }



    public void setItens(ArrayList<Item> itens) {
        this.itens = itens;
    }


    public void addItem(Item novo){
        itens.add(novo);
    }

    @Override
    public String toString() {
        return "Venda [codigo=" + codigo + ", data=" + data + ", hora=" + hora + ", valor=" + valor + ", cliente="
                + cliente + ", itens=" + itens + "]";
    }

}
