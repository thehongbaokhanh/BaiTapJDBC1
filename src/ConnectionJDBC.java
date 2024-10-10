import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionJDBC {

    private String url = "jdbc:mysql://localhost:3306/product_manager_database";
    private String username = "root";
    private String password = "khanhanhanmiu";

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Kết nối thành công");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
