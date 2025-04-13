import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Criando contas
        IConta conta1 = new ContaCorrente("Marcos");
        IConta conta2 = new ContaPoupanca("Rogerio");

        // Criando clientes
        Cliente cliente1 = new Cliente("Marcos", conta1);
        Cliente cliente2 = new Cliente("Rogerio", conta2);

        // Criando banco
        Banco banco = new Banco("Banco REX");
        banco.adicionarCliente(cliente1);
        banco.adicionarCliente(cliente2);

        boolean sair = false;

        while (!sair) {
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Depositar");
            System.out.println("2 - Sacar");
            System.out.println("3 - Transferir");
            System.out.println("4 - Ver saldos");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> {
                    System.out.print("Escolha o cliente (1 - Marcos, 2 - Rogerio): ");
                    int c = scanner.nextInt();
                    System.out.print("Valor a depositar: ");
                    double valor = scanner.nextDouble();
                    if (c == 1) {
                        cliente1.getConta().depositar(valor);
                    } else {
                        cliente2.getConta().depositar(valor);
                    }
                }
                case 2 -> {
                    System.out.print("Escolha o cliente (1 - Marcos, 2 - Rogerio): ");
                    int c = scanner.nextInt();
                    System.out.print("Valor a sacar: ");
                    double valor = scanner.nextDouble();
                    if (c == 1) {
                        cliente1.getConta().sacar(valor);
                    } else {
                        cliente2.getConta().sacar(valor);
                    }
                }
                case 3 -> {
                    System.out.print("Transferir de (1 - Marcos, 2 - Rogerio): ");
                    int origem = scanner.nextInt();
                    System.out.print("Para (1 - Marcos, 2 - Rogerio): ");
                    int destino = scanner.nextInt();
                    System.out.print("Valor a transferir: ");
                    double valor = scanner.nextDouble();

                    Cliente origemCliente = (origem == 1) ? cliente1 : cliente2;
                    Cliente destinoCliente = (destino == 1) ? cliente1 : cliente2;

                    banco.realizarTransferencia(origemCliente, destinoCliente, valor);
                }
                case 4 -> banco.exibirSaldos();
                case 5 -> {
                    System.out.println("Saindo...");
                    sair = true;
                }
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();
    }
}