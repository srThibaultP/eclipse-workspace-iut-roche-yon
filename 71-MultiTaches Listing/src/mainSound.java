public class mainSound extends Thread{
    public void tachesListing(){
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("\033[32;1mTâche sonore :" + i + "\033[0m");
            java.awt.Toolkit.getDefaultToolkit().beep();

            try {
                Thread.sleep(100);
            } catch (InterruptedException IEex) {
                System.out.println("Interruption de l'attente de 100ms");
            }
        }
    }
}
