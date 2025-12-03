import java.time.LocalDate;

public class Gerente extends Empregado{
    private double bonus;

    public Gerente(Long codigo, String nome, String cpf, LocalDate nascimento, double salario, double bonus) {
        super(codigo, nome, cpf, nascimento, salario);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void executarTrabalho(){
        System.out.println("Gerente executou o trabalho.");
    }

    @Override
    public String toString() {
        return "Gerente [bonus=" + bonus + super.toString() + "]";
    }


}
