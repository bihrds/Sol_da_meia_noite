import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Main1 {
    private static final String DATA_FILE = "dados.txt";
    private static Map<String, Cliente> clientes = new HashMap<>();
    private static List<Empresa> empresas = new ArrayList<>();
    private static List<Fabricante> fabricantes = new ArrayList<>();
    private static List<PlacaSolar> placasSolares = new ArrayList<>();
    private static List<Inversor> inversores = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        carregarDados();

        while (true) {
            System.out.println("=====Bem-vindo ao sistema!=====");
            System.out.println("1- Login");
            System.out.println("2- Cadastro de Cliente");
            System.out.println("3- Cadastro de Fabricante");
            System.out.println("4- Cadastro de Placa Solar");
            System.out.println("5- Cadastro de Inversor");
            System.out.println("6- Sair");
            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    realizarLogin();
                    break;
                case 2:
                    cadastrarCliente();
                    break;
                case 3:
                    cadastrarFabricante();
                    break;
                case 4:
                    cadastrarPlacaSolar();
                    break;
                case 5:
                    cadastrarInversor();
                    break;
                case 6:
                    System.out.println("Saindo!");
                    salvarDados();
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static void realizarLogin() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        for (Cliente cliente : clientes.values()) {
            if (cliente.getNome().equals(nome) && cliente.getSenha().equals(senha)) {
                clienteMenu(cliente);
                return;
            }
        }

        for (Empresa empresa : empresas) {
            if (empresa.getNome().equals(nome) && empresa.getSenha().equals(senha)) {
                empresaMenu(empresa);
                return;
            }
        }

        System.out.println("Usuário ou senha inválidos.");
    }

    private static void cadastrarCliente() {
        System.out.print("Nome do cliente: ");
        String nome = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.println("Cpf do cliente: ");
        String cpf = scanner.nextLine();

        clientes.put(cpf, new Cliente(nome, senha, endereco, telefone, cpf));
        System.out.println("Cliente cadastrado com sucesso!");
    }

    private static void cadastrarFabricante() {
        System.out.print("Nome do Fabricante: ");
        String nome = scanner.nextLine();
        fabricantes.add(new Fabricante(nome));
        System.out.println("Fabricante cadastrado com sucesso!");
    }
    
    private static void cadastrarPlacaSolar() {
        System.out.print("Modelo da Placa Solar: ");
        String modelo = scanner.nextLine();
        System.out.print("Capacidade em watts: ");
        double capacidade = scanner.nextDouble();
        scanner.nextLine();  // consumir a nova linha
        System.out.print("Preço: ");
        double preco = scanner.nextDouble();
        scanner.nextLine(); 

        System.out.println("Selecione o fabricante:");
        for (int i = 0; i < fabricantes.size(); i++) {
            System.out.println((i + 1) + " - " + fabricantes.get(i).getNome());
        }
        int fabricanteEscolhido = scanner.nextInt() - 1;
        scanner.nextLine(); 

        if (fabricanteEscolhido >= 0 && fabricanteEscolhido < fabricantes.size()) {
            placasSolares.add(new PlacaSolar(modelo, capacidade, preco, fabricantes.get(fabricanteEscolhido)));
            System.out.println("Placa Solar cadastrada com sucesso!");
        } else {
            System.out.println("Fabricante inválido.");
        }
    }

    private static void cadastrarInversor() {
        System.out.print("Modelo do Inversor: ");
        String modelo = scanner.nextLine();
        System.out.print("Potência (em watts): ");
        double potencia = scanner.nextDouble();
        scanner.nextLine(); 
        System.out.print("Preço: ");
        double preco = scanner.nextDouble();
        scanner.nextLine(); 

        System.out.println("Selecione o fabricante:");
        for (int i = 0; i < fabricantes.size(); i++) {
            System.out.println((i + 1) + " - " + fabricantes.get(i).getNome());
        }
        int fabricanteEscolhido = scanner.nextInt() - 1;
        scanner.nextLine(); 

        if (fabricanteEscolhido >= 0 && fabricanteEscolhido < fabricantes.size()) {
            inversores.add(new Inversor(modelo, potencia, preco, fabricantes.get(fabricanteEscolhido)));
            System.out.println("Inversor cadastrado com sucesso!");
        } else {
            System.out.println("Fabricante inválido.");
        }
    }

    private static void clienteMenu(Cliente cliente) {
        while (true) {
            System.out.println("Menu do Cliente: " + cliente.getNome());
            System.out.println("1- Solicitar Projeto");
            System.out.println("2- Sair");
            int escolha = scanner.nextInt();
            scanner.nextLine();

            if (escolha == 1) {
                cliente.solicitarProjeto();
            } else if (escolha == 2) {
                break;
            } else {
                System.out.println("Opção inválida.");
            }
        }
    }

    private static void empresaMenu(Empresa empresa) {
        while (true) {
            System.out.println("Menu da Empresa: " + empresa.getNome());
            System.out.println("1- Gerenciar Solicitações");
            System.out.println("2- Gerar Relatório Financeiro");
            System.out.println("3- Sair");
            int escolha = scanner.nextInt();
            scanner.nextLine();

            if (escolha == 1) {
                empresa.gerenciarSolicitacoes();
            } else if (escolha == 2) {
                empresa.gerarRelatorioFinanceiro();
            } else if (escolha == 3) {
                break;
            } else {
                System.out.println("Opção inválida.");
            }
        }
    }

    private static void carregarDados() {
        File file = new File(DATA_FILE);
        if (!file.exists()) {
            System.out.println("Arquivo de dados não encontrado. Começando com listas vazias.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");
                switch (data[0]) {
                    case "Cliente":
                        clientes.put(data[5], new Cliente(data[1], data[2], data[3], data[4], data[5]));
                        break;
                    case "Empresa":
                        empresas.add(new Empresa(data[1], data[2]));
                        break;
                    case "Fabricante":
                        fabricantes.add(new Fabricante(data[1]));
                        break;
                    case "PlacaSolar":
                        placasSolares.add(new PlacaSolar(data[1], Double.parseDouble(data[2]), Double.parseDouble(data[3]), new Fabricante(data[4])));
                        break;
                    case "Inversor":
                        inversores.add(new Inversor(data[1], Double.parseDouble(data[2]), Double.parseDouble(data[3]), new Fabricante(data[4])));
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void salvarDados() {
        try (FileWriter writer = new FileWriter(DATA_FILE)) {
            for (Cliente cliente : clientes.values()) {
                writer.write("Cliente;" + cliente.getNome() + ";" + cliente.getSenha() + ";" + cliente.getEndereco() + ";" + cliente.getTelefone() + "\n");
            }
            for (Empresa empresa : empresas) {
                writer.write("Empresa;" + empresa.getNome() + ";" + empresa.getSenha() + "\n");
            }
            for (Fabricante fabricante : fabricantes) {
                writer.write("Fabricante;" + fabricante.getNome() + "\n");
            }
            for (PlacaSolar placa : placasSolares) {
                writer.write("PlacaSolar;" + placa.getModelo() + ";" + placa.getCapacidade() + ";" + placa.getPreco() + ";" + placa.getFabricante().getNome() + "\n");
            }
            for (Inversor inversor : inversores) {
                writer.write("Inversor;" + inversor.getModelo() + ";" + inversor.getPotencia() + ";" + inversor.getPreco() + ";" + inversor.getFabricante().getNome() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}