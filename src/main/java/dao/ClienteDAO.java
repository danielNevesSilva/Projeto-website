package dao;

import config.ConnectionPoolConfig;
import model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class ClienteDAO {
    public void createaccountCliente(Cliente cliente) {

        String SQL = "INSERT INTO CLIENTE (USERNAME,EMAIL,CPF,GENDER,BIRTHDATE,PASSWORD) VALUES (?,?,?,?,?,?)";

        try {
            Connection connection = ConnectionPoolConfig.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, cliente.getUsername());
            preparedStatement.setString(2, cliente.getEmail());
            preparedStatement.setString(3, cliente.getCpf());
            preparedStatement.setString(4, cliente.getGender());
            preparedStatement.setString(5, cliente.getBirthdate());
            preparedStatement.setString(6, cliente.getPassword());


            preparedStatement.execute();
            connection.close();
        } catch (Exception e) {
            System.out.println("fail in connection create" + e);
        }
    }

    public Cliente getClienteByEmail(String email) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cliente cliente = null;

        try {
            conn = ConnectionPoolConfig.getConnection();
            String query = "SELECT * FROM cliente WHERE email = ?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, email);
            rs = stmt.executeQuery();

            if (rs.next()) {
                // Encontrou um cliente com o email fornecido
                // Crie um objeto cliente com os dados do resultado
                cliente = new Cliente();
                cliente.setId(rs.getString("id"));
                cliente.setUsername(rs.getString("username"));
                cliente.setEmail(rs.getString("email"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setGender(rs.getString("gender"));
                cliente.setBirthdate(rs.getString("birthdate"));
                cliente.setPassword(rs.getString("password"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }

        return cliente;
    }
    public Cliente getClienteByCpf(String cpf) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cliente cliente = null;

        try {
            conn = ConnectionPoolConfig.getConnection();
            String query = "SELECT * FROM funcionario WHERE cpf = ?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, cpf);
            rs = stmt.executeQuery();

            if (rs.next()) {
                // Encontrou um funcionário com o email fornecido
                // Crie um objeto Funcionario com os dados do resultado
                cliente = new Cliente();
                cliente.setId(rs.getString("id"));
                cliente.setUsername(rs.getString("username"));
                cliente.setEmail(rs.getString("email"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setGender(rs.getString("gender"));
                cliente.setBirthdate(rs.getString("birthdate"));
                cliente.setPassword(rs.getString("password"));


            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }

        return cliente;
    }

    public void AlterarCliente(Cliente cliente){

        String sql = "UPDATE CLIENTE SET USERNAME=?,PASSWORD=? WHERE ID=?";

        try {
            Connection connection = ConnectionPoolConfig.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, cliente.getUsername());
            preparedStatement.setString(2, cliente.getPassword());
            preparedStatement.setString(4, cliente.getId());

            preparedStatement.execute();

            System.out.println("Sucesso no update");

            connection.close();

        }catch (Exception e){

            System.out.println("Falha conexão banco");
            System.out.println("Error: " + e.getMessage());

        }
    }



}
