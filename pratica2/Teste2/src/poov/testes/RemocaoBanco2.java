package poov.testes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import poov.modelo.Vacina;

public class RemocaoBanco2 {
    public static void main(String[] args) {
        String caminho = "jdbc:postgresql";
        String host = "localhost";
        String porta = "5432";
        String bd = "poov";
        String login = "postgres";
        String senha = "12345";
        String url = caminho + "://" + host + ":" + porta + "/" + bd;
        String classeDriver = "org.postgresql.Driver";
        Connection conexao = null;
        //   a) crie um objeto Scanner para ler valores do teclado
        Scanner s = new Scanner(System.in);
        Vacina vacina;

        try {
            System.out.println("Conectando com o banco de dados.");
            Class.forName(classeDriver);
            conexao = DriverManager.getConnection(url, login, senha);
            System.out.println("Conexão com o banco de dados estabelecida.");

    //   b) obtenha o codigo do Vacina a ser removida via teclado
            long codigo;
            System.out.print("Digite o codigo: ");
            codigo = Long.parseLong(s.nextLine());

    //   c) crie um objeto PreparedStatement com o código SQL de seleção. Quem cria o objeto é o objeto
    //  conexao criado anteriormente
            String sql = "SELECT * FROM vacina WHERE codigo = ?";
            PreparedStatement pstmt = conexao.prepareStatement(sql);

    //   d) use o método setLong do PreparedStatement criado para substituir a interrogação do código SQL
    //  pelo valor desejado, nesse caso o valor do codigo entrado pelo teclado
            pstmt.setLong(1, codigo);

    //   e) execute o PreparedStatement fazendo com que a seleção seja feita e guarde o resultado em um
    //   ResultSet
            ResultSet rs = pstmt.executeQuery();

    //   f) chame o método next( ) do ResultSet para que “o cursor” ande para a próxima linha lida do banco
    //  (nesse caso, a primeira). O next( ) retorna true se isso foi possível e false caso contrário
    //   g) se foi possível executar o next( ) é porque a Vacina com esse codigo existe
            if (rs.next()) {
                // h) mostre na tela os valores obtidos no ResultSet usando os métodos getLong( ) e getString( )
                vacina = new Vacina(rs.getLong(1), rs.getString(2), rs.getString(3));
                rs.close();
                pstmt.close();

                // i) pergunte ao usuário se ele realmente deseja remover essa vacina
                System.out.println(vacina);
                System.out.print("Você tem certeza que quer remover essa vacina? (1 - sim, 2 - nao): ");
                int opcao = Integer.parseInt(s.nextLine());
                if (opcao == 1) {
                    // 	j) se sim, crie um objeto PreparedStatement com o código SQL para a alteração da 
                    // situação da vacina para 'INATIVO'
                    String sqlAlteracao = "UPDATE vacina SET situacao = 'INATIVO' WHERE codigo = ?";
                    pstmt = conexao.prepareStatement(sqlAlteracao);

                    // k) use o método setLong do PreparedStatement criado para substituir a interrogação
                    //  do código SQL pelo valor desejado, nesse caso o valor do codigo entrado pelo teclado
                    pstmt.setLong(1, codigo);
                    // l) execute o PreparedStatement fazendo com que a alteracao seja feita e guarde o 
                    // resultado em um int
                    int quantos = pstmt.executeUpdate();
                    // m) teste se o retorno da alteracao foi igual a 1 (o número de linhas alteradas nesse caso)
                    //  e avise o usuário do resultado da alteracao
                    if (quantos == 1) {
                        System.out.println("Vacina \"removida\" com sucesso");
                    }
                    // n) feche os objetos usados
                    pstmt.close();
                }
            } else {
                System.out.println("Nao foi encontrada uma vacina com o codigo " + codigo);
            }

        } catch (ClassNotFoundException ex) {
            System.out.println("Erro ao carregar o driver JDBC.");
        } catch (SQLException ex) {
            System.out.println("Erro no acesso ao banco de dados.");
            SQLException e = ex;
            while (e != null) {
                System.out.println("SQL State: " + e.getSQLState());
                System.out.println("Error Code: " + e.getErrorCode());
                System.out.println("Mensagem: " + e.getMessage());
                Throwable t = e.getCause();
                while (t != null) {
                    System.out.println("Causa: " + t);
                    t = t.getCause();
                }
                e = e.getNextException();
            }
        } finally {
            if (conexao != null) {
                System.out.println("Terminando a conexão com o banco de dados.");
                try {
                    conexao.close();
                } catch (SQLException ex) {
                    System.out.println("Erro fechando a conexão com o banco de dados.");
                }
                System.out.println("Conexão com o banco de dados terminada.");
            }
        }
        s.close();
    }
}
