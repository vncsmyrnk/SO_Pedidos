import java.util.LinkedList;

public class Prioridade {

    private LinkedList<Pedido> pedidos;

    public Prioridade(LinkedList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    /*
     * carregar nova lista ordenada por chave(definindo prioridade)
     * ordenar nova lista após carregar (if else)
     * 
     * int prioridade = 99999;
     * while (hasNextLine) {
     * if (pedido.prioridade <= prioridade)
     * proximoFila = pedido;
     * }
     */
    public Pedido proximoPacotePrioritario() {
        System.out.println("\nFila de pedidos: " + pedidos.toString());
        return this.menorPedidoPrioridade();
    }

    public Pedido proximoPacoteMenorQuantidade() {
        System.out.println("\nFila de pedidos: " + pedidos.toString());
        return this.menorPedidoQuantidade();
    }

    public Pedido menorPedidoQuantidade() {
        Pedido menor = this.pedidos
                .stream()
                .min((p1, p2) -> p1.quantidade - p2.quantidade)
                .get();

        return this.pedidos.remove(this.pedidos.indexOf(menor));
    }

    public Pedido menorPedidoPrioridade() {
        Pedido menor = this.pedidos
                .stream()
                .min((p1, p2) -> Util.maxIntValueIfZero(p1.prazo) - Util.maxIntValueIfZero(p2.prazo))
                .get();

        return this.pedidos.remove(this.pedidos.indexOf(menor));
    }

    public boolean hasProximoPedido() {
        return !this.pedidos.isEmpty();
    }
}
