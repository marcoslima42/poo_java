package poov.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import poov.modelo.Doador;
import poov.modelo.RH;
import poov.modelo.Situacao;
import poov.modelo.TipoSanguineo;

public class DoadorDAO {

    public Boolean gravar(Doador doador) {
        Connection connection = ConexaoFactory.getConexao();
        if (connection != null) {
            try {
                String sql = "insert into doador (nome,cpf,contato,tipo_e_rh_corretos,rh,tipo_sanguineo,situacao) values(?,?,?,?,?,?,?)";
                PreparedStatement preparedStatement = connection.prepareStatement(sql,
                        PreparedStatement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, doador.getNome());
                preparedStatement.setString(2, doador.getCpf());
                preparedStatement.setString(3, doador.getContato());
                preparedStatement.setBoolean(4, doador.getTipoERhCorretos());
                preparedStatement.setString(5, doador.getRh().toString());
                preparedStatement.setString(6, doador.getTipoSanguineo().toString());
                preparedStatement.setString(7, doador.getSituacao().toString());
                int gravado = preparedStatement.executeUpdate();
                if (gravado == 1) {
                    System.out.println("Usuario(a) criado com sucesso");
                    ResultSet rs = preparedStatement.getGeneratedKeys();
                    if (rs.next()) {
                        doador.setCodigo(rs.getLong(1));
                    } else {
                        System.err.println("Erro para gerar a chave");
                    }
                    rs.close();
                } else {
                    System.err.println("Erro para criar o usuario(a)");
                }
                preparedStatement.close();
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
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException ex) {
                        System.err.println("Erro fechando a conexão com o banco de dados.\n");
                    }
                }
            }
        }
        return true;
    }
