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
    private java.sql.PreparedStatement instrSelect, instrINSERT, instrUpdate, instrDelete;
    private Connection connexion;
    private ResultSet resultat = null;

    /****************************************** CONSTRUCTEUR****************************************/

    public ModeleTable(String driver, String url, String user, String pass) throws SQLException, ClassNotFoundException {
        this.JDBC_DRIVER = driver;
        this.DB_URL = url;
        this.USER = user;
        this.PASS = pass;

        this.connexion = DriverManager.getConnection(this.DB_URL, this.USER, this.PASS);
        this.instrSelect = this.connexion.prepareStatement("SELECT * FROM carnetAdresse");
        Class.forName(driver);
        
        this.resultat = this.instrSelect.executeQuery();
        while (this.resultat.next()) {
            this.data.add(new Echantillon(this.resultat.getString("titre"), this.resultat.getString("Prenom"), this.resultat.getString("nom"), this.resultat.getString("adresse")));
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
