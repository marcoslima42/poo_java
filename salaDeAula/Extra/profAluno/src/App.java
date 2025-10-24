import java.io.IOException;
import java.util.ArrayList;

// PRECISA DESTE IMPORT ADICIONAL
import com.googlecode.lanterna.TerminalPosition; 

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

public class App {

    // Nossas listas de "banco de dados"
    static ArrayList<Aluno> alunos = new ArrayList<>();
    static ArrayList<Professor> professores = new ArrayList<>();

    // Definicao de cores
    static final TextColor COR_FUNDO = TextColor.ANSI.BLUE;
    static final TextColor COR_TEXTO = TextColor.ANSI.WHITE_BRIGHT; // Branco brilhante
    static final TextColor COR_TITULO = TextColor.ANSI.YELLOW_BRIGHT; // Amarelo brilhante
    static final TextColor COR_INPUT = TextColor.ANSI.BLACK;
    static final TextColor COR_FUNDO_INPUT = TextColor.ANSI.WHITE;

    public static void main(String[] args) throws IOException {

        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory();
        Terminal terminal = null;
        Screen screen = null;

        try {
            terminal = terminalFactory.createTerminal();
            screen = new TerminalScreen(terminal);
            screen.startScreen();
            
            // Loop principal do menu
            boolean rodando = true;
            while (rodando) {
                // Prepara a tela para o menu
                screen.clear();
                TextGraphics textGraphics = screen.newTextGraphics();
                desenharLayoutBase(screen, textGraphics, "MENU PRINCIPAL");

                // Desenha as opcoes do menu
                desenharMenu(textGraphics);
                screen.refresh();

                // Espera o usuario digitar uma opcao
                KeyStroke keyStroke = screen.readInput();
                
                // Processa a opcao
                if (keyStroke.getKeyType() == KeyType.Character) {
                    switch (keyStroke.getCharacter()) {
                        case '1':
                            handleCadastroAluno(screen);
                            break;
                        case '2':
                            handleCadastroProfessor(screen);
                            break;
                        case '3':
                            handleListarAlunos(screen);
                            break;
                        case '4':
                            handleListarProfessores(screen);
                            break;
                        case '5':
                            rodando = false;
                            break;
                        default:
                            mostrarMensagem(screen, "Opcao invalida!");
                            break;
                    }
                }
            }
        } finally {
            if (screen != null) {
                screen.stopScreen();
            }
        }
    }

    /**
     * Desenha o layout base (fundo azul, titulo, caixa)
     */
    public static void desenharLayoutBase(Screen screen, TextGraphics g, String titulo) {
        TerminalSize terminalSize = screen.getTerminalSize();
        
        // Define o fundo azul e texto branco para a tela inteira
        g.setBackgroundColor(COR_FUNDO);
        g.setForegroundColor(COR_TEXTO);

        // A ordem correta e (POSICAO, TAMANHO, CARACTERE)
        g.fillRectangle(new TerminalPosition(0, 0), terminalSize, ' '); 

        // Desenha a "caixa" principal
        int colunas = terminalSize.getColumns();
        int linhas = terminalSize.getRows();
        
        // Linhas horizontais
        g.setCharacter(1, 1, '┌');
        g.setCharacter(colunas - 2, 1, '┐');
        g.setCharacter(1, linhas - 2, '└');
        g.setCharacter(colunas - 2, linhas - 2, '┘');
        g.drawLine(2, 1, colunas - 3, 1, '─');
        g.drawLine(2, linhas - 2, colunas - 3, linhas - 2, '─');

        // Linhas verticais
        g.drawLine(1, 2, 1, linhas - 3, '│');
        g.drawLine(colunas - 2, 2, colunas - 2, linhas - 3, '│');

        // Titulo da pagina
        g.setForegroundColor(COR_TITULO);
        int colunaTitulo = (colunas - titulo.length()) / 2;
        g.putString(colunaTitulo, 1, " " + titulo + " ");
        g.setForegroundColor(COR_TEXTO); // Reseta a cor padrao
    }

    /**
     * Desenha o menu principal na tela
     */
    public static void desenharMenu(TextGraphics g) {
        g.putString(5, 5, "1. Cadastrar Aluno");
        g.putString(5, 6, "2. Cadastrar Professor");
        g.putString(5, 7, "3. Listar Alunos");
        g.putString(5, 8, "4. Listar Professores");
        g.putString(5, 10, "5. Sair");
        g.putString(5, 12, "Escolha uma opcao: ");
    }

    /**
     * Logica para a opcao 1: Cadastrar Aluno
     */
    public static void handleCadastroAluno(Screen screen) throws IOException {
        TextGraphics g = screen.newTextGraphics();
        screen.clear();
        desenharLayoutBase(screen, g, "CADASTRO DE ALUNO");

        try {
            // Pede o codigo
            String codigoStr = lerString(screen, g, "Digite o codigo: ", 7);
            int codigo = Integer.parseInt(codigoStr);

            // Pede o nome
            String nome = lerString(screen, g, "Digite o nome: ", 9);

            // Chama a funcao que voce ja tinha
            cadastrarAluno(codigo, nome, alunos);

            mostrarMensagem(screen, "Aluno cadastrado com sucesso!");

        } catch (NumberFormatException e) {
            mostrarMensagem(screen, "Erro: O codigo deve ser um numero!");
        }
    }

