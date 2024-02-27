package org.bancodigital;

import java.util.Optional;
import java.util.Scanner;

public class Main {

    private static DataBase dataBase = new DataBase();
    private static Cliente cliente = new Cliente();
    private static ContaCorrente contaCorrente = new ContaCorrente(cliente);
    private static ContaPoupanca contaPoupança = new ContaPoupanca(cliente);
    /**
     * Classe do Java para manipular entradas via teclado.
     */
    private static Scanner scanner;
    static {
        scanner = new Scanner(System.in);
    }

    /**
     * Método utilitário para inicializar a aplicação.
     */
    public static void main(String[] args) {

        System.out.println("Bem vindo.");

        String opcao = "";

        while (true) {

            System.out.println("Selecione uma opção:");

            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Excluir Cliente");
            System.out.println("3 - Consultar Cliente por CPF");

            System.out.println("4 - Cadastrar Conta");
            System.out.println("5 - Excluir Conta");
            System.out.println("6 - Consultar Conta por Numero");
            System.out.println("7 - Consultar Conta por Cpf");

            System.out.println("8 - Listar Clientes");
            System.out.println("9 - Listar Contas");
            System.out.println("10 - Listar Contas Poupança");
            System.out.println("11 - Listar Contas Correntes");

            System.out.println("13 - Sair");

            opcao = lerDado();

            switch (opcao) {
                case "1": // Cadastrar Cliente
                    Cliente cliente = lerCliente();
                    dataBase.salvarCliente(cliente);
                    break;
                case "2": // Excluir Cliente
                    System.out.println("Digite o cpf do cliente");
                    String cpfCliente = lerDado();
                    dataBase.excluirCliente(cpfCliente);
                    break;
                case "3":// Consultar cliente por cpf
                    System.out.println("Digite o cpf do cliente.");
                    cpfCliente = lerDado();
                    dataBase.listarClintePorCpf(cpfCliente);
                    break;
                case "4": // Cadastrar Conta
                    Conta conta = lerConta();
                    dataBase.salvarConta(conta);
                    break;
                case "5": // Excluir Conta
                    System.out.println("Digite o numero da conta");
                    String codigoConta = lerDado();
                    dataBase.excluirConta(Integer.parseInt(codigoConta));
                    break;
                case "6":// Consultar conta por numero
                    System.out.println("Digite numero da conta.");
                    codigoConta = lerDado();
                    dataBase.listarContaPorNumero(Integer.parseInt(codigoConta));
                    break;
                case "7": // Consultar conta por cpf
                    System.out.println("Digite cpf dp titular da conta.");
                    cpfCliente = lerDado();
                    dataBase.listarClintePorCpf(cpfCliente);
                    break;
                case "8": // Listar cliente
                    System.out.println("Lista de cliente:");
                    dataBase.listarTodosClientes();
                    break;
                case "9": // Listar contas
                    System.out.println("Lista de contas:");
                    dataBase.listarTodasContas();
                    break;
                case "10": // Listar contas
                    System.out.println("Lista de contas poupança:");
                    dataBase.listarTodasContasPoupanca();
                    break;
                case "11": // Listar contas
                    System.out.println("Lista de contas correntes:");
                    dataBase.listarTodasContasCorrente();
                    break;
                case "13":
                    System.out.println("Aplicação encerrada.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }

        }
    }

    // Métodos auxiliares
    /**
     * Ler um dado específico
     */
    public static String lerDado() {

        String texto = scanner.nextLine();

        return texto.toUpperCase();
    }

    /**
     * Ler os dados do cliente a ser cadastrado.
     * 
     * @return Um cliente a partir dos dados de entrada
     */
    public static Cliente lerCliente() {

        System.out.println("Cadastrando novo cliente...");
        Cliente cliente = new Cliente();

        System.out.println("Digite o nome");
        String nome = lerDado();
        cliente.setNome(nome.toUpperCase());

        System.out.println("Digite o CPF");
        String cpf = lerDado();
        cliente.setCpf(cpf.toUpperCase());

        System.out.println("Digite o telefone");
        String telefone = lerDado();
        cliente.setTelefone(telefone.toUpperCase());

        System.out.println("Digite a data de nascimento");
        String nascimento = lerDado();
        cliente.setNascimento(nascimento.toUpperCase());

        return cliente;
    }

    /**
     * Ler os dados do cliente a ser cadastrado.
     * 
     * @return Um cliente a partir dos dados de entrada
     */
    public static Conta lerConta() {

        Conta conta = null;

        System.out.println("Cadastrando nova conta...");

        System.out.println("Digite o cpf do cliente");
        String cpf = lerDado();

        Cliente cliente = getClienteCpf(cpf);

        System.out.println("Digite P para conta poupança ou C para conta corrente.");
        String tipoConta = lerDado().toUpperCase();

        if (tipoConta.equals("P")) {
            ContaPoupanca contaPoupanca = new ContaPoupanca(cliente);

            System.out.println("Digite o valor do saldo inicial da conta");
            String saldoInicialConta = lerDado();

            contaPoupanca.depositar(Double.parseDouble(saldoInicialConta));

            conta = contaPoupanca;

        } else {
            ContaCorrente contaCorrente = new ContaCorrente(cliente);

            System.out.println("Digite o valor do saldo inicial da conta");
            String saldoInicialConta = lerDado();

            contaCorrente.depositar(Double.parseDouble(saldoInicialConta));

            conta = contaCorrente;
        }
        return conta;
    }

    /**
     * @param cpf
     * @return Cliente
     */
    private static Cliente getClienteCpf(String cpf) {

        Cliente cliente = null;

        for (int i = 0; i < dataBase.getClientes().length; i++) {

            Cliente clienteTemporario = dataBase.getClientes()[i];
            if (clienteTemporario.getCpf().equals(cpf)) {
                cliente = clienteTemporario;
                break;
            }
        }
        return cliente;
    }
}