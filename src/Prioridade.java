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

    public Pedido proximoPacote() {
        System.out.println("\nFila de pedidos: " + pedidos.toString());
        return this.menorPedidoPrioridade();
    }

    public Pedido menorPedidoTamanho() {
        Pedido menor = this.pedidos.getFirst();
        for (Pedido p : this.pedidos) {
            if (p.quantidade < menor.quantidade) {
                menor = p;
            }
        }
        return this.pedidos.remove(this.pedidos.indexOf(menor));
    }

    public Pedido menorPedidoPrioridade2() {
        boolean isNotAll0 = true;
        for (Pedido p : this.pedidos) {
            isNotAll0 = p.prazo == 0 && isNotAll0;
        }

        if (!isNotAll0) {
            return this.pedidos.getFirst();
        }

        Pedido menor = this.pedidos.getFirst();
        for (Pedido p : this.pedidos) {
            if (p.prazo != 0 && p.prazo < menor.prazo) {
                menor = p;
            }
        }
        return this.pedidos.remove(this.pedidos.indexOf(menor));
    }

    public Pedido menorPedidoPrioridade() {
        Pedido menor = this.pedidos.getFirst();
        for (Pedido p : this.pedidos) {
            if (p.prazo != 0 && p.prazo < menor.prazo) {
                menor = p;
            }
        }
        return this.pedidos.remove(this.pedidos.indexOf(menor));
    }

    public boolean hasProximoPedido() {
        return !this.pedidos.isEmpty();
    }
}
