import java.sql.*;

public class TestaListagem {
    public static void main(String[] args) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection con = connectionFactory.conectarSQL();

        PreparedStatement stm = con.prepareStatement("SELECT * FROM produto");
        stm.execute();


        ResultSet rst = stm.getResultSet();


        while (rst.next()) {
            System.out.printf("-------------------------------\n");
            Integer id = rst.getInt("ID");
            System.out.println(id);
            String nome = rst.getString("NOME");
            System.out.println(nome);
            String descricao = rst.getString("DESCRICAO");
            System.out.println(descricao);

        }

        con.close();

    }
}
