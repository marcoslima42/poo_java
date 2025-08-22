import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);

        String dataNascimento;
        LocalDate data;
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.print("Digite sua data de nascimento no 'formato dd/mm/aaaa': ");
        dataNascimento = s.nextLine();
        data = LocalDate.parse(dataNascimento, formatador);
        
        System.out.println("Nascimento: " + data.format(formatador));

        String textoDiaSemana = nasccimento.getDayofWeek()
                .getDisplay



    }
}
