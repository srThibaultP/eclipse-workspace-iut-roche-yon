package dip.lry.carnet;

public class Echantillon {
    private String titre;
    private String nom;
    private String prenom;
    private String adresse;

    public Echantillon(String pTitre, String pNom, String pPrenom, String pAdresse) {
        this.titre = pTitre;
        this.nom = pNom;
        this.prenom = pPrenom;
        this.adresse = pAdresse;
    }

    public String getTitre() {
        return this.titre;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public String getNom() {
        return this.nom;
    }

    public String getAdresse() {
        return this.adresse;
    }

    public void setTitre(String pTitre) {
        this.titre = pTitre;
    }

    public void setPrenom(String pPrenom) {
        this.prenom = pPrenom;
    }

    public void setNom(String pNom) {
        this.nom = pNom;
    }

    public void setAdresse(String pAdresse) {
        this.adresse = pAdresse;
    }
}
