package dao;

import config.ConnectionPoolConfig;
import model.Funcionario;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class FuncionarioDAO {

    public void createaccount(Funcionario funcionario) {

        String SQL = "INSERT INTO FUNCIONARIO (USERNAME,EMAIL,CPF,PASSWORD,FUNCAO) VALUES (?,?,?,?,?)";

        try {
            Connection connection = ConnectionPoolConfig.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, funcionario.getUsername());
            preparedStatement.setString(2, funcionario.getEmail());
            preparedStatement.setString(3, funcionario.getCpf());
            preparedStatement.setString(4, funcionario.getPassword());
            preparedStatement.setString(5, funcionario.getFuncao());

            preparedStatement.execute();
            connection.close();
        } catch (Exception e) {
            System.out.println("fail in connection create" + e);
        }
    }

    public List<Funcionario> findAllCadastro() {

        String sql = "SELECT USERNAME, EMAIL, FUNCAO, STATUS FROM FUNCIONARIO";

        try ( Connection connection = ConnectionPoolConfig.getConnection();
              PreparedStatement preparedStatement = connection.prepareStatement(sql);
              ResultSet resultSet = preparedStatement.executeQuery()) {

            List<Funcionario> funcionarios = new ArrayList<>();

            while (resultSet.next()) {
                String username = resultSet.getString("USERNAME");
                String email = resultSet.getString("EMAIL");
                String funcao = resultSet.getString("FUNCAO");
                String status = resultSet.getString("STATUS");

                Funcionario funcionario = new Funcionario(username,email,funcao, status);

                funcionarios.add(funcionario);
            }
            System.out.println("Sucesso in select * FUNCIONARIO");
            connection.close();

            return funcionarios;

        } catch (Exception e) {

            System.out.println("Falha na connection");
            return Collections.emptyList();
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
                    funcionario.setFuncao(rs.getString("funcao"));
                    funcionario.setStatus(rs.getString("status"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
            }

            return funcionario;
        }

}
