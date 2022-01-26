package dip.lry.carnet;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ModeleTable extends AbstractTableModel{
    private ArrayList <Echantillon> data = new ArrayList();
    private String[] title = {"Titre", "Nom", "Prénom", "Adresse"};
    private String JDBC_DRIVER, DB_URL, USER, PASS;
    private java.sql.PreparedStatement instrSelect, instrInsert, instrUpdate, instrDelete;
    private Connection connexion;
    private ResultSet resultat = null;
    private Statement creationTable;

    /****************************************** CONSTRUCTEUR****************************************/

    public ModeleTable(String driver, String url, String user, String pass) {
        this.JDBC_DRIVER = driver;
        this.DB_URL = url;
        this.USER = user;
        this.PASS = pass;

        try {
            //Connection à la base de données
            this.connexion = DriverManager.getConnection(this.DB_URL, this.USER, this.PASS);
            //Préparation de la requête pour la création de la table
            this.creationTable = this.connexion.createStatement();
        } catch (SQLException e) {
            System.out.println("Une erreur est survenu lors de la connexion : ");
            e.printStackTrace();
        }

        try {
            //Récupération des classes de la librairie
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            //Corruption de la librairie ?
            System.out.println("Une erreur est survenu lors de la récupération des classes : ");
            e.printStackTrace();
        }

        try {
            //Création de la table si elle existe pas
            this.creationTable.executeUpdate("CREATE TABLE IF NOT EXISTS carnetAdresse(id INT NOT NULL AUTO_INCREMENT, titre VARCHAR(5), nom VARCHAR(30), prenom VARCHAR(30), adresse VARCHAR(255), PRIMARY KEY(id))");
        } catch (SQLException e) {
            System.out.println("Une erreur est survenu lors de la création de la table : ");
            e.printStackTrace();
        }
        
        try {
            //Récupérartion des données de la table
            this.instrSelect = this.connexion.prepareStatement("SELECT * FROM carnetAdresse");
            this.resultat = this.instrSelect.executeQuery();
        } catch (SQLException e) {
            System.out.println("Une erreur est survenu lors de la récupération des données : ");
            e.printStackTrace();
        }
        try {
            while (this.resultat.next()) {
                this.data.add(new Echantillon(this.resultat.getString("titre"), this.resultat.getString("Prenom"), this.resultat.getString("nom"), this.resultat.getString("adresse")));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /****************************************** METHODES ****************************************/

    public void addData(String pTitre, String pNom, String pPrenom, String pAdresse) {
        String requete = "INSERT INTO carnetAdresse VALUES (DEFAULT,'" + pTitre + "', '" + pNom + "','" + pPrenom + "','" + pAdresse + "')";

        try {
            Statement stmt = this.connexion.createStatement();
            stmt.executeUpdate(requete);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        this.data.add(new Echantillon(pTitre, pNom, pPrenom, pAdresse));
        this.fireTableRowsInserted(this.data.size() - 1, this.data.size() - 1);
    }

    public void removeData(int rowIndex) {
        String requete = "DELETE FROM carnetAdresse ORDER BY id DESC LIMIT 1";

        try {
            Statement stmt = this.connexion.createStatement();
            stmt.executeUpdate(requete);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        this.data.remove(rowIndex);
        this.fireTableRowsDeleted(rowIndex, rowIndex);
    }

    /****************************************** GETTERS / SETTERS ****************************************/

    public int getRowCount() {
        return this.data.size();
    }
    
    @Override
    public int getColumnCount() {
        return this.title.length;
    }

    public String getColumnName(int columnIndex) {
        return this.title[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
        case 0:
            return ((Echantillon) this.data.get(rowIndex)).getTitre();
        case 1:
            return ((Echantillon) this.data.get(rowIndex)).getPrenom();
        case 2:
            return ((Echantillon) this.data.get(rowIndex)).getNom();
        case 3:
            return ((Echantillon) this.data.get(rowIndex)).getAdresse();
        }
        return null;
    }
}
