package iftm.poov;

import java.math.BigDecimal;

public abstract class Automovel {

    private String modelo;
    private String cor;
    private Combustivel descricao;

    public Automovel(String modelo, String cor, String combustivel){
        System.out.println("Construtor de inicialização do automovel");
        setModelo(modelo);
        setCor(cor);
        setDescricao(combustivel);
    }

    public void setDescricao(String combustivel) {
        if(combustivel.equals("GASOLINA")){
            this.descricao = Combustivel.GASOLINA;
        }
        else if(combustivel.equals("DIESEL")){
            this.descricao = Combustivel.DIESEL;
        }
        else if(combustivel.equals("ALCOOL")){
            this.descricao = Combustivel.ALCOOL;
        }
        else if(combustivel.equals("FLEX")){
            this.descricao = Combustivel.FLEX;
        }
        else if(combustivel.equals("GAS")){
            this.descricao = Combustivel.GAS;
        }
        else if(combustivel.equals("HIBRIDO")){
            this.descricao = Combustivel.HIBRIDO;
        }
        else if(combustivel.equals("ELETRICO")){
            this.descricao = Combustivel.ELETRICO;
        }
    }

    public String getModelo() {
        return modelo;
    }


    public void setModelo(String modelo) {
        this.modelo = modelo;
    }


    public String getCor() {
        return cor;
    }


    public void setCor(String cor) {
        this.cor = cor;
    }

    public BigDecimal getPreco(){
        return descricao.getPreco();
    }
    
    public String getCombustivel(){
        return descricao.getDescricao();
    }

    @Override
    public String toString() {
        return "Automovel [modelo=" + modelo + ", cor=" + cor + ", descricao=" + descricao + "]";
    }

    
}


