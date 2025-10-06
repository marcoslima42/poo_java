package iftm.poov;

public enum EscalaTemperatura {
    CELSIUS("° Celsius"),
    FAHRENHEIT("° Fahrenheit"),
    KELVIN(" Kelvin");

    private String descricao;

    private EscalaTemperatura(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