/*
    public Boolean remover(Long codigo) {
        Connection connection = ConexaoFactory.getConexao();
        if (connection != null) {
            try {
                // Aqui mantivemos o delete físico, mas se quiser exclusão lógica, mudaria para UPDATE
                String sql = "delete from doador where codigo = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setLong(1, codigo);
                int remocao = preparedStatement.executeUpdate();
                if (remocao == 1) {
                    System.out.println("Doador apagado");
                } else {
                    System.err.println("Erro na operação");
                }
                preparedStatement.close();
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
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException ex) {
                        System.out.println("Erro fechando a conexão com o banco de dados.\n");
                    }
                }
            }
        }
        return false;
    }
*/
    public boolean atualizar(Doador doador) {
        Connection connection = ConexaoFactory.getConexao();
        if (connection != null) {
            try {
                String sql = "update doador set nome = ?, contato = ?,tipo_e_rh_corretos = ?,rh = ?, tipo_sanguineo = ?, situacao = ? where codigo = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, doador.getNome());
                //preparedStatement.setString(2, doador.getCpf());
                preparedStatement.setString(2, doador.getContato());
                preparedStatement.setBoolean(3, doador.getTipoERhCorretos());
                preparedStatement.setString(4, doador.getRh().toString());
                preparedStatement.setString(5, doador.getTipoSanguineo().toString());
                preparedStatement.setString(6, doador.getSituacao().toString());
                preparedStatement.setLong(7, doador.getCodigo());
                int alterado = preparedStatement.executeUpdate();
                preparedStatement.close();
                if (alterado == 1) {
                    return true;
                }
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
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException ex) {
                        System.out.println("Erro fechando a conexão com o banco de dados.\n");
                    }
                }
            }
        }
        return false;
    }

    public List<Doador> buscarTodos() {
        Connection connection = ConexaoFactory.getConexao();
        List<Doador> lista = new ArrayList<>();
        if (connection != null) {
            // Adicionado WHERE situacao = 'ATIVO'
            String sql = "select * from doador where situacao = 'ATIVO' order by codigo asc";
            try {
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery(sql);

                while (rs.next()) {
                    lista.add(new Doador(rs.getLong("codigo"), rs.getString("nome"), rs.getString("cpf"),
                            rs.getString("contato"), rs.getBoolean("tipo_e_rh_corretos"), Situacao.valueOf(rs.getString("situacao")),
                            TipoSanguineo.valueOf(rs.getString("tipo_sanguineo")), RH.valueOf(rs.getString("rh"))));
                }
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
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException ex) {
                        System.out.println("Erro fechando a conexão com o banco de dados.\n");
                    }
                }
            }
        }
        return lista;
    }

    public List<Doador> buscarCPF(String cpf) {
        Connection connection = ConexaoFactory.getConexao();
        List<Doador> lista = new ArrayList<>();
        if (connection != null) {
            try {
                // Adicionado AND situacao = 'ATIVO'
                String sql = "select * from doador where cpf like ? AND situacao = 'ATIVO' order by codigo asc";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, "%" + cpf + "%");
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    lista.add(new Doador(
                            rs.getLong("codigo"), 
                            rs.getString("nome"), 
                            rs.getString("cpf"),
                            rs.getString("contato"), 
                            rs.getBoolean("tipo_e_rh_corretos"), 
                            Situacao.valueOf(rs.getString("situacao")),
                            TipoSanguineo.valueOf(rs.getString("tipo_sanguineo")), 
                            RH.valueOf(rs.getString("rh"))
                    ));
                }
                if (lista.isEmpty()) {
                    System.err.println("Doador não encontrado");
                }
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
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException ex) {
                        System.out.println("Erro fechando a conexão com o banco de dados.\n");
                    }
                }
            }
        }
        return lista;
    }

    public Doador buscarCodigo(Long codigo) {
        Connection connection = ConexaoFactory.getConexao();
        Doador doador = null;
        if (connection != null) {
            // Adicionado AND situacao = 'ATIVO'
            String sql = "select * from doador where codigo = ? AND situacao = 'ATIVO' order by codigo asc";
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setLong(1, codigo);
                ResultSet rs = preparedStatement.executeQuery();
                if (rs.next()) {
                    doador = (new Doador(rs.getLong("codigo"), rs.getString("nome"), rs.getString("cpf"),
                            rs.getString("contato"), rs.getBoolean("tipo_e_rh_corretos"), Situacao.valueOf(rs.getString("situacao")),
                            TipoSanguineo.valueOf(rs.getString("tipo_sanguineo")), RH.valueOf(rs.getString("rh"))));
                } else {
                    System.err.println("Doador não encontrado");
                }
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
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException ex) {
                        System.out.println("Erro fechando a conexão com o banco de dados.\n");
                    }
                }
            }
        }
        return doador;
    }

    public List<Doador> buscarNome(String nome) {
        Connection connection = ConexaoFactory.getConexao();
        List<Doador> lista = new ArrayList<>();
        if (connection != null) {
            try {
                // Adicionado AND situacao = 'ATIVO'
                String sql = "select * from doador where nome ilike ? AND situacao = 'ATIVO' order by codigo asc";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, "%" + nome + "%");
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    lista.add(new Doador(rs.getLong("codigo"), rs.getString("nome"), rs.getString("cpf"),
                            rs.getString("contato"), rs.getBoolean("tipo_e_rh_corretos"), Situacao.valueOf(rs.getString("situacao")),
                            TipoSanguineo.valueOf(rs.getString("tipo_sanguineo")), RH.valueOf(rs.getString("rh"))));
                }
                if (lista.isEmpty()) {
                    System.err.println("Doador(es) não encontrado(s)");
                }
                rs.close();
                preparedStatement.close();
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
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException ex) {
                        System.out.println("Erro fechando a conexão com o banco de dados.\n");
                    }
                }
            }
        }
        return lista;
    }

    public Boolean desativar(Long codigo) {
        Connection connection = ConexaoFactory.getConexao();
        if (connection != null) {
            try {
                String sql = "update doador set situacao = ? where codigo = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, Situacao.INATIVO.toString());
                preparedStatement.setLong(2, codigo);
                int alterado = preparedStatement.executeUpdate();
                preparedStatement.close();
                if (alterado == 1) {
                    System.out.println("Doador desativado");
                    return true;
                } else {
                    System.err.println("Erro ao desativar");
                }
            } catch (SQLException ex) {
                
            } finally {
            
            }
        }
        return false;
    }
}