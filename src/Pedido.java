public class Pedido {
    public String nome;
    public int quantidade;
    public int prazo;

    public Pedido(String nome, int quantidade, int prazo) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.prazo = prazo;
    }

    @Override
    public String toString() {
        return this.nome + " - " + this.quantidade + " - " + this.prazo;
    }
}
