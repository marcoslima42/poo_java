import java.time.LocalDate;

public class Desenvolvedor extends Empregado{
    private String nivel;

    public Desenvolvedor(Long codigo, String nome, String cpf, LocalDate nascimento, double salario, String nivel) {
        super(codigo, nome, cpf, nascimento, salario);
        this.nivel = nivel;
    }

    public String getNivel() {
        return nivel;
    }

    @Override
    public void executarTrabalho() {
        System.out.println("Desenvolvedor executou o trabalho.");
    }

    @Override
    public String toString() {
        return "Desenvolvedor [nivel=" + nivel + super.toString() + "]";
    }


    
}
