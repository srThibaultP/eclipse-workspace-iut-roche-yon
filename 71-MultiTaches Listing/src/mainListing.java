public class mainListing {
    public static void main(String[] args) {
        tachesListing tacheA = new tachesListing();
        mainSound tacheB = new mainSound();

        tacheB.start();
        tacheA.start();
        

        for (int i = 0; i < 20; i++) {
            System.out.println("\033[31;1mTâches Principale: " + i + "\033[0m");
            try {
                Thread.sleep(50);
            } catch (InterruptedException IEex) {
                System.out.println("Interruption de l'attente de 50ms");
            }
        }
    }
}
