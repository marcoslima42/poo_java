package iftm.poov;

public class LampadaColorida extends Lampada{
    
    public LampadaColorida(){
        super(220, 100, true);
    }
    // @Override - sobreposto   
    public void mostrar(){

        System.out.println("Lampada");

    }
}
