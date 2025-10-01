package iftm.poov;

import java.math.BigDecimal;

public enum Combustivel {
    ALCOOL("alcool", new BigDecimal("17000")), 
    FLEX("flex", new BigDecimal("19000")),
    GASOLINA("gasolina", new BigDecimal("20000")),
    DIESEL("diesel", new BigDecimal("25000")),
    GAS("gas", new BigDecimal("30000")), 
    HIBRIDO("hibrido", new BigDecimal("25000")),
    ELETRICO("eletrico", new BigDecimal("28000"));
    
    private String descricao;
    private BigDecimal valor;


    private Combustivel(String descricao, BigDecimal valor){
        this.descricao = descricao;
        this.valor = valor;
    }


    public String getDescricao() {
        return descricao;
    }


    public BigDecimal getPreco() {
        return valor;
    }

}
