package iftm.poov;

import java.math.BigDecimal;

public class Gerente extends Funcionario{
    private String area;
    private BigDecimal bonus;
    public Gerente(){
        
    }
    public String getArea() {
        return area;
    }
    public void setArea(String area) {
        this.area = area;
    }
    public BigDecimal getBonus() {
        return bonus;
    }
    public void setBonus(BigDecimal bonus) {
        if(bonus.compareTo(BigDecimal.ZERO) >= 0) {
            this.bonus = bonus;
        } else {
            System.err.println("Valor invalido de salario. Usando o valor padrão 0.");
            this.bonus = bonus;
        }
        this.bonus = bonus;
    }
    
    @Override
    public BigDecimal getPagamento(){
        return getSalario().add(bonus);
    }
}
