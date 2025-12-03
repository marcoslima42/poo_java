public class RoboXPT421Z implements Trabalhador{
    private String identificacao;

    public RoboXPT421Z(String identificacao) {
        this.identificacao = identificacao;
    }

    public String getIdentificacao() {
        return identificacao;
    }

    public void executarTrabalho(){
        System.out.println("RoboXPT421Z executou o trabalho.");
    }

    @Override
    public String toString() {
        return "RoboXPT421Z [identificacao=" + identificacao + "]";
    }


    
}
