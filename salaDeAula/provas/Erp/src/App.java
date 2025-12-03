import java.time.LocalDate;

public class App {
    public static void main(String[] args) throws Exception {
        Empregado emp = new Empregado(1L, "Estrobilobado", "123456", LocalDate.of(1980, 1, 15), 3000);
        Desenvolvedor dev = new Desenvolvedor(2L, "Zirgonisvaldo", "654321", LocalDate.of(1980, 2, 25), 8000.0, "Sênior");
        Gerente ger = new Gerente(3L, "Grosbilda", "789021", LocalDate.of(1981, 3, 25), 10000.0, 2000.0);
        RoboXPT421Z robo = new RoboXPT421Z("HAL") ;
        Departamento dep = new Departamento("Inovação", ger);

        dep.adicionarTrabalhador(emp);
        dep.adicionarTrabalhador(dev);
        dep.adicionarTrabalhador(ger);
        dep.adicionarTrabalhador(robo);

        System.out.println("DEPARTAMENTO");
        System.out.println(dep);
        dep.executarTrabalho();

        
    }
}
