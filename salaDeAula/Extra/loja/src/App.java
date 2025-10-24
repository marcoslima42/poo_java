import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    private static Scanner s = new Scanner(System.in);
    private static ArrayList <Cliente> clientes = new ArrayList<>();
    private static ArrayList <Item> itens = new ArrayList<>();
    private static ArrayList <Produto> produtos = new ArrayList<>();
    private static ArrayList <Venda> vendas = new ArrayList<>();

    public static void cadastrarCliente(long proximoCodigoCliente, String nome, String contato){
        Cliente novo = new Cliente(proximoCodigoCliente++, nome, contato);
        clientes.add(novo);
    }

    public static void cadastrarItem(long proximoCodigoItem, int quantidade, BigDecimal valor, Produto produto){
        Item novo = new Item(proximoCodigoItem, quantidade, valor, produto);
        itens.add(novo);
    }

    public static void cadastrarProduto(long proximoCodigoProduto, String nome, BigDecimal preco) {
        Produto novo = new Produto(proximoCodigoProduto, nome, preco);
        produtos.add(novo);
    }

    public static void cadastrarVenda(long proximoCodigoVenda, LocalDate data, LocalTime hora, BigDecimal valor, Cliente cliente, Item item){
        Venda novo = new Venda(proximoCodigoVenda, data, hora, valor, cliente);
        vendas.add(novo);
    }

    public static BigDecimal obterValor(BigDecimal valor, int qtd){
        return valor.multiply(BigDecimal.valueOf(qtd));
    }

    public static Produto buscarProduto(long codigo){
        for(Produto elem : produtos){
            if(elem.getCodigo() == codigo)
                return elem;
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        long proximoCodigoCliente=1L;
        long proximoCodigoItem=1L;
        long proximoCodigoProduto=1L;
        long proximoCodigoVenda=1L;
        
        
        //variaveis de entrada  
        BigDecimal preco = new BigDecimal("10");
        LocalDate data;
        LocalTime hora;
        String texto;
        long codigo;
        int qtd;
        Produto prodAtual;
    
        cadastrarCliente(proximoCodigoCliente++, "Grosbilda", "grosbilda@seilah.com");
        cadastrarProduto(proximoCodigoProduto++, "Carrinho", preco);
        
        Boolean comprando = true;

        do{
            System.out.println("Qual o codigo do produto?");
            codigo = s.nextLong();
            prodAtual = buscarProduto(codigo);

            while(prodAtual == null){
                System.out.println("Produto Não existe, digite outro: ");
                codigo = s.nextLong();
                prodAtual = buscarProduto(codigo);
            }

            System.out.println("Quantidade: ");
            qtd = s.nextInt();

            cadastrarVenda(proximoCodigoVenda++, LocalDate.now(), LocalTime.now(), obterValor(produtos.get(codigo)), qtd);
            
  
        }while(comprando);



        
    }
}
