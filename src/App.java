import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {
        String nomeArquivo = "pedidos.txt";

        LinkedList<Pedido> pedidos = montaListaPedidos(nomeArquivo);
        Prioridade p = new Prioridade(pedidos);
        Empacotador e1 = new Empacotador(p, "Empacotador 1");
        Empacotador e2 = new Empacotador(p, "Empacotador 2");

        ControladorEmpacotadores ce = new ControladorEmpacotadores(e1, e2);
        ce.executarEmpacotadores();
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
