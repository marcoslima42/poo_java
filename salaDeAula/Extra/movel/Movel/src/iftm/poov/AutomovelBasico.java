package iftm.poov;

import java.math.BigDecimal;

public class AutomovelBasico extends Automovel{
    private Boolean retrovisorPassageiro;
    private Boolean limpaVidroTraseiro;
    private Boolean radio;

    public AutomovelBasico(String modelo, String cor, String combustivel, 
                            Boolean retrovisorPassageiro, Boolean limpaVidroTraseiro, Boolean radio){
        super(modelo, cor, combustivel);
        setRetrovisorPassageiro(retrovisorPassageiro);
        setLimpaVidroTraseiro(limpaVidroTraseiro);
        setRadio(radio);
    }


    public Boolean isRetrovisorPassageiro() {
        return retrovisorPassageiro;
    }

    public void setRetrovisorPassageiro(Boolean retrovisorPassageiro) {
        this.retrovisorPassageiro = retrovisorPassageiro;
    }

    public Boolean isLimpaVidroTraseiro() {
        return limpaVidroTraseiro;
    }

    public void setLimpaVidroTraseiro(Boolean limpaVidroTraseiro) {
        this.limpaVidroTraseiro = limpaVidroTraseiro;
    }

    public Boolean isRadio() {
        return radio;
    }

    public void setRadio(Boolean radio) {
        this.radio = radio;
    }
    
    @Override
    public BigDecimal getPreco(){
        BigDecimal valor = super.getPreco();

        if(limpaVidroTraseiro){
            valor.add(new BigDecimal("250"));
        }
        if(retrovisorPassageiro){
            valor = valor.add(new BigDecimal("100"));
        }
        if(radio){
            valor = valor.add(new BigDecimal("300"));
        }

        return valor;
    }


    @Override
    public String toString() {
        return "AutomovelBasico [retrovisorPassageiro=" + retrovisorPassageiro + ", limpaVidroTraseiro="
                + limpaVidroTraseiro + ", radio=" + radio + ", isRetrovisorPassageiro()=" + isRetrovisorPassageiro()
                + ", isLimpaVidroTraseiro()=" + isLimpaVidroTraseiro() + ", isRadio()=" + isRadio() + "]";
    }
}
