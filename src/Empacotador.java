public class Empacotador implements Runnable {
    private Prioridade prioridade;
    private Esteira esteira;
    private String nome;

    public Empacotador(Prioridade p, String nome) {
        this.prioridade = p;
        this.esteira = new Esteira();
        this.nome = nome;
    }

    public void empacotarPedidos() {
        System.out.println(
                "Empacotador " + this.nome + " acionado.");
        long tempoInicial = System.nanoTime();
        while (this.prioridade.hasProximoPedido()) {
            this.printStatus();
            Pedido proximoPacote = this.prioridade.proximoPacote();
            System.out.println("[" + this.nome + "] Executando pedido: " + proximoPacote + ". Executando o método: "
                    + this.prioridade.getDescricao());
            this.esteira.empacotar(proximoPacote);
            long tempoVolta = System.nanoTime() - tempoInicial;
            System.out.println("[" + this.nome + "] Pedido " + proximoPacote + " finalizado. Tempo até o momento: "
                    + (tempoVolta / 1_000_000_000d));
        }
    }

    public void printStatus() {
        System.out.println("[" + this.nome + "] Fila de pedidos: " + this.prioridade.pedidos);
    }

    public void run() {
        this.empacotarPedidos();
    }
}