    /**
     * Logica para a opcao 2: Cadastrar Professor
     */
    public static void handleCadastroProfessor(Screen screen) throws IOException {
        TextGraphics g = screen.newTextGraphics();
        screen.clear();
        desenharLayoutBase(screen, g, "CADASTRO DE PROFESSOR");
        
        try {
            // Pede o codigo
            String codigoStr = lerString(screen, g, "Digite o codigo: ", 7);
            int codigo = Integer.parseInt(codigoStr);

            // Pede o nome
            String nome = lerString(screen, g, "Digite o nome: ", 9);

            // Chama a funcao que voce ja tinha
            cadastrarProfessor(codigo, nome, professores);

            mostrarMensagem(screen, "Professor cadastrado com sucesso!");

        } catch (NumberFormatException e) {
            mostrarMensagem(screen, "Erro: O codigo deve ser um numero!");
        }
    }

    /**
     * Logica para a opcao 3: Listar Alunos
     */
    public static void handleListarAlunos(Screen screen) throws IOException {
        TextGraphics g = screen.newTextGraphics();
        screen.clear();
        desenharLayoutBase(screen, g, "LISTA DE ALUNOS");

        int linhaAtual = 5;
        for (Aluno aluno : alunos) {
            // Usa o toString() do seu objeto Aluno
            g.putString(5, linhaAtual, aluno.toString()); 
            linhaAtual++;
        }
        if (alunos.isEmpty()) {
            g.putString(5, 5, "Nenhum aluno cadastrado.");
        }
        mostrarMensagem(screen, ""); // Apenas espera o usuario
    }

    /**
     * Logica para a opcao 4: Listar Professores
     */
    public static void handleListarProfessores(Screen screen) throws IOException {
        TextGraphics g = screen.newTextGraphics();
        screen.clear();
        desenharLayoutBase(screen, g, "LISTA DE PROFESSORES");

        int linhaAtual = 5;
        for (Professor prof : professores) {
            // Usa o toString() do seu objeto Professor
            g.putString(5, linhaAtual, prof.toString());
            linhaAtual++;
        }
        if (professores.isEmpty()) {
            g.putString(5, 5, "Nenhum professor cadastrado.");
        }
        mostrarMensagem(screen, ""); // Apenas espera o usuario
    }


    // --- FUNCOES DE UTILIDADE ---

    /**
     * Mostra uma mensagem na tela e espera o usuario pressionar qualquer tecla.
     */
    public static void mostrarMensagem(Screen screen, String mensagem) throws IOException {
        TextGraphics g = screen.newTextGraphics();
        TerminalSize terminalSize = screen.getTerminalSize();

        // Define o fundo azul e texto branco para a mensagem
        g.setBackgroundColor(COR_FUNDO);
        g.setForegroundColor(COR_TEXTO);
        
        String msgFinal = mensagem + " (Pressione qualquer tecla para continuar...)";
        int colunaMsg = (terminalSize.getColumns() - msgFinal.length()) / 2;
        
        g.putString(colunaMsg, terminalSize.getRows() - 3, msgFinal);
        screen.refresh();
        screen.readInput();
    }

    /**
     * Le uma string do usuario, caractere por caractere, com um visual melhorado.
     */
    public static String lerString(Screen screen, TextGraphics g, String prompt, int linha) throws IOException {
        StringBuilder sb = new StringBuilder();
        int colunaPrompt = 5;
        int colunaInput = colunaPrompt + prompt.length() + 1; // Coluna onde o texto comeca

        g.setBackgroundColor(COR_FUNDO);
        g.setForegroundColor(COR_TEXTO);
        g.putString(colunaPrompt, linha, prompt);
        
        // Prepara a area de input
        g.setBackgroundColor(COR_FUNDO_INPUT);
        g.setForegroundColor(COR_INPUT);
        g.putString(colunaInput, linha, " ".repeat(40)); // Desenha o fundo branco
        screen.refresh();

        while (true) {
            // A funcao espera um objeto TerminalPosition
            screen.setCursorPosition(new TerminalPosition(colunaInput + sb.length(), linha));
            
            KeyStroke keyStroke = screen.readInput();
            if (keyStroke.getKeyType() == KeyType.Enter) {
                break; // Termina ao pressionar Enter
            }
            if (keyStroke.getKeyType() == KeyType.Backspace) {
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            } else if (keyStroke.getKeyType() == KeyType.Character) {
                if (sb.length() < 39) { // Limita o tamanho do input
                    sb.append(keyStroke.getCharacter());
                }
            }

            // Redesenha a area de input
            g.setBackgroundColor(COR_FUNDO_INPUT);
            g.setForegroundColor(COR_INPUT);
            g.putString(colunaInput, linha, " ".repeat(40)); // Limpa a area
            g.putString(colunaInput, linha, sb.toString());
            screen.refresh();
        }
        
        // Reseta as cores padrao
        g.setBackgroundColor(COR_FUNDO);
        g.setForegroundColor(COR_TEXTO);
        return sb.toString();
    }

    public static void cadastrarProfessor(int codigo, String nome, ArrayList<Professor> professores) {
        Professor novo = new Professor(codigo, nome);
        professores.add(novo);
    }

    public static void cadastrarAluno(int codigo, String nome, ArrayList<Aluno> alunos) {
        Aluno novo = new Aluno(codigo, nome);
        alunos.add(novo);
    }

    public static Professor buscarProfessor(int codigo, ArrayList<Professor> professores) {
        for (Professor elem : professores) {
            if (elem.getCodigo() == codigo) {
                return elem;
            }
        }
        return null;
    }

    public static Aluno buscarAluno(int codigo, ArrayList<Aluno> alunos) {
        for (Aluno elem : alunos) {
            if (elem.getCodigo() == codigo) {
                return elem;
            }
        }
        return null;
    }
}