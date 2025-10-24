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
    private static long proximoCodigoCliente=1L;
    private static long proximoCodigoItem=1L;
    private static long proximoCodigoProduto=1L;
    private static long proximoCodigoVenda=1L;

    public static void cadastrarCliente(long proximoCodigoCliente, String nome, String contato){
        Cliente novo = new Cliente(proximoCodigoCliente++, nome, contato);
        clientes.add(novo);
    }

    public static Item cadastrarItem(long proximoCodigoItem, int quantidade, BigDecimal valor, Produto produto){
        Item novo = new Item(proximoCodigoItem, quantidade, valor, produto);
        itens.add(novo);

        return novo;
    }

    public static void cadastrarProduto(long proximoCodigoProduto, String nome, BigDecimal preco) {
        Produto novo = new Produto(proximoCodigoProduto, nome, preco);
        produtos.add(novo);
    }

    public static Venda cadastrarVenda(long proximoCodigoVenda, LocalDate data, LocalTime hora, BigDecimal valor, Cliente cliente){
        Venda novo = new Venda(proximoCodigoVenda, data, hora, valor, cliente);
        vendas.add(novo);
        
        return novo;
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

    public static Cliente buscarCliente(long codigo){
        for(Cliente elem : clientes){
            if(elem.getCodigo() == codigo)
                return elem;
        }
        return null;
    }

    public static Item buscarItem(long codigo){
        for(Item elem : itens){
            if(elem.getCodigo() == codigo)
                return elem;
        }
        return null;
    }

    public static Item buscarVenda(long codigo){
        for(Item elem : itens){
            if(elem.getCodigo() == codigo)
                return elem;
        }
        return null;
    }

    public static void compra(Cliente clienteAtual){
        long codigo;
        int qtd;
        Produto prodAtual;
        Item itemAtual; 
        Venda vendaAtual = null;
        BigDecimal precoCompraTotal = new BigDecimal("0");
        Boolean comprando = true;
        Boolean primeiraVez = true;
        
        //loop do carrinho
        do{
            System.out.println("Qual o codigo do produto?");
            codigo = s.nextLong();
            prodAtual = buscarProduto(codigo);

            while(prodAtual == null){
                System.out.println("Produto não existe, digite outro: ");
                codigo = s.nextLong();
                prodAtual = buscarProduto(codigo);
            }

            System.out.println("Quantidade: ");
            qtd = s.nextInt();

            itemAtual = cadastrarItem(proximoCodigoItem, qtd, obterValor(prodAtual.getPreco(), qtd), prodAtual);

            System.out.println("Item adicionado com sucesso!");

            System.out.println("Continuar comprando? Digite 1 para SIM ou tecle qualquer tecla para NAO");
            qtd = s.nextInt();
            if(qtd != 1){
                comprando = false;
            }
            
            if(primeiraVez){
                vendaAtual = cadastrarVenda(proximoCodigoVenda++, LocalDate.now(), LocalTime.now(), precoCompraTotal, clienteAtual); 
                primeiraVez = false;
            }
            vendaAtual.addItem(itemAtual);
            precoCompraTotal = precoCompraTotal.add(itemAtual.getValor());
            vendaAtual.setValor(precoCompraTotal);

        }while(comprando);

        System.out.println("Compra realizada com sucesso!");
    }

    public static void main(String[] args) throws Exception {
        
        BigDecimal preco = new BigDecimal("10");

        cadastrarCliente(proximoCodigoCliente++, "Bruce Banner", "bruce@seilah.com");
        cadastrarProduto(proximoCodigoProduto++, "Oculos", preco);
        
        long codigo;
        Cliente clienteAtual;

        //entrada do cliente
        System.out.println("Insira o codigo do Cliente");
        codigo = s.nextLong();

        clienteAtual = buscarCliente(codigo);
        while(clienteAtual == null){
            System.out.println("Cliente não existe, digite outro: ");
            codigo = s.nextLong();
            clienteAtual = buscarCliente(codigo);
        }

        compra(clienteAtual);

        //teste saida
        System.out.println(vendas.get(0));
    }
}
