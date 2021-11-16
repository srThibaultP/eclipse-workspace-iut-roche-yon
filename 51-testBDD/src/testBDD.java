import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class testBDD {
	
private Connection connexion;

	public testBDD(String driver,String url,String user,String pass) {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			this.connexion = DriverManager.getConnection(url,user,pass);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
/*********************************************** METHODES ***********************************************************/	
	
	public void connectBDD(String driver,String url,String user,String pass) {
		ResultSet resultats = null;
		String requete = "SELECT * FROM basetest";

		try {
		   Statement stmt = this.connexion.createStatement();
		   resultats = stmt.executeQuery(requete);
		} catch (SQLException e) {
		   System.out.println("erreur");
		}
	}

	public void insertData(String pNom,String pTatoo,Date pNaiss,double pTaille) {}
	
	public void deleteData() {};
	
	public void updateData(String pChamp,String pValeur) {};
	
}
