import java.util.ArrayList;
import java.util.List;

public class Banco {
    private String nome;
    private List<Cliente> clientes;

    public Banco(String nome) {
        this.nome = nome;
        this.clientes = new ArrayList<>();
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void realizarTransferencia(Cliente origem, Cliente destino, double valor) {
        origem.getConta().transferir(valor, destino.getConta());
    }

    public void exibirSaldos() {
        for (Cliente cliente : clientes) {
            System.out.println(cliente.getNome() + " - ");
            cliente.exibirSaldo();
        }
    }
}