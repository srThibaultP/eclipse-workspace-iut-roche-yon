/**
 * @Author: Thibault PECH
 * @Date:   2022-01-05 11:18:14
 * @Last Modified by:   Thibault PECH
 * @Last Modified time: 2022-01-28 14:06:34
 */

package dip.lry.carnet;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

import java.io.Console;
import java.sql.Connection;
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
                // Ajout des données dans l'ArrayList
                this.data.add(new Echantillon(this.resultat.getString("titre"), this.resultat.getString("Prenom"), this.resultat.getString("nom"), this.resultat.getString("adresse")));
            }
        } catch (SQLException e) {
            // Erreur lors de l'ajout des données
            e.printStackTrace();
        }
    }

    /****************************************** METHODES ****************************************/

    public void addData(String pTitre, String pNom, String pPrenom, String pAdresse) {
        // Préparation de la requête d'insertion des données dans la table
        String requete = "INSERT INTO carnetAdresse VALUES (DEFAULT,'" + pTitre + "', '" + pNom + "','" + pPrenom + "','" + pAdresse + "')";

        try {
            // Exécution de la requête : Insertion des données dans la table
            Statement stmt = this.connexion.createStatement();
            stmt.executeUpdate(requete);
        } catch (SQLException e) {
            System.out.println("Une erreur est survenu lors de l'insertion des données : ");
            e.printStackTrace();
        }
        // Ajout des données dans l'ArrayList
        this.data.add(new Echantillon(pTitre, pNom, pPrenom, pAdresse));
        this.fireTableRowsInserted(this.data.size() - 1, this.data.size() - 1);
    }

    public void removeData(int rowIndex) {
        // Préparation de la requête de suppression des données dans la table
        String requete = "DELETE FROM carnetAdresse ORDER BY id DESC LIMIT 1";

        try {
            // Exécution de la requête : Suppression des données dans la table
            Statement stmt = this.connexion.createStatement();
            stmt.executeUpdate(requete);
        } catch (SQLException e) {
            System.out.println("Une erreur est survenu lors de la suppression des données : ");
            e.printStackTrace();
        }
        // Suppression des données dans l'ArrayList
        this.data.remove(rowIndex);
        this.fireTableRowsDeleted(rowIndex, rowIndex);
    }

    /****************************************** GETTERS / SETTERS ****************************************/

    public int getRowCount() {
        return this.data.size();
    }
    
    public int getColumnCount() {
        return this.title.length;
    }

    public String getColumnName(int columnIndex) {
        return this.title[columnIndex];
    }

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
