import DAO.ProdutoDAO;
import modelo.Produto;

import java.sql.*;
import java.util.List;

public class TestaInsercaoEListagemComProduto {
    public static void main(String[] args) throws SQLException {
        Produto comoda = new Produto("Cômoda", "Cômoda Vertical");

        try (Connection connection = new ConnectionFactory().conectarSQL()) {
            ProdutoDAO produtoDAO = new ProdutoDAO(connection);
            produtoDAO.salvarProdutor(comoda);
            List<Produto> listaDeProduto = produtoDAO.listar();
            listaDeProduto.stream().forEach(lp -> System.out.println(lp));
        }
    }
}
