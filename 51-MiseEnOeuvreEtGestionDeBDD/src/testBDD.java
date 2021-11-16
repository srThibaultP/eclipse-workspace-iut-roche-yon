import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class testBDD {
    public testBDD(String driver, String url, String user, String pass) throws SQLException {
        try {
            Class.forName(driver);
            java.sql.Connection connection = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void connectBDD(String driver, String url, String user, String pass) {
        
    }

    public void selectData() {}

    public void insertData(String pNom, int pTatoo, Date pNaiss, double pTaille) {}

    public void deleteData() {}
    
    public void updateData(String pChamp, String pValeur) {}

}
