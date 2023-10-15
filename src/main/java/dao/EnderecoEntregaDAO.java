package dao;

import config.ConnectionPoolConfig;
import model.EnderecoEntrega;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class EnderecoEntregaDAO {
    public void createEnderecoEntrega(EnderecoEntrega endereco) {
        String SQL = "INSERT INTO ENDERECOENTREGA (cep, rua, numero, bairro, cidade, uf, logradouro) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            Connection connection = ConnectionPoolConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, endereco.getCep());
            preparedStatement.setString(2, endereco.getRua());
            preparedStatement.setString(3, endereco.getNumero());
            preparedStatement.setString(4, endereco.getBairro());
            preparedStatement.setString(5, endereco.getCidade());
            preparedStatement.setString(6, endereco.getUf());
            preparedStatement.setString(7, endereco.getLogradouro());





            preparedStatement.execute();
            connection.close();
        } catch (Exception e) {
            System.out.println("fail in connection create" + e);
        }
    }
}