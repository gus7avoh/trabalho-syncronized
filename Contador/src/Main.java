public class Main {
    public static void main(String[] args) {
        Contador contador = new Contador();

        Thread t1 = new Thread(new Processador(contador, 1));
        Thread t2 = new Thread(new Processador(contador, 2));
        Thread t3 = new Thread(new Processador(contador, 3));

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Valor final: " + contador.getQuantidade());
        System.out.println("Execuções thread 1: "  + contador.getExec_1());
        System.out.println("Execuções thread 2: "  + contador.getExec_2());
        System.out.println("Execuções thread 3: "  + contador.getExec_3());
         
        System.out.println("Esperado:    300");
        System.out.println(contador.getQuantidade() == 300
            ? "Synchronized funcionou."
            : "Condição de corrida detectada");
    }
}
