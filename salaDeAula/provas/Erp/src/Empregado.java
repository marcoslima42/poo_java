import java.time.LocalDate;

public class Empregado implements Trabalhador{
    private Long codigo;
    private String nome;
    private String cpf;
    private LocalDate nascimento;
    private double salario;
    
    public Empregado(Long codigo, String nome, String cpf, LocalDate nascimento, double salario) {
        this.codigo = codigo;
        this.nome = nome;
        this.cpf = cpf;
        this.nascimento = nascimento;
        this.salario = salario;
    }

    public Long getCodigo() {
        return codigo;
    }


    public String getNome() {
        return nome;
    }


    public String getCpf() {
        return cpf;
    }


    public LocalDate getNascimento() {
        return nascimento;
    }


    public double getSalario() {
        return salario;
    }
    
    public void executarTrabalho(){
        System.out.println("Empregado executou o trabalho.");
    }

    @Override
    public String toString() {
        return "Empregado [codigo=" + codigo + ", nome=" + nome + ", cpf=" + cpf + ", nascimento=" + nascimento
                + ", salario=" + salario + "]";
    }

    

}
