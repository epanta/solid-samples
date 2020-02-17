package DIP.Solucao.Interfaces;

import SRP.Solucao.Cliente;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteRepository implements IClienteRepository {

    private DriverManager PostgreSQL;

    public void adicionarCliente (Cliente cliente) {

        try {
            Connection conn = PostgreSQL.getConnection("jdbc:postgresql://127.0.0.1:5432/test");

            String sql = "INSERT INTO CLIENTE (ID, NOME, EMAIL, CPF, DATA_CADASTRO) VALUES (?,?,?,?,?)";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, cliente.getClientId());
            stmt.setString(2, cliente.getNome());
            stmt.setString(3, cliente.getNome());
            stmt.setString(4, cliente.getCPF());
            stmt.setDate(5, (java.sql.Date) cliente.getDataCadastro());
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
