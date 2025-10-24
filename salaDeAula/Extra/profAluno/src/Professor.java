import java.util.ArrayList;
//alt+shit+o
public class Professor {
    private int  codigo;
    private String nome;
    private ArrayList<Aluno> alunos = new ArrayList<>();
    
    public Professor(int codigo, String nome) {
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
        return "Professor [codigo=" + codigo + ", nome=" + nome + "]";
    }

    public void adicionarAluno(Aluno novo){   
        alunos.add(novo);
    }

    public void mostrarAlunos(){
        System.out.println(alunos);
    }
}
