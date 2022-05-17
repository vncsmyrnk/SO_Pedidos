import java.util.concurrent.TimeUnit;

public class Esteira {
    public static final int TEMPO_DE_PRODUCAO = 5000;
    public static final int TEMPO_DE_TRANSICAO = 500;

    public boolean empacotar(Pedido p) {
        try {
            for (int i = 0; i < p.quantidade; i += 20) {
                TimeUnit.MILLISECONDS.sleep(TEMPO_DE_PRODUCAO);
                TimeUnit.MILLISECONDS.sleep(TEMPO_DE_TRANSICAO);
                // System.out.println(p.toString());
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}