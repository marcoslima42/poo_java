package poov.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.time.LocalDate;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import poov.modelo.Doacao;
import poov.modelo.Doador;
import poov.modelo.Situacao;

public class DoacaoDAO {
    


        public Boolean gravar(Doacao doacao) {
        Connection connection = ConexaoFactory.getConexao();
        if (connection != null) {
            try {
                String sql = "insert into doacao (doador_id,data,hora,volume,situacao) values (?,?,?,?,?)";
                PreparedStatement preparedStatement = connection.prepareStatement(sql,
                        PreparedStatement.RETURN_GENERATED_KEYS);
                preparedStatement.setLong(1, doacao.getDoador().getCodigo());
                preparedStatement.setDate(2, java.sql.Date.valueOf(doacao.getData()));
                preparedStatement.setTime(3, java.sql.Time.valueOf(doacao.getHora()));
                preparedStatement.setDouble(4, doacao.getVolume());
                preparedStatement.setString(5, doacao.getDoador().getSituacao().toString());
                int gravado = preparedStatement.executeUpdate();
                if (gravado == 1) {
                    System.out.println("Dado criado");
                    ResultSet rs = preparedStatement.getGeneratedKeys();
                    if (rs.next()) {
                        doacao.setCodigo(rs.getLong(1));
                    } else {
                        System.err.println("Erro ao gerar a chave");
                    }
                } else {
                    System.err.println("Erro ao salvar");
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
                    //System.out.println("Terminando a conexão com o banco de dados.");
                    try {
                        connection.close();
                    } catch (SQLException ex) {
                        System.err.println("Erro fechando a conexão com o banco de dados.\n");
                    }
                    //System.out.println("Conexão com o banco de dados terminada.\n");
                }
            }
        }
        return true;
    }

/*
        public void remover(Long codigo) {
        Connection connection = ConexaoFactory.getConexao();
        if (connection != null) {
            try {
                String sql = "delete from doacao where codigo = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setLong(1, codigo);
                int remocao = preparedStatement.executeUpdate();
                if (remocao == 1) {
                    System.out.println("Doação apagado");
                } else {
                    System.err.println("Erro ao apagar o dado");
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
                    //System.out.println("Terminando a conexão com o banco de dados.");
                    try {
                        connection.close();
                    } catch (SQLException ex) {
                        System.out.println("Erro fechando a conexão com o banco de dados.\n");
                    }
                    //System.out.println("Conexão com o banco de dados terminada.\n");
                }
            }
        }
    }
*/

        public List<Doacao> buscarTodos() {
        Connection connection = ConexaoFactory.getConexao();
        List<Doacao> lista = new ArrayList<>();
        if (connection != null) {
            try {
                String sql = "select * from doacao order by codigo asc";
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery(sql);
                while (rs.next()) {
                    lista.add(new Doacao(rs.getLong("codigo"), rs.getDate("data").toLocalDate(),
                            rs.getTime("hora").toLocalTime(),
                            rs.getDouble("volume"), Situacao.valueOf(rs.getString("situacao")), new DoadorDAO().buscarCodigo(rs.getLong("doador_id"))));
                }
                if (lista.isEmpty()) {
                    System.err.println("Dado não encontrado");
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
                    //System.out.println("Terminando a conexão com o banco de dados.");
                    try {
                        connection.close();
                    } catch (SQLException ex) {
                        System.out.println("Erro fechando a conexão com o banco de dados.\n");
                    }
                    //System.out.println("Conexão com o banco de dados terminada.\n");
                }
            }
        }
        return lista;
    }

public List<Doacao> buscarNome(String nome) {
        Connection connection = ConexaoFactory.getConexao();
        List<Doacao> lista = new ArrayList<>();
        if (connection != null) {
            try {
                String sql = "select d.* from doacao d inner join doador doa on d.doador_id = doa.codigo where doa.nome ilike ? order by d.codigo asc";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, "%" + nome + "%");
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    lista.add(new Doacao(rs.getLong("codigo"), rs.getDate("data").toLocalDate(),
                            rs.getTime("hora").toLocalTime(),
                            rs.getDouble("volume"), Situacao.valueOf(rs.getString("situacao")), new DoadorDAO().buscarCodigo(rs.getLong("doador_id"))));
                }
                if (lista.isEmpty()) {
                    System.err.println("Doacao não encontrada");
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
                    //System.out.println("Terminando a conexão com o banco de dados.");
                    try {
                        connection.close();
                    } catch (SQLException ex) {
                        System.out.println("Erro fechando a conexão com o banco de dados.\n");
                    }
                    //System.out.println("Conexão com o banco de dados terminada.\n");
                }
            }
        }
        return lista;
    }

    public List<Doacao> buscarCodDoador(Long codigo) {
        Connection connection = ConexaoFactory.getConexao();
        ArrayList<Doacao> list = new ArrayList<>();
        if (connection != null) {
            try {
                String sql = "select * from doacao where doador_id = ? order by codigo asc";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setLong(1, codigo);
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                        list.add(new Doacao(rs.getLong("codigo"), rs.getDate("data").toLocalDate(),
                            rs.getTime("hora").toLocalTime(),
                            rs.getDouble("volume"), Situacao.valueOf(rs.getString("situacao")), new DoadorDAO().buscarCodigo(rs.getLong("doador_id"))));
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
                    //System.out.println("Terminando a conexão com o banco de dados.");
                    try {
                        connection.close();
                    } catch (SQLException ex) {
                        System.out.println("Erro fechando a conexão com o banco de dados.\n");
                    }
                    //System.out.println("Conexão com o banco de dados terminada.\n");
                }
            }
        }
        return list;
    }

