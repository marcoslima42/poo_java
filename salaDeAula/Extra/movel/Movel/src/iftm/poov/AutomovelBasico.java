package iftm.poov;

import java.math.BigDecimal;

public class AutomovelBasico extends Automovel{
    private Boolean retrovisorPassageiro;
    private Boolean limpaVidroTraseiro;
    private Boolean radio;

    public AutomovelBasico(String modelo, String cor, String combustivel){
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
        
    }
}
