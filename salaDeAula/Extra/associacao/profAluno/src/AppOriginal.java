import java.util.ArrayList;

import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import java.io.IOException;

public class AppOriginal {
    public static void main(String[] args) throws Exception {
        
        ArrayList <Aluno> alunos = new ArrayList<>();
        ArrayList <Professor> professores = new ArrayList<>();

        //cadastrar 6 alunos e 2 professores

        cadastrarAluno(1, "Peter Parker", alunos);
        cadastrarAluno(2, "Jessica Jones", alunos);
        cadastrarAluno(3, "Bruce Banner", alunos);
        cadastrarAluno(4, "Kamala Khan", alunos);
        cadastrarAluno(5, "Lois Lane", alunos);
        cadastrarAluno(6, "Matt Murdock", alunos);

        cadastrarProfessor(1, "Reed Richards", professores);
        cadastrarProfessor(2, "Sue Storm", professores);
        cadastrarProfessor(3, "Scott Summers", professores);

        //ligando professores e alunos
        //cada professor tera dois alunos, professor 1, os dois primeiros aluno, assim respectivamente
        professores.get(0).adicionarAluno(buscarAluno(1, alunos));
        alunos.get(0).adicionarProfessor(buscarProfessor(1, professores));
        professores.get(0).adicionarAluno(buscarAluno(2, alunos));
        alunos.get(1).adicionarProfessor(buscarProfessor(1, professores));
        professores.get(1).adicionarAluno(buscarAluno(3, alunos));
        alunos.get(2).adicionarProfessor(buscarProfessor(2, professores));
        professores.get(1).adicionarAluno(buscarAluno(4, alunos));
        alunos.get(3).adicionarProfessor(buscarProfessor(2, professores));
        professores.get(2).adicionarAluno(buscarAluno(5, alunos));
        alunos.get(4).adicionarProfessor(buscarProfessor(3, professores));
        professores.get(2).adicionarAluno(buscarAluno(6, alunos));
        alunos.get(5).adicionarProfessor(buscarProfessor(6, professores));

        System.out.println("Professor 1: ");
        System.out.println(professores.get(0).toString());
        System.out.println("Alunos do professor 1: ");
        professores.get(0).mostrarAlunos();
        System.out.println("================================================================ ");

        System.out.println("Professor 2: ");
        System.out.println(professores.get(1).toString());
        System.out.println("Alunos do professor 2: ");
        professores.get(1).mostrarAlunos();
        System.out.println("================================================================ ");

        System.out.println("Professor 3: ");
        System.out.println(professores.get(2).toString());
        System.out.println("Alunos do professor 3: ");
        professores.get(2).mostrarAlunos();
        System.out.println("================================================================ ");


        System.out.println("Aluno 1: ");
        System.out.println(alunos.get(0).toString());
        System.out.println("Professor do Aluno 1: ");
        alunos.get(0).mostrarProfessores();

    }

    public static void cadastrarProfessor(int codigo, String nome, ArrayList <Professor> professores){
        Professor novo = new Professor(codigo, nome);
        professores.add(novo);
    }       

    public static void cadastrarAluno(int codigo, String nome, ArrayList <Aluno> alunos){
        Aluno novo = new Aluno(codigo, nome);
        alunos.add(novo);
    }
    
    public static Professor buscarProfessor(int codigo, ArrayList<Professor> professores){
        for(Professor elem : professores){
            if(elem.getCodigo() == codigo){
                return elem;
            }
        }
        return null;
    }

    public static Aluno buscarAluno(int codigo, ArrayList<Aluno> alunos){
        for(Aluno elem : alunos){
            if(elem.getCodigo() == codigo){
                return elem;
            }
        }
        return null;
    }

    public static void mostrarProfessores(ArrayList<Professor> professores){
        System.out.println(professores);
    }

    public static void mostrarAlunos(ArrayList<Aluno> alunos){
        System.out.println(alunos);
    }
}
