package iftm.poov;

public class Temperatura {
    private EscalaTemperatura escala;
    private double valor;

    public Temperatura(){
        setEscala(EscalaTemperatura.CELSIUS);
        setValor(0.0);
    }
    
    public Temperatura(EscalaTemperatura escala, double valor) {
        this.escala = escala;
        this.valor = valor;
    }
    //Getters e Setters
    public EscalaTemperatura getEscala() {
        return escala;
    }
    public void setEscala(EscalaTemperatura escala) {
        this.escala = escala;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    
    //metodos
    
    public void setTemperatura(int escala, double valor){

        switch (escala) {
            case 1:
                setEscala(EscalaTemperatura.CELSIUS);
                break;
            case 2:
                setEscala(EscalaTemperatura.FAHRENHEIT);
                break;
            default:
                setEscala(EscalaTemperatura.KELVIN);
                break;
        }
        if(this.escala == EscalaTemperatura.CELSIUS){
            if(valor < -273.15 || valor > 1.415e32){
                System.out.println("Valor de Temperatura inválido, usando 0.0");
                valor = 0.0;
            }
        } else if(this.escala == EscalaTemperatura.FAHRENHEIT){
            if(valor < -459.67 || valor > 2.5e32){
                System.out.println("Valor de Temperatura inválido, usando 32.0");
                valor = 32.0;
            }
        }
        else{
            if(valor < 0 || valor > 1.416e32){
                System.out.println("Valor de Temperatura inválido, usando 273.0");
                valor = 273.0;
            }
        }
        setValor(valor);
    }

    public double getTemperaturaCelsius(){
        if(this.escala == EscalaTemperatura.CELSIUS)
            return (this.valor - 32.0)*5.0/9.0;
        else if(this.escala == EscalaTemperatura.KELVIN)
            return (this.valor) - 273.15;
        else
            return this.valor;
    }
    

    public double getTemperaturaFahrenheit(){
        if(this.escala == EscalaTemperatura.CELSIUS)
            return (this.valor) * (9.0/5.0) + 32;
        else if(this.escala == EscalaTemperatura.KELVIN)
            return (this.valor - 273.15) * 9.0/5.0 + 32;
        else
            return this.valor;
    }

    public double getTemperaturaKelvin(){
        if(this.escala == EscalaTemperatura.CELSIUS)
            return this.valor + 273.15;
        else if(this.escala == EscalaTemperatura.FAHRENHEIT)
            return (this.valor - 32.0) * 5.0 / 9.0 + 273.15;
        else 
            return this.valor;
    }

    @Override
    public String toString() {
        return "Temperatura [escala=" + escala + ", valor=" + valor + "]";
    }

    
}


