package iftm.poov;

public enum Material {
    MADEIRA("madeira"),
    ACO("aço"),
    VIDRO("Vidro"),
    PVC("PVC"),
    ALUMINIO("alumínio");


    private String descricao;
    private Material(String descricao){
        this.descricao = descricao;
    }

    String getDescricao(){
        return descricao;
    }
}
