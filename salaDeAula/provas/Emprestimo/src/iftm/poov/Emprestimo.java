package iftm.poov;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Emprestimo {
    private String item;
    private String nomePessoa;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private boolean devolvido;
    
    //construtor
    
    public Emprestimo(String item, String nomePessoa, LocalDate dataEmprestimo) {
        this.item = item;
        this.nomePessoa = nomePessoa;
        this.dataEmprestimo = dataEmprestimo;
    }

    //getters e Setters

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public boolean isDevolvido() {
        return devolvido;
    }

    public void setDevolvido(boolean devolvido) {
        this.devolvido = devolvido;
    }


    //metodos

    public void finalizar(LocalDate dataDevolucao){
        this.devolvido = true;
        this.dataDevolucao = dataDevolucao;
    }
    //.until
    public long diasEmprestado(){
        if(this.dataDevolucao != null)
            return dataEmprestimo.until(LocalDate.now(), ChronoUnit.DAYS);
        else 
            return dataEmprestimo.until(this.dataDevolucao, ChronoUnit.DAYS);
    }

    @Override
    public String toString() {
        return "Emprestimo [item=" + item + ", nomePessoa=" + nomePessoa + ", dataEmprestimo=" + dataEmprestimo
                + ", dataDevolucao=" + dataDevolucao + ", devolvido=" + devolvido + "]";
    }
}
