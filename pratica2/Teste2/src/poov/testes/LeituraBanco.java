package poov.testes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import poov.modelo.Vacina;

public class LeituraBanco {
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
        try {
            System.out.println("Conectando com o banco de dados.");
            Class.forName(classeDriver);
            conexao = DriverManager.getConnection(url, login, senha);
            System.out.println("Conexão com o banco de dados estabelecida.");

    //   b) obtenha o codigo da Vacina procurada via teclado
            System.out.print("Digite o codigo: ");        
            long codigo = Long.parseLong(s.nextLine());

    //   c) crie um objeto PreparedStatement com o código SQL de seleção. Quem cria o objeto é o objeto
    //  conexao criado anteriormente
            String sql = "SELECT * FROM vacina WHERE codigo = ?";
            PreparedStatement pstmt = conexao.prepareStatement(sql);
            
    //   d) use o método setLong do PreparedStatement criado para substituir a interrogação do código SQL 
    // pelo valor desejado, nesse caso o valor do codigo entrado pelo teclado
            pstmt.setLong(1, codigo);

    //   e) execute o PreparedStatement fazendo com que a seleção seja feita e guarde o resultado em um
    //  ResultSet
            ResultSet rs = pstmt.executeQuery();

    //   f) chame o método next( ) do ResultSet para que “o cursor” ande para a próxima linha lida do banco
    //  (nesse caso, a primeira). O next( ) retorna true se isso foi possível e false caso contrário
            if (rs.next()) {
                //   g) se você recebeu dados do banco mostre na tela os valores obtidos no ResultSet
                //  usando os métodos getLong( ) e getString( ), caso contrário avise o usuário que a
                //  vacina não foi encontrada
                Vacina vacina = new Vacina(rs.getLong(1), rs.getString(2), rs.getString(3));
                System.out.println(vacina);
            } else {
                System.out.println("Nao foi encontrada uma vacina com o codigo " + codigo);
            }
    //   h) feche os objetos utilizados
            rs.close();
            pstmt.close();

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
