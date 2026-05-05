// package labthreadsconsole;

public class Processador implements Runnable {
    private Contador contador;
    private int pos;

    public Processador(Contador contador, int pos) {
        this.contador = contador;
        this.pos =  pos;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            contador.incrementar(pos);
        }
    }
}
