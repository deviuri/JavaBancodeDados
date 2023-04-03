import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestSQL {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost/JavaDB?useTimezone=true&serverTimezone=UTC",
                "root",
                "4321");
        connection.close();
    }
}
