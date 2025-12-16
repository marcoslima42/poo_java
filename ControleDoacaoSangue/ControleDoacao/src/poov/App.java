package poov;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import poov.dao.DoacaoDAO;
import poov.dao.DoadorDAO;
import poov.modelo.Doacao;
import poov.modelo.Doador;
import poov.modelo.RH;
import poov.modelo.Situacao;
import poov.modelo.TipoSanguineo;

public class App {
    private static Scanner scanner = new Scanner(System.in);
    private static DoadorDAO daoDoador = new DoadorDAO();
    private static DoacaoDAO daoDoacao = new DoacaoDAO();
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void main(String[] args) {
        boolean executando = true;
        while (executando) {
            System.out.println("1 – Doador");
            System.out.println("2 – Doação");
            System.out.println("3 – Sair");
            System.out.print("Opção: ");
            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    menuDoador();
                    break;
                case "2":
                    menuDoacao();
                    break;
                case "3":
                    executando = false;
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }

    private static void menuDoador() {
        boolean voltar = false;
        while (!voltar) {
            System.out.println("Doador");
            System.out.println("1 – Cadastrar");
            System.out.println("2 – Pesquisar");
            System.out.println("3 – Alterar");
            System.out.println("4 – Remover");
            System.out.println("5 – Voltar");
            System.out.print("Opção: ");
            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    cadastrarDoador();
                    break;
                case "2":
                    menuPesquisarDoador();
                    break;
                case "3":
                    alterarDoador();
                    break;
                case "4":
                    removerDoador(); 
                    break;
                case "5":
                    voltar = true;
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }

    private static void menuPesquisarDoador() {
        boolean voltar = false;
        while (!voltar) {
            System.out.println("Pesquisar");
            System.out.println("1 – Pelo código");
            System.out.println("2 – Pelo nome");
            System.out.println("3 – Pelo CPF");
            System.out.println("4 – Voltar");
            System.out.print("Opção: ");
            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    System.out.print("Digite o código: ");
                    try {
                        Long codigo = Long.parseLong(scanner.nextLine());
                        Doador d = daoDoador.buscarCodigo(codigo);
                        if (d != null) {
                            System.out.println(d);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Código inválido");
                    }
                    break;
                case "2":
                    System.out.print("Digite o nome: ");
                    String nome = scanner.nextLine();
                    List<Doador> listaNome = daoDoador.buscarNome(nome);
                    for (Doador doador : listaNome) {
                        System.out.println(doador);
                    }
                    break;
                case "3":
                    System.out.print("Digite o CPF: ");
                    String cpf = scanner.nextLine();
                    List<Doador> listaCpf = daoDoador.buscarCPF(cpf);
                    for (Doador doador : listaCpf) {
                        System.out.println(doador);
                    }
                    break;
                case "4":
                    voltar = true;
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }

    private static void menuDoacao() {
        boolean voltar = false;
        while (!voltar) {
            System.out.println("1 – Cadastrar");
            System.out.println("2 – Pesquisar");
            System.out.println("3 – Voltar");
            System.out.print("Opção: ");
            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    cadastrarDoacao();
                    break;
                case "2":
                    menuPesquisarDoacao();
                    break;
                case "3":
                    voltar = true;
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }

    private static void menuPesquisarDoacao() {
        boolean voltar = false;
        while (!voltar) {
            System.out.println("Pesquisar");
            System.out.println("1 – Pelo código do doador");
            System.out.println("2 – Pelo nome do doador");
            System.out.println("3 – Pelo CPF do doador");
            System.out.println("4 – Pelo código da doação");
            System.out.println("5 – Pela data da doação");
            System.out.println("6 – Voltar");
            System.out.print("Opção: ");
            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    System.out.print("Digite o código do doador: ");
                    try {
                        Long codDoador = Long.parseLong(scanner.nextLine());
                        List<Doacao> listaCod = daoDoacao.buscarCodDoador(codDoador);
                        for (Doacao doacao : listaCod) {
                            System.out.println(doacao);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Código inválido");
                    }
                    break;
                case "2":
                    System.out.print("Digite o nome do doador: ");
                    String nome = scanner.nextLine();
                    List<Doacao> listaNome = daoDoacao.buscarNome(nome);
                    for (Doacao doacao : listaNome) {
                        System.out.println(doacao);
                    }
                    break;
                case "3":
                    System.out.print("Digite o CPF do doador: ");
                    String cpf = scanner.nextLine();
                    List<Doacao> listaCpf = daoDoacao.buscarCPF(cpf);
                    for (Doacao doacao : listaCpf) {
                        System.out.println(doacao);
                    }
                    break;
                case "4":
                    System.out.print("Digite o código da doação: ");
                    try {
                        Long codDoacao = Long.parseLong(scanner.nextLine());
                        Doacao d = daoDoacao.buscarCodigo(codDoacao);
                        if (d != null) {
                            System.out.println(d);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Código inválido");
                    }
                    break;
                case "5":
                    System.out.print("Digite a data inicial (dd/mm/aaaa): ");
                    String dataIniStr = scanner.nextLine();
                    System.out.print("Digite a data final (dd/mm/aaaa): ");
                    String dataFimStr = scanner.nextLine();
                    
                    try {
                        List<Doacao> listaData = null;
                        
                        if (!dataIniStr.isEmpty() && !dataFimStr.isEmpty()) {
                            LocalDate dataIni = LocalDate.parse(dataIniStr, formatter);
                            LocalDate dataFim = LocalDate.parse(dataFimStr, formatter);
                            listaData = daoDoacao.buscarEntre(dataIni, dataFim);
                        } else if (!dataIniStr.isEmpty()) {
                            LocalDate dataIni = LocalDate.parse(dataIniStr, formatter);
                            listaData = daoDoacao.buscarApos(dataIni);
                        } else if (!dataFimStr.isEmpty()) {
                            LocalDate dataFim = LocalDate.parse(dataFimStr, formatter);
                            listaData = daoDoacao.buscarAntes(dataFim);
                        } else {
                            System.out.println("Nenhuma data informada");
                        }

                        if (listaData != null) {
                            for (Doacao doacao : listaData) {
                                System.out.println(doacao);
                            }
                        }
                    } catch (Exception e) {
                        System.out.println("Data inválida");
                    }
                    break;
                case "6":
                    voltar = true;
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }

    private static void cadastrarDoador() {
        try {
            Doador d = new Doador();
            System.out.print("Nome: ");
            d.setNome(scanner.nextLine());
            System.out.print("CPF: ");
            d.setCpf(scanner.nextLine());
            System.out.print("Contato: ");
            d.setContato(scanner.nextLine());
            
            System.out.print("Tipo Sanguíneo (A, B, AB, O, DESCONHECIDO): ");
            d.setTipoSanguineo(TipoSanguineo.valueOf(scanner.nextLine().toUpperCase()));
            
            System.out.print("RH (POSITIVO, NEGATIVO, DESCONHECIDO): ");
            d.setRh(RH.valueOf(scanner.nextLine().toUpperCase()));
            
            d.setTipoERhCorretos(false);
            d.setSituacao(Situacao.ATIVO);
            
            daoDoador.gravar(d);
        } catch (Exception e) {
            System.out.println("Erro ao ler dados: " + e.getMessage());
        }
    }

    private static void alterarDoador() {
        try {
            System.out.print("Digite o código do doador: ");
            Long codigo = Long.parseLong(scanner.nextLine());
            Doador d = daoDoador.buscarCodigo(codigo);
            if (d != null) {
                System.out.print("Novo Nome: ");
                String nome = scanner.nextLine();
                if (!nome.isEmpty()) d.setNome(nome);
                
                
                System.out.print("Novo Contato: ");
                String contato = scanner.nextLine();
                if (!contato.isEmpty()) d.setContato(contato);
                
                System.out.print("Novo Tipo Sanguíneo (A, B, AB, O, DESCONHECIDO): ");
                String tipo = scanner.nextLine().toUpperCase();
                if (!tipo.isEmpty()) d.setTipoSanguineo(TipoSanguineo.valueOf(tipo));
                
                System.out.print("Novo RH (POSITIVO, NEGATIVO, DESCONHECIDO): ");
                String rh = scanner.nextLine().toUpperCase();
                if (!rh.isEmpty()) d.setRh(RH.valueOf(rh));
                
                System.out.print("Tipo e RH Corretos (true/false): ");
                String corretos = scanner.nextLine();
                if (!corretos.isEmpty()) d.setTipoERhCorretos(Boolean.parseBoolean(corretos));
                
                daoDoador.atualizar(d);
            }
        } catch (Exception e) {
            System.out.println("Erro ao alterar: " + e.getMessage());
        }
    }

    private static void removerDoador() {
        try {
            System.out.print("Digite o código do doador: ");
            Long codigo = Long.parseLong(scanner.nextLine());
            daoDoador.desativar(codigo);
        } catch (Exception e) {
            System.out.println("Erro ao remover: " + e.getMessage());
        }
    }

    private static void cadastrarDoacao() {
        try {
            System.out.print("Digite o código do doador: ");
            Long codigoDoador = Long.parseLong(scanner.nextLine());
            Doador d = daoDoador.buscarCodigo(codigoDoador);
            if (d != null) {
                Doacao doacao = new Doacao();
                doacao.setDoador(d);
                System.out.print("Data (dd/mm/aaaa): ");
                doacao.setData(LocalDate.parse(scanner.nextLine(), formatter));
                System.out.print("Volume: ");
                doacao.setVolume(Double.parseDouble(scanner.nextLine()));
                doacao.setHora(LocalTime.now());
                doacao.setSituacao(Situacao.ATIVO);
                
                daoDoacao.gravar(doacao);
            }
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar doação: " + e.getMessage());
        }
    }
}