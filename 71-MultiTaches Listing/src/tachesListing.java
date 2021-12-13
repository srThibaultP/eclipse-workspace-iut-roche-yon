import java.io.File;

public class tachesListing extends Thread {

    public void tachesListing() {
    }

    public void run() {
        File userDir = new File(System.getProperty("user.dir"));
        System.out.println("Nombre de fichiers : " + getNombreFichiers(userDir, 0, 100));
    }

    public int getNombreFichiers(File pRepertoire, double pDbtProgress, double pFinProgress) {
        File[] fichiers = pRepertoire.listFiles();
        int nbFichier = 0;
        if (fichiers.length > 0) {
            double step = (pFinProgress - pDbtProgress) / fichiers.length;

            for (int i = 0; i < fichiers.length; i++) {
                double progression = pDbtProgress + i * step;

                // Transmission de l'état d'avancement de la recherche de fichiers
                System.out.println("\033[34;1mTâche de listing: " + Math.min((int) progression, 100) + "%\033[0m");

                // Ajout d'un temps d'attente pour observer les changements à l'échelle humaine
                try {
                    Thread.sleep(80);
                } catch (InterruptedException IEex) {
                    System.out.println("Interruption de l'attente de 50ms");
                }

                // Publication des résultats temporaires de la tache: répertoires + fichiers
                if (fichiers[i].isDirectory()) {
                    System.out.println(
                            "\033[34;1mExploration du répertoire: " + fichiers[i].getAbsolutePath() + "...\033[0m");
                    nbFichier += getNombreFichiers(fichiers[i], progression, progression + step);
                } else {
                    System.out.println("\033[34;1m" + fichiers[i].getAbsolutePath() + "\033[0m");
                    nbFichier++;
                }
            }
            return nbFichier;
        }
        return 0;
    }
}
