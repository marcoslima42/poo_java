package iftm.poov;

public class Pessoa {
    private String nome;
    private String cpf;
    private String endereco;
    private String contato;

    public Pessoa(){
        nome = "Marcos Lima";
        cpf = "45678";
        endereco = "Rua desdemona de stefani 51";
        contato = "34 992271090";
    }

    public Pessoa(String nome, String cpf, String endereco, String contato){
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.contato = contato;
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
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getContato() {
        return contato;
    }
    public void setContato(String contato) {
        this.contato = contato;
    }
    
    public void mostrar(){
        System.out.println("Nome: " + getNome());
        System.out.println("CPF: " + getCpf());
        System.out.println("Endereço: " + getEndereco());
        System.out.println("Contato: " + getContato());
    }
}
