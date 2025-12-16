package poov.modelo;

public class Doador {
    private Long codigo;
    private String nome;
    private String cpf;
    private String contato;
    private Boolean tipoERhCorretos;
    private Situacao situacao;
    private TipoSanguineo tipoSanguineo;
    private RH rh;

    public Doador(Long codigo, String nome, String cpf, String contato, Boolean tipoERhCorretos, Situacao situacao,
            TipoSanguineo tipoSanguineo, RH rh) {
        this.codigo = codigo;
        this.nome = nome;
        this.cpf = cpf;
        this.contato = contato;
        this.tipoERhCorretos = tipoERhCorretos;
        this.situacao = situacao;
        this.tipoSanguineo = tipoSanguineo;
        this.rh = rh;
    }
    
    public Doador(){

    }
    public Long getCodigo() {
        return codigo;
    }
    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getContato() {
        return contato;
    }
    public void setContato(String contato) {
        this.contato = contato;
    }
    public Boolean getTipoERhCorretos() {
        return tipoERhCorretos;
    }
    public void setTipoERhCorretos(Boolean tipoERhCorretos) {
        this.tipoERhCorretos = tipoERhCorretos;
    }
    public Situacao getSituacao() {
        return situacao;
    }
    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }
    public TipoSanguineo getTipoSanguineo() {
        return tipoSanguineo;
    }
    public void setTipoSanguineo(TipoSanguineo tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }
    public RH getRh() {
        return rh;
    }
    public void setRh(RH rh) {
        this.rh = rh;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
        result = prime * result + ((contato == null) ? 0 : contato.hashCode());
        result = prime * result + ((tipoERhCorretos == null) ? 0 : tipoERhCorretos.hashCode());
        result = prime * result + ((situacao == null) ? 0 : situacao.hashCode());
        result = prime * result + ((tipoSanguineo == null) ? 0 : tipoSanguineo.hashCode());
        result = prime * result + ((rh == null) ? 0 : rh.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Doador other = (Doador) obj;
        if (codigo == null) {
            if (other.codigo != null)
                return false;
        } else if (!codigo.equals(other.codigo))
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (cpf == null) {
            if (other.cpf != null)
                return false;
        } else if (!cpf.equals(other.cpf))
            return false;
        if (contato == null) {
            if (other.contato != null)
                return false;
        } else if (!contato.equals(other.contato))
            return false;
        if (tipoERhCorretos == null) {
            if (other.tipoERhCorretos != null)
                return false;
        } else if (!tipoERhCorretos.equals(other.tipoERhCorretos))
            return false;
        if (situacao != other.situacao)
            return false;
        if (tipoSanguineo != other.tipoSanguineo)
            return false;
        if (rh != other.rh)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Doador [codigo=" + codigo + ", nome=" + nome + ", cpf=" + cpf + ", contato=" + contato
                + ", tipoERhCorretos=" + tipoERhCorretos + ", situacao=" + situacao + ", tipoSanguineo=" + tipoSanguineo
                + ", rh=" + rh + "]";
    }
}
