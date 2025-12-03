import java.util.ArrayList;
import java.util.List;

public class Departamento {
    private String nome;
    private List <Trabalhador> trabalhadores = new ArrayList<>();
    private Gerente gerente;

    public Departamento(String nome, Gerente gerente) {
        this.nome = nome;
        this.gerente = gerente;
    }


    public String getNome() {
        return nome;
    }


    public List<Trabalhador> getTrabalhadores() {
        return trabalhadores;
    }


    public Gerente getGerente() {
        return gerente;
    }


    public void adicionarTrabalhador(Trabalhador novo){
        trabalhadores.add(novo);
    }



    public void executarTrabalho(){
        for (Trabalhador elem : trabalhadores) {
            elem.executarTrabalho();
        }
    }


    @Override
    public String toString() {
        return "Departamento [nome=" + nome + ", trabalhadores=" + trabalhadores + ", gerente=" + gerente + "]";
    }

}
