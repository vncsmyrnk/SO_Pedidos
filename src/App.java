import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        LinkedList<Pedido> pedidos = montaListaPedidos("pedidos.txt");
        Prioridade p = new Prioridade(pedidos);
        Esteira e = new Esteira();

        long tempoInicial = System.nanoTime();
        while (p.hasProximoPedido()) {
            e.empacotar(p.proximoPacote());
            long tempoVolta = System.nanoTime() - tempoInicial;
            System.out.println("Tempo gasto até então: " + (tempoVolta / 1_000_000_000d));
        }
    }

    public static Pedido getPedidoFromLine(String line) {
        String[] lParts = line.split(";");
        Pedido p = new Pedido(lParts[0], Integer.parseInt(lParts[1]), Integer.parseInt(lParts[2]));
        return p;
    }

    public static LinkedList<Pedido> montaListaPedidos(String nomeArquivo) throws Exception {
        File arquivoPedidos = new File(nomeArquivo);
        Scanner leitor = new Scanner(arquivoPedidos);
        LinkedList<Pedido> pedidos = new LinkedList<Pedido>();

        while (leitor.hasNextLine()) {
            String line = leitor.nextLine();
            Pedido pedido = getPedidoFromLine(line);
            pedidos.add(pedido);
        }

        // while (leitor.hasNextLine()) {
        // String line =
        // }

        leitor.close();
        return pedidos;
    }
}
