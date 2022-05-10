import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        LinkedList<Pedido> pedidos = montaListaPedidos("pedidos.txt");
        Prioridade p = new Prioridade(pedidos);
        Esteira e = new Esteira();

        System.out.println("-- Algoritmo prioridade --");

        long tempoInicial = System.nanoTime();
        while (p.hasProximoPedido()) {
            e.empacotar(p.proximoPacotePrioritario());
            long tempoVolta = System.nanoTime() - tempoInicial;
            System.out.println("Tempo gasto até então: " + (tempoVolta / 1_000_000_000d));
        }

        System.out.println("\n-- Algoritmo quantidade --");

        LinkedList<Pedido> pedidos2 = montaListaPedidos("pedidos.txt");
        Prioridade p2 = new Prioridade(pedidos2);
        Esteira e2 = new Esteira();

        tempoInicial = System.nanoTime();
        while (p2.hasProximoPedido()) {
            e2.empacotar(p2.proximoPacoteMenorQuantidade());
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

        leitor.close();
        return pedidos;
    }
}
