public class App {
    public static void main(String[] args) throws Exception {
        Lampada l = new Lampada();
        Lampada l2 = new Lampada(110, 100);
        Lampada l3 = new Lampada(110, 100, true);
        

        l.mostrar();
        l2.mostrar();
        l3.mostrar();

    }
}
