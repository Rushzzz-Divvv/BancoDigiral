public class Main {
    public static void main(String[] args) {
        // Criando contas
        IConta contaCorrente = new ContaCorrente("Radija");
        IConta contaPoupanca = new ContaPoupanca("Icaro");

        // Criando clientes
        Cliente cliente1 = new Cliente("Radija", contaCorrente);
        Cliente cliente2 = new Cliente("Icaro", contaPoupanca);

        // Criando banco e adicionando clientes
        Banco banco = new Banco("Banco REX");
        banco.adicionarCliente(cliente1);
        banco.adicionarCliente(cliente2);

        // Realizando operações
        contaCorrente.depositar(1000);
        contaPoupanca.depositar(500);

        cliente1.exibirSaldo();
        cliente2.exibirSaldo();

        contaCorrente.sacar(200);
        contaPoupanca.sacar(50);

        banco.realizarTransferencia(cliente1, cliente2, 300);

        cliente1.exibirSaldo();
        cliente2.exibirSaldo();
    }
}