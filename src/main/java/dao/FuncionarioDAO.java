package dao;

import config.ConnectionPoolConfig;
import model.Funcionario;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class FuncionarioDAO {

    public void createaccount(Funcionario funcionario) {

        String SQL = "INSERT INTO FUNCIONARIO (USERNAME,EMAIL,CPF,PASSWORD) VALUES (?,?,?,?)";

        try {
            Connection connection = ConnectionPoolConfig.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, funcionario.getUsername());
            preparedStatement.setString(2, funcionario.getEmail());
            preparedStatement.setString(3, funcionario.getCpf());
            preparedStatement.setString(4, funcionario.getPassword());

            preparedStatement.execute();
            connection.close();
        } catch (Exception e) {
            System.out.println("fail in connection create" + e);
        }
    }

}
