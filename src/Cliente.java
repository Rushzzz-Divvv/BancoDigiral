public class Cliente {
    private String nome;
    private IConta conta;

    public Cliente(String nome, IConta conta) {
        this.nome = nome;
        this.conta = conta;
    }

    public String getNome() {
        return nome;
    }

    public IConta getConta() {
        return conta;
    }

    public void exibirSaldo() {
        conta.exibirSaldo();
    }
}