public class Cliente {
    private long codigo;
    private String nome;
    private String contato;
    
    public Cliente(long codigo, String nome, String contato) {
        this.codigo = codigo;
        this.nome = nome;
        this.contato = contato;
    }
    
    public long getCodigo() {
        return codigo;
    }
    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getContato() {
        return contato;
    }
    public void setContato(String contato) {
        this.contato = contato;
    }

    @Override
    public String toString() {
        return "Cliente [codigo=" + codigo + ", nome=" + nome + ", contato=" + contato + "]";
        
    }
}
