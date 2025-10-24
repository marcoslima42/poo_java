import java.util.ArrayList;

public class Aluno {
    private int codigo;
    private String nome;
    private ArrayList<Professor> professores = new ArrayList<>();
    
    public Aluno(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Aluno [codigo=" + codigo + ", nome=" + nome + "]";
    }

    public void adicionarProfessor(Professor prof){   
        professores.add(prof);
    }

    public void mostrarProfessores(){
        System.out.println(professores);
    }
}
