import java.time.LocalTime;
import java.util.LinkedList;

public class Prioridade {

    protected LinkedList<Pedido> pedidos;

    public Prioridade(LinkedList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public Pedido proximoPacote() {
        if (this.isQuantidadeModeOn()) {
            return this.menorPedidoQuantidade();
        }
        return this.menorPedidoPrioridade();
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

    public boolean isQuantidadeModeOn() {
        return LocalTime.now().getHour() <= 12;
    }

    public String getDescricao() {
        if (this.isQuantidadeModeOn()) {
            return "Prioridade por quantidade";
        }
        return "Prioridade por urgência";
    }
}
