package iftm.poov;

import java.math.BigDecimal;

public class Funcionario extends Pessoa{
    private long codigo;
    private BigDecimal salario;

    public Funcionario(){
        //já faz isso pois chama o padrão da superclasse
        //super("Marcos", "45564", "Rua desdemona de Stefani 51", "34 992271090");
        codigo = 58799;
        salario = BigDecimal.valueOf(10000);
    }

    public Funcionario(String nome, String cpf, String endereco, String contato, long codigo, BigDecimal salario){
        super(nome, cpf, endereco, contato);
        this.codigo = codigo;
        this.salario = salario;
    }

    public long getCodigo() {
        return codigo;
    }
    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }
    public BigDecimal getSalario() {
        return salario;
    }
    public void setSalario(BigDecimal salario) {
        if(salario.compareTo(BigDecimal.ZERO) >= 0){
            this.salario = salario;
        } else {
            System.err.println("Valor invalido de salario. Usando o valor padrão 0.");
            this.salario = salario;
        }
        this.salario = salario;
    }

    public BigDecimal getPagamento(){
        return salario;
    }
    
    @Override
    public void mostrar() {
        super.mostrar();

        System.out.println("Código: " + getCodigo());
        System.out.println("Salário: " + getSalario());
    }
}
