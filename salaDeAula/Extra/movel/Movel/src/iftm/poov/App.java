package iftm.poov;
public class App {
    public static void main(String[] args) throws Exception {
        Automovel c1 = new Automovel("Nissan", "Amarelo", "FLEX");

        System.out.println("Modelo: " + c1.getModelo());
        System.out.println("Cor: " + c1.getCor());
        System.out.println("Combustivel: " + c1.getCombustivel());
        System.out.println("Valor do Carro: " + c1.getPreco());

        // for(var elemento : Combustivel.values())
        //     if ("gasolina".equalsIgnoreCase(elemento.getDescricao()))
        //         System.out.println(elemento.ordinal() + ") " + elemento);

    }
}
