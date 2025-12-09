package poov.dao;

import java.sql.Connection;
import java.sql.SQLException;

public class DAOFactory {
    
    private Connection conexao = null;
    
    public DoacaoDAO criarDoacaoDAO(){
        if(conexao == null){
            throw new IllegalStateException("Abra uma conexão antes de criar um DAO.");
        } else {
            return new DoacaoDAO(conexao);
        }
    }

    public DoadorDAO criarDoadorDAO(){
        if(conexao == null){
            throw new IllegalStateException("Abra uma conexão antes de criar um DAO.");
        } else {
            return new DoadorDAO(conexao);
        }
    }
}
