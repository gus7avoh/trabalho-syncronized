public class Contador {
    private int quantidade = 0;
    private int exec_1 = 0;
    private int exec_2 = 0;
    private int exec_3 = 0;


    // /synchronized
    public  void incrementar(int pos) {
        int atual = this.quantidade;
        try {
            System.out.println("Tot: " + quantidade + ": " + pos);
            switch (pos){
                case 1 : 
                    exec_1++;
                    break;
                case 2 : 
                    exec_2++;
                    break;
                case 3 : 
                    exec_3++;
                    break;
            }
            Thread.sleep(2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.quantidade = atual + 1;
    }

    public int getQuantidade() {
        return this.quantidade;
    }
    public int getExec_1() {
        return this.exec_1;
    }

    public int getExec_2() {
        return this.exec_2;
    }

    public int getExec_3() {
        return this.exec_3;
    }

}