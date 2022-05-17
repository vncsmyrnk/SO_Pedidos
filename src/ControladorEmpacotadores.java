import java.util.concurrent.TimeUnit;

public class ControladorEmpacotadores implements Runnable {
    private Empacotador empacotador1;
    private Empacotador empacotador2;

    public ControladorEmpacotadores(Empacotador e1, Empacotador e2) {
        this.empacotador1 = e1;
        this.empacotador2 = e2;
    }

    public void executarEmpacotadores() {
        try {
            new Thread(this.empacotador1).start();
            TimeUnit.MILLISECONDS.sleep(500);
            new Thread(this.empacotador2).start();
        } catch (Exception e) {
        }
    }

    @Override
    public void run() {
        this.executarEmpacotadores();
    }
}