public List<Doacao> buscarCPF(String cpf) {
        Connection connection = ConexaoFactory.getConexao();
        List<Doacao> lista = new ArrayList<>();
        if (connection != null) {
            try {
                String sql = "select d.* from doacao d inner join doador doad on d.doador_id = doad.codigo where doad.cpf like ? order by d.codigo asc";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, "%" + cpf + "%");
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    lista.add(new Doacao(rs.getLong("codigo"), rs.getDate("data").toLocalDate(),
                            rs.getTime("hora").toLocalTime(),
                            rs.getDouble("volume"), Situacao.valueOf(rs.getString("situacao")), new DoadorDAO().buscarCodigo(rs.getLong("doador_id"))));
                }
                if (lista.isEmpty()) {
                    System.err.println("Doacao não encontrada");
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
                    //System.out.println("Terminando a conexão com o banco de dados.");
                    try {
                        connection.close();
                    } catch (SQLException ex) {
                        System.out.println("Erro fechando a conexão com o banco de dados.\n");
                    }
                    //System.out.println("Conexão com o banco de dados terminada.\n");
                }
            }
        }
        return lista;
    }

    public Doacao buscarCodigo(Long codigo) {
        Connection connection = ConexaoFactory.getConexao();
        Doacao doacao = null;
        if (connection != null) {
            try {
                String sql = "select * from doacao where codigo = ? order by codigo asc";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setLong(1, codigo);
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    doacao = new Doacao(rs.getLong("codigo"), rs.getDate("data").toLocalDate(),
                            rs.getTime("hora").toLocalTime(),
                            rs.getDouble("volume"), Situacao.valueOf(rs.getString("situacao")), new DoadorDAO().buscarCodigo(rs.getLong("doador_id")));
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
                    //System.out.println("Terminando a conexão com o banco de dados.");
                    try {
                        connection.close();
                    } catch (SQLException ex) {
                        System.out.println("Erro fechando a conexão com o banco de dados.\n");
                    }
                    //System.out.println("Conexão com o banco de dados terminada.\n");
                }
            }
        }
        return doacao;
    }

    public List<Doacao> buscarAntes(LocalDate date) {
        Connection connection = ConexaoFactory.getConexao();
        List<Doacao> lista = new ArrayList<>();
        if (connection != null) {
            String sql = "SELECT * FROM doacao WHERE data < ? order by codigo asc";
            try {
                PreparedStatement pStatement = connection.prepareStatement(sql);
                pStatement.setDate(1, java.sql.Date.valueOf(date));
                ResultSet rs = pStatement.executeQuery();
                while (rs.next()) {
                    lista.add(new Doacao(rs.getLong("codigo"), rs.getDate("data").toLocalDate(),
                            rs.getTime("hora").toLocalTime(),
                            rs.getDouble("volume"), Situacao.valueOf(rs.getString("situacao")), new DoadorDAO().buscarCodigo(rs.getLong("doador_id"))));
                }
                rs.close();
                pStatement.close();
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
                    //System.out.println("Terminando a conexão com o banco de dados.");
                    try {
                        connection.close();
                    } catch (SQLException ex) {
                        System.out.println("Erro fechando a conexão com o banco de dados.\n");
                    }
                    //System.out.println("Conexão com o banco de dados terminada.\n");
                }
            }
        }
        return lista;
    }

    public List<Doacao> buscarEntre(LocalDate data_inicial, LocalDate data_final) {
        Connection connection = ConexaoFactory.getConexao();
        List<Doacao> lista = new ArrayList<>();
        if (connection != null) {
            try {
                String sql = "select * from doacao where data between ? and ? order by codigo asc";
                PreparedStatement pStatement = connection.prepareStatement(sql);
                pStatement.setDate(1, java.sql.Date.valueOf(data_inicial));
                pStatement.setDate(2, java.sql.Date.valueOf(data_final));
                ResultSet rs = pStatement.executeQuery();
                while (rs.next()) {
                    lista.add(new Doacao(rs.getLong("codigo"), rs.getDate("data").toLocalDate(),
                            rs.getTime("hora").toLocalTime(),
                            rs.getDouble("volume"), Situacao.valueOf(rs.getString("situacao")), new DoadorDAO().buscarCodigo(rs.getLong("doador_id"))));
                }
                pStatement.close();
                rs.close();
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
                    //System.out.println("Terminando a conexão com o banco de dados.");
                    try {
                        connection.close();
                    } catch (SQLException ex) {
                        System.out.println("Erro fechando a conexão com o banco de dados.\n");
                    }
                    //System.out.println("Conexão com o banco de dados terminada.\n");
                }
            }
        }
        return lista;
    }

    public List<Doacao> buscarApos(LocalDate data) {
        List<Doacao> lista = new ArrayList<>();
        Connection connection = ConexaoFactory.getConexao();
        if (connection != null) {
            try {
                String sql = "select * from doacao where data > ?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setDate(1, java.sql.Date.valueOf(data));
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    lista.add(new Doacao(rs.getLong("codigo"), rs.getDate("data").toLocalDate(),
                            rs.getTime("hora").toLocalTime(),
                            rs.getDouble("volume"), Situacao.valueOf(rs.getString("situacao")), new DoadorDAO().buscarCodigo(rs.getLong("doador_id"))));
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
                    //System.out.println("Terminando a conexão com o banco de dados.");
                    try {
                        connection.close();
                    } catch (SQLException ex) {
                        System.out.println("Erro fechando a conexão com o banco de dados.\n");
                    }
                    //System.out.println("Conexão com o banco de dados terminada.\n");
                }
            }
        }
        return lista;
    }
}
