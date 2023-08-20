package dao;

import config.ConnectionPoolConfig;
import model.Funcionario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


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

    public boolean Verificredentials(Funcionario funcionario) {

        String SQL = "SELECT * FROM FUNCIONARIO WHERE EMAIL = ?";

        try{

            Connection connection = ConnectionPoolConfig.getConnection();

            System.out.println("success in database connection");
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, funcionario.getEmail());
            ResultSet resultSet = preparedStatement.executeQuery();

            System.out.println("Success in select Username");

            while (resultSet.next()){
                String Senha = resultSet.getString("PASSWORD");
                if (Senha.equals(funcionario.getPassword())){
                    return true;
                }
            }

            connection.close();
            return false;
        } catch (Exception e){
            System.out.println("Erro: " + e.getMessage());

            return false;
        }
    }

    public Funcionario getFuncionarioByEmail(String email) {

            Connection conn = null;
            PreparedStatement stmt = null;
            ResultSet rs = null;
            Funcionario funcionario = null;

            try {
                conn = ConnectionPoolConfig.getConnection();
                String query = "SELECT * FROM funcionario WHERE email = ?";
                stmt = conn.prepareStatement(query);
                stmt.setString(1, email);
                rs = stmt.executeQuery();

                if (rs.next()) {
                    // Encontrou um funcionário com o email fornecido
                    // Crie um objeto Funcionario com os dados do resultado
                    funcionario = new Funcionario();
                    funcionario.setId(rs.getString("id"));
                    funcionario.setUsername(rs.getString("username"));
                    funcionario.setEmail(rs.getString("email"));
                    funcionario.setCpf(rs.getString("cpf"));
                    funcionario.setPassword(rs.getString("password"));
                }
            } catch (SQLException e) {
                // Trate exceções de banco de dados
                e.printStackTrace();
            } finally {
                // Feche todas as conexões, stmts e rs
                // ...
            }

            return funcionario;
        }

}
