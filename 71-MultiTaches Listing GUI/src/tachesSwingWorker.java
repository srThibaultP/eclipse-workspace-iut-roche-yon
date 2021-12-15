import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.util.List;

import javax.swing.SwingWorker;

public class tachesSwingWorker extends SwingWorker implements PropertyChangeListener{
    GUI fen;

    public void tachesSwingWorker(GUI pIHM) {
        this.fen = pIHM;
        addPropertyChangeListener(this);
    }

    public int getNombreDeFichiers(File dir, double progressStart, double progressEnd) {
        File[] fichiers = dir.listFiles();
        int nbFichier = 0;
        if (fichiers.length > 0) {
            double step = (progressEnd - progressStart) / fichiers.length;

            for (int i = 0; i < fichiers.length; i++) {
                double progression = progressStart + i * step;

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
                    nbFichier += getNombreDeFichiers(fichiers[i], progression, progression + step);
                } else {
                    System.out.println("\033[34;1m" + fichiers[i].getAbsolutePath() + "\033[0m");
                    nbFichier++;
                }
            }
            return nbFichier;
        }
        return 0;}
    
    protected void process(List <String> nomFichier) {}

    protected void done(){}

    public void propertyChange(PropertyChangeEvent evt) {}

    @Override
    protected Object doInBackground() throws Exception {
        // TODO Auto-generated method stub
        return null;
    }
}
