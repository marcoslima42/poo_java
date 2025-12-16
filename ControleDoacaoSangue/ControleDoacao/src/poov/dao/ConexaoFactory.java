package poov.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLDataException;
import java.sql.SQLException;

public class ConexaoFactory {
    private ConexaoFactory(){}

    private static String caminho = "jdbc:postgresql";
    private static String host = "localhost";
    private static String porta = "5432";
    private static String bd = "postgres";
    private static String login = "postgres";
    private static String senha = "12345";
    private static String url = caminho + "://" + host + ":" + porta + "/" + bd;
    private static String classeDriver = "org.postgresql.Driver";

    private static String classeDrive = "org.postgresql.Driver";
    private static Connection conexao = null;

    public static Connection getConexao() {

        try{
            //System.out.println("Conectando com o banco de dados...");
            Class.forName(classeDriver);
            conexao = DriverManager.getConnection(url, login, senha);
            //System.out.println("Conexão com o banco de dados estabelecida.");
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro ao carregar o driver JDBC.");
        } catch (SQLException ex){
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
        }

        return conexao;
    }
}
