import java.sql.Date;
import java.sql.SQLException;

public class App {

    static testBDD essai;

    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        try {
            essai = new testBDD("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/baseTest?autoReconnect=true&useSSL=false", "adminrtlry", "rtlry");
            essai.connectBDD("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/baseTest?autoReconnect=true&useSSL=false", "usertest", "passTest");
            essai.insertData("Patrouille", 125698, new java.sql.Date(2015, 8, 23), 50.4);
            essai.insertData("Maestro", 4589632, new Date(2005, 10, 4), 32.4);
            essai.insertData("Fripouille", 9823345, new Date(2008, 12, 31), 28.1);
            essai.selectData();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
