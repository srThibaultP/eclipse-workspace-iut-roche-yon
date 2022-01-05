import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class testBDD {
    /*********************************************************************
     * ATTRIBUTS
     **********************************************************************/
    private String DRIVER;
    private String DB_URL;
    private String USER;
    private String PASS;

    private Connection connexion;
    private Statement instruction = null;
    private ResultSet resultat = null;
    private PreparedStatement instrSelect = null;
    private PreparedStatement instrInsert = null;
    private PreparedStatement instrDelete = null;
    private PreparedStatement instrUpdate = null;

    /*********************************************************************
     * CONSTRUCTEUR
     * @throws SQLException
     * @throws ClassNotFoundException
     ********************************************************************/
    public testBDD(String driver, String url, String user, String pass) throws SQLException, ClassNotFoundException {
        this.DRIVER = new String(driver);
        this.DB_URL = new String(url);
        this.USER = new String(user);
        this.PASS = new String(pass);

        // Charger le driver
        Class.forName(this.DRIVER);

        // Connection DB
        System.out.println("Connexion à la base de données...");
        this.connexion = DriverManager.getConnection(this.DB_URL, this.USER, this.PASS);
        this.instruction = this.connexion.createStatement();

        // Créer des tables de données de test
        System.out.println("Tentative de création de table...");
        this.instruction.executeUpdate("CREATE TABLE IF NOT EXISTS tableTest(id INT NOT NULL AUTO_INCREMENT, nom VARCHAR(10), tatoo INT, naiss DATE, taille DOUBLE, PRIMARY KEY (id))");
    
        // Créer et affecter des droits aux utilisateurs des tables de données de test
        // System.out.println("Tentative de création d'un utilisateur...");
        // this.instruction.executeUpdate("CREATE USER IF NOT EXISTS 'userTest'@'localhost'");
        // this.instruction.executeUpdate("SET password FOR 'userTest'@'localhost' = password('passTest')");
        // this.instruction.executeUpdate("GRANT INSERT, SELECT, UPDATE, DELETE ON baseTest.tableTest TO 'userTest'@'localhost'");

        // Préparer les instructions en écriture
        System.out.println("Préparation des instructions...");
        this.instrInsert = this.connexion.prepareStatement("INSERT INTO tableTest(nom, tatoo, naiss, taille) VALUES (?,?,?,?)");
        this.instrSelect = this.connexion.prepareStatement("SELECT * FROM tableTest");
        this.instrDelete = this.connexion.prepareStatement("DELETE FROM tableTest ORDER BY id DESC LIMIT 1");
        this.instrUpdate = this.connexion.prepareStatement("UPDATE tabletest SET nom=’brouette’ WHERE ID=’1’");
    }

    /***********************************************
     * METHODES
     * @throws SQLException
     ***********************************************/
    // Méthode de connexion à la base de données
    public void connectBDD(String driver, String url, String user, String pass) throws SQLException {
        System.out.println("Connexion à la base de données...");
        this.connexion = DriverManager.getConnection(this.DB_URL, this.USER, this.PASS);
    }

    // Méthode permettant d'ajouter dynamiquement un nouvel élément à la table
    public void selectData() throws SQLException {
        this.resultat = this.instrSelect.executeQuery();
        while (this.resultat.next()) {
            System.out.println("ID = " + this.resultat.getInt("id") + "; Nom = " + this.resultat.getString("nom")
                    + "; Tatoo = " + this.resultat.getInt("tatoo") + "; Naiss. = " + this.resultat.getDate("naiss")
                    + "; Taille = " + this.resultat.getDouble("taille"));
        }
    }
    
    // Méthode permettant d'ajouter dynamiquement un nouvel élément à la table
    public void insertData(String pNom, int pTatoo, Date pNaiss, double pTaille) throws SQLException {
        // Ajouter une entrée à la table de la base de données
        this.instrInsert.setString(1, pNom);
        this.instrInsert.setInt(2, pTatoo);
        this.instrInsert.setDate(3, (java.sql.Date) pNaiss);
        this.instrInsert.setDouble(4, pTaille);
        this.instrInsert.executeUpdate();
    }

    // Méthode permettant de supprimer dynamiquement un élément de la table
    public void deleteData() throws SQLException {
        // Effacer la dernière entrée de la table
        System.out.println("Supression...");
        this.instrDelete.executeUpdate();
    }
    // Méthode permettant de mettre à jour dynamiquement un élément de la table
    public void updateData(String pChamp, String pValeur) throws SQLException {
        // Met à jour la dernière entrée de la table
		System.out.println("Mise à jour...");
		this.instrUpdate.executeUpdate();
	}
}