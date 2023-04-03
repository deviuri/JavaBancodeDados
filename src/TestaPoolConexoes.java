import java.sql.SQLException;

public class TestaPoolConexoes {
    public static void main(String[] args) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();

        for (int i = 0; i < 2000; i++) {
            connectionFactory.conectarSQL();
            System.out.println("Número de conecxão:  " + i);
        }
    }
}
