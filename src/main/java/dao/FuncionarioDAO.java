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

    public List<Funcionario> pesquisa(String nome){

        String sql = "SELECT * FROM FUNCIONARIO WHERE USERNAME = ?";

        try (
                Connection connection = ConnectionPoolConfig.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {
            preparedStatement.setString(1, nome); // Define o valor do parâmetro para o nome

            ResultSet resultSet = preparedStatement.executeQuery();

            List<Funcionario> funcionarios = new ArrayList<>();

            while (resultSet.next()) {
                String id = resultSet.getString("ID");
                String username = resultSet.getString("USERNAME");
                String funcao = resultSet.getString("FUNCAO");
                String status = resultSet.getString("STATUS");

                Funcionario funcionario = new Funcionario(id, username, funcao, status);

                funcionarios.add(funcionario);
            }

            System.out.println("Sucesso na consulta de nome FUNCIONARIO");

            resultSet.close();
            connection.close();

            return funcionarios;

        } catch (Exception e) {

            System.out.println("Falha na conexão ou na consulta");
            e.printStackTrace(); // Imprima a exceção para depuração
            return Collections.emptyList();
        }
    }


    public List<Funcionario> findAllCadastro() {

        String sql = "SELECT ID, USERNAME, EMAIL, FUNCAO, STATUS FROM FUNCIONARIO";

        try ( Connection connection = ConnectionPoolConfig.getConnection();
              PreparedStatement preparedStatement = connection.prepareStatement(sql);
              ResultSet resultSet = preparedStatement.executeQuery()) {

            List<Funcionario> funcionarios = new ArrayList<>();

            while (resultSet.next()) {
                String id = resultSet.getString("ID");
                String username = resultSet.getString("USERNAME");
                String email = resultSet.getString("EMAIL");
                String funcao = resultSet.getString("FUNCAO");
                String status = resultSet.getString("STATUS");

                Funcionario funcionario = new Funcionario(id, username,email,funcao, status);

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
    public Funcionario getFuncionarioByCpf(String cpf) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Funcionario funcionario = null;

        try {
            conn = ConnectionPoolConfig.getConnection();
            String query = "SELECT * FROM funcionario WHERE cpf = ?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, cpf);
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

    public void update(Funcionario funcionario){

        String sql = "UPDATE FUNCIONARIO SET USERNAME=?,  FUNCAO=?, STATUS=? WHERE ID=?";

        try {
            Connection connection = ConnectionPoolConfig.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, funcionario.getUsername());
            preparedStatement.setString(2, funcionario.getFuncao());
            preparedStatement.setString(3, funcionario.getStatus());
            preparedStatement.setString(4, funcionario.getId());

            preparedStatement.execute();

            System.out.println("Sucesso no update");

            connection.close();

        }catch (Exception e){

            System.out.println("Falha conexão banco");
            System.out.println("Error: " + e.getMessage());

        }
    }

    public static boolean alterarStatusFuncionario(int id, String novoStatus) {
        String sql = "UPDATE FUNCIONARIO SET STATUS = ? WHERE ID = ?";

        try (Connection connection = ConnectionPoolConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, novoStatus);
            preparedStatement.setInt(2, id);

            int rowsAfetadas = preparedStatement.executeUpdate();

            return rowsAfetadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

