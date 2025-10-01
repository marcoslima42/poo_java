package iftm.poov;
import java.util.ArrayList;
import java.util.Date;

public class App {

    public static void quebrarUmaLampada(Lampada l) {
        l.quebrar();
    }

    public static Lampada criarUmaLampada(int t, int p) {
        Lampada l = new Lampada(t, p);
        return l;
    }

    public static void main(String[] args) throws Exception {

        Lampada lampadas[] = new Lampada[5];
        lampadas[0] = new Lampada();
        lampadas[1] = new Lampada(220, 150);

        ArrayList<Lampada> outrasLampadas = new ArrayList<>();
        outrasLampadas.add(new Lampada());
        outrasLampadas.get(0).mostrar();

        Lampada l1 = new Lampada(-1000, -1000, false);
        Lampada l2 = new Lampada(110, 100);
        Lampada l3 = new Lampada(220, 150, true);

        quebrarUmaLampada(l1);

        l1.mostrar();
        // System.out.println(l1.getTensao());

        int total = l1.getPotencia() + l2.getPotencia() + l3.getPotencia();

        // l1.tensao = -1000;
        l1.setTensao(-1000);
        // l1.potencia = -1000;
        l1.setPotencia(-1000);
        // l1.acesa = true;
        // l1.quebrada = true;
        l1.setQuebrada(true);
        // l1.queimada = true;
        l1.setQueimada(true);
        l1.setAcesa(true);

        l2.acender();
        l2.apagar();

        l1.mostrar();
        l2.mostrar();
        l3.mostrar();

    }
}