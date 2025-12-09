package poov.modelo;

public enum RH {
    POSITIVO("Positivo"),
    NEGATIVO("Negativo"),
    DESCONHECIDO("Descinhecido");

    private String descricao;
    
    private RH(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao(){
        return descricao;
    }
}
