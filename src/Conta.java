public abstract class Conta implements IConta {
    protected String titular;
    protected double saldo;

    public Conta(String titular) {
        this.titular = titular;
        this.saldo = 0.0;
    }

    @Override
    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito de R$" + valor + " realizado para " + titular);
        } else {
            System.out.println("Valor inválido para depósito.");
        }
    }

    @Override
    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado por " + titular);
        } else {
            System.out.println("Saldo insuficiente ou valor inválido para saque.");
        }
    }

    @Override
    public void transferir(double valor, IConta destino) {
        if (valor > 0 && valor <= saldo) {
            this.saldo -= valor;
            destino.depositar(valor);
            System.out.println("Transferência de R$" + valor + " de " + this.titular + " para " + ((Conta)destino).titular);
        } else {
            System.out.println("Transferência não realizada. Verifique o saldo ou valor.");
        }
    }

    @Override
    public void exibirSaldo() {
        System.out.println("Saldo de " + titular + ": R$" + saldo);
    }
}