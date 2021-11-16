import java.sql.SQLException;

public class main {
    public static void main(String[] args) {
        try {
            testBDD test = new testBDD("com.mysql.jcbd.Driver", "jdbc:mysql://localhost/baseTest", "root", "passTest");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
