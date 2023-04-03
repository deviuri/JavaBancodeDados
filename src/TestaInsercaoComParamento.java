import javax.sound.midi.Soundbank;
import java.sql.*;

public class TestaInsercaoComParamento {

    public static void main(String[] args) throws SQLException {
        ConnectionFactory factory = new ConnectionFactory();
        try (Connection con = factory.conectarSQL()) {

            con.setAutoCommit(false);

            try (
                    PreparedStatement stm =
                            con.prepareStatement("insert into produto (nome, descricao) values (?, ?)", Statement.RETURN_GENERATED_KEYS)) {
                adicionarParamento("SmartTV", "45 polegadas", stm);
                adicionarParamento("Radio", "Radio de bateria", stm);

                con.commit();

                stm.close();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("ROLLBACK FOI EXECUTADO");
                con.rollback();
            }
        }
    }

    private static void adicionarParamento(String nome, String descricao, PreparedStatement stm) throws SQLException {
        stm.setString(1, nome);
        stm.setString(2, descricao);
        if (nome.equals("Radio")) {
            throw new RuntimeException("Não foi possivel criar");
        }
        stm.execute();

        try (ResultSet rst = stm.getGeneratedKeys()) {
            while (rst.next()) {
                Integer id = rst.getInt(1);
                System.out.println(id);
            }
        }
    }

}
