package dao;

import config.ConnectionPoolConfig;
import model.Cliente;
import model.EnderecoEntrega;
import model.Product;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ClienteDAO {
    public String createaccountCliente(Cliente cliente) {
        String SQL = "INSERT INTO CLIENTE (USERNAME, EMAIL, CPF, GENDER, BIRTHDATE, PASSWORD) VALUES (?, ?, ?, ?, ?, ?)";

        String cliente_id = null;

        try (Connection connection = ConnectionPoolConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, cliente.getUsername());
            preparedStatement.setString(2, cliente.getEmail());
            preparedStatement.setString(3, cliente.getCpf());
            preparedStatement.setString(4, cliente.getGender());
            preparedStatement.setString(5, cliente.getBirthdate());
            preparedStatement.setString(6, cliente.getPassword());

            preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();

            if (generatedKeys.next()) {
                cliente_id = generatedKeys.getString(1);
            }

            preparedStatement.close();
            connection.close();

            System.out.println("Success in insertion");

        } catch (SQLException e) {
            System.out.println("Falha na conexão ou execução do SQL: " + e.getMessage());
        }
        return cliente_id;
    }

    public void EnderecoEntrega(EnderecoEntrega enderecoEntrega, String id){
        String SQL = "INSERT INTO ENDERECOENTREGA (cep, rua, numero, bairro, cidade, uf, logradouro, cliente_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            // Verifique se idProduct não está vazio e é um número válido
            if (id != null && !id.isEmpty()) {
                String cliente_id = id;


                Connection connection = ConnectionPoolConfig.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SQL);

                preparedStatement.setString(1, enderecoEntrega.getCep());
                preparedStatement.setString(2, enderecoEntrega.getRua());
                preparedStatement.setString(3, enderecoEntrega.getNumero());
                preparedStatement.setString(4, enderecoEntrega.getBairro());
                preparedStatement.setString(5, enderecoEntrega.getCidade());
                preparedStatement.setString(6, enderecoEntrega.getUf());
                preparedStatement.setString(7, enderecoEntrega.getLogradouro());
                preparedStatement.setString(8, cliente_id);

                preparedStatement.executeUpdate();

                preparedStatement.close();
                connection.close();

                System.out.println("Success in insertion");
            } else {
                System.out.println("idProduct está vazio ou nulo.");
            }
        } catch (NumberFormatException e) {
            System.out.println("idProduct não é um número válido: " + id);
        } catch (SQLException e) {
            System.out.println("Sem sucesso no create: " + e);
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
        }

        return cliente;
    }

    public Cliente getClienteById(int clienteId) throws SQLException {
        String productSql = "SELECT * FROM CLIENTE WHERE id = ?";

        try (Connection connection = ConnectionPoolConfig.getConnection();
             PreparedStatement productStatement = connection.prepareStatement(productSql)) {
            productStatement.setInt(1, clienteId);


            ResultSet productResultSet = productStatement.executeQuery();

            if (productResultSet.next()) {
                String id = productResultSet.getString("id");
                String username = productResultSet.getString("username");
                String email = productResultSet.getString("email");
                String cpf = productResultSet.getString("cpf");
                String gender = productResultSet.getString("gender");
                String birthdate = productResultSet.getString("birthdate");
                String password = productResultSet.getString("password");


                // Crie e retorne um objeto Product com base nos dados do ResultSet
                Cliente cliente = new Cliente(id, username, email, cpf, gender, birthdate, password);

                return cliente;
            }
        }

        return null; // Retorna null se nenhum produto for encontrado com o ID especificado
    }

    public void AlterarCliente(Cliente cliente){

        String sql = "UPDATE CLIENTE SET USERNAME=?,GENDER = ?,BIRTHDATE =?,PASSWORD=? WHERE ID=?";

        try {

            Connection connection = ConnectionPoolConfig.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, cliente.getUsername());
            preparedStatement.setString(2, cliente.getGender());
            preparedStatement.setString(3, cliente.getBirthdate());
            preparedStatement.setString(4, cliente.getPassword());
            preparedStatement.setString(5, cliente.getId());

            preparedStatement.execute();

            System.out.println("Sucesso no update");

            connection.close();

        }catch (Exception e){

            System.out.println("Falha conexão banco");
            System.out.println("Error: " + e.getMessage());

        }
    }


}
