/*package dao;

import config.ConnectionPoolConfig;
import model.EnderecoEntrega;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EnderecoEntregaDAO {

    public void createEnderecoEntrega(EnderecoEntrega endereco) {
        String SQL = "INSERT INTO ENDERECOENTREGA (cep, rua, numero, bairro, cidade, uf, logradouro, cliente_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = ConnectionPoolConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {



            preparedStatement.setString(1, endereco.getCep());
            preparedStatement.setString(2, endereco.getRua());
            preparedStatement.setString(3, endereco.getNumero());
            preparedStatement.setString(4, endereco.getBairro());
            preparedStatement.setString(5, endereco.getCidade());
            preparedStatement.setString(6, endereco.getUf());
            preparedStatement.setString(7, endereco.getLogradouro());
            preparedStatement.setInt(8, endereco.getCliente_id());

            preparedStatement.executeUpdate();

            System.out.println("Success in insertion");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}*/