package dao;

import config.ConnectionPoolConfig;
import model.Funcionario;
import model.Product;

import java.math.BigDecimal;
import java.sql.*;
import java.util.*;

public class ProductDAO {

    public String createProduct(Product product) {
        String sql = "INSERT INTO produtos (name, price, amount,description, avaliacao) VALUES (?, ?, ?, ?, ?)";

        String productId = null;
        try (Connection connection = ConnectionPoolConfig.getConnection();
             PreparedStatement productStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            // Configurar os parâmetros para inserção dos dados do produto
            productStatement.setString(1, product.getName());
            productStatement.setString(2, product.getPrice());
            productStatement.setString(3, product.getAmount());
            productStatement.setString(4, product.getDescription());
            productStatement.setBigDecimal(5, product.getAvaliacao());


            productStatement.executeUpdate();

            ResultSet generatedKeys = productStatement.getGeneratedKeys();

            if (generatedKeys.next()) {
                productId = generatedKeys.getString(1);
            }

            productStatement.close();
            connection.close();

            System.out.println("Success in insertion");
        } catch (Exception e) {
            System.out.println("Sem sucesso para criar arquivo" + e);
        }
        return productId;
    }

    public void updateProduct(Product product) {
        String updateProductSQL = "UPDATE produtos SET name=?, price=?, amount=?, description=?, avaliacao=? WHERE id=?";

        try (Connection connection = ConnectionPoolConfig.getConnection();
             PreparedStatement productStatement = connection.prepareStatement(updateProductSQL)) {

            // Configurar os parâmetros para a atualização dos dados do produto
            productStatement.setString(1, product.getName());
            productStatement.setString(2, product.getPrice());
            productStatement.setString(3, product.getAmount());
            productStatement.setString(4, product.getDescription());
            productStatement.setBigDecimal(5, product.getAvaliacao());
            productStatement.setString(6, product.getId());

            // Executar a atualização do produto
            int affectedRows = productStatement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Falha ao atualizar o produto, nenhuma linha afetada.");
            }

            // Agora você pode lidar com a atualização das imagens relacionadas ao produto, se necessário.
        } catch (SQLException e) {
            e.printStackTrace();
            // Lidar com exceções ou lançar exceções personalizadas, conforme necessário
        }
    }


    public void insertImagesForProduct(String imgPath, String imgDefault, String id) {
        String sql = "INSERT INTO imagens_produto (image_path, IMAGE_DEFAULT, produto_id) VALUES (?,?,?)";

        try {
            // Verifique se idProduct não está vazio e é um número válido
            if (id != null && !id.isEmpty()) {
                int productId = Integer.parseInt(id);

                Connection connection = ConnectionPoolConfig.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);

                preparedStatement.setString(1, imgPath);
                preparedStatement.setString(2, imgDefault);
                preparedStatement.setInt(3, productId);

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


    public List<Product> selectProducts() {
        String SQL = "SELECT " +
                "    p.id, " +
                "    p.name, " +
                "    p.price, " +
                "    p.amount, " +
                "    p.description, " +
                "    p.avaliacao, " +
                "    p.status, " +
                "    GROUP_CONCAT(COALESCE(i.image_path, '')) AS image_paths " +
                "FROM produtos p " +
                "LEFT JOIN imagens_produto i ON p.id = i.produto_id " +
                "GROUP BY p.id, p.name, p.price, p.amount, p.description, p.avaliacao, p.status " + // Adicione um espaço aqui
                "ORDER BY p.data_inclusao DESC";


        try (Connection connection = ConnectionPoolConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            List<Product> products = new ArrayList<>();

            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                String price = resultSet.getString("price");
                String amount = resultSet.getString("amount");
                String description = resultSet.getString("description");
                BigDecimal avaliacao = resultSet.getBigDecimal("avaliacao");
                String status = resultSet.getString("status");
                String imagePaths = resultSet.getString("image_paths");

                System.out.println();
                // Converta a lista de caminhos de imagens em uma lista de strings
                List<String> images = Arrays.asList(imagePaths.split(","));

                // Crie o objeto Product com os dados e a lista de caminhos de imagens
                Product product = new Product(id, name, price, amount,description,avaliacao, status ,images);

                // Adicione o produto à lista
                products.add(product);
            }

            return products;
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public Product getProductById(int productId) throws SQLException {
        String productSql = "SELECT * FROM produtos WHERE id = ?";
        String imagesSql = "SELECT image_path FROM imagens_produto WHERE produto_id = ?";

        try (Connection connection = ConnectionPoolConfig.getConnection();
             PreparedStatement productStatement = connection.prepareStatement(productSql);
             PreparedStatement imagesStatement = connection.prepareStatement(imagesSql)) {
            productStatement.setInt(1, productId);
            imagesStatement.setInt(1, productId);

            ResultSet productResultSet = productStatement.executeQuery();
            ResultSet imagesResultSet = imagesStatement.executeQuery();

            if (productResultSet.next()) {
                // Recupere os campos do produto do ResultSet
                String id = productResultSet.getString("id");
                String name = productResultSet.getString("name");
                String price = productResultSet.getString("price");
                String amount = productResultSet.getString("amount");
                String description = productResultSet.getString("description");
                String status = productResultSet.getString("status");
                BigDecimal avaliacao = productResultSet.getBigDecimal("avaliacao");
                String image = productResultSet.getString("image_paths");

                // Recupere os caminhos das imagens
                List<String> imagePaths = new ArrayList<>();
                while (imagesResultSet.next()) {
                    String imagePath = imagesResultSet.getString("image_path");
                    imagePaths.add(imagePath);
                }

                // Crie e retorne um objeto Product com base nos dados do ResultSet
                Product product = new Product(id, name, price, amount, description, status, avaliacao, image);
                product.setImagePaths(imagePaths);

                return product;
            }
        }

        return null; // Retorna null se nenhum produto for encontrado com o ID especificado
    }

    public static boolean alterarStatusProduct(int id, String novoStatus) {
        String sql = "UPDATE PRODUTOS SET STATUS = ? WHERE ID = ?";

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

    public void alterarQuantidade(Product product) {
        String sql = "UPDATE PRODUTOS SET AMOUNT = ? WHERE ID = ?";

        try (Connection connection = ConnectionPoolConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            // Configure os parâmetros na ordem correta
            preparedStatement.setInt(1, Integer.parseInt(product.getAmount()));
            preparedStatement.setString(2, product.getId());

            // Execute a atualização
            int rowsAfetadas = preparedStatement.executeUpdate();
            System.out.println("Linhas Afetadas: " + rowsAfetadas);

            System.out.println("Sucesso em update Produtos");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Product> pesquisa(String nome) {
        String sql;
        List<Product> Products = new ArrayList<>();

        if (nome == null || nome.isEmpty()) {
            // Se o nome for nulo ou vazio, retorne todos os produtos
            sql = "SELECT * FROM PRODUTOS";
        } else {
            // Se um nome for fornecido, faça a pesquisa com base no nome
            sql = "SELECT * FROM PRODUTOS WHERE NAME = ?";
        }

        try (Connection connection = ConnectionPoolConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            if (nome != null && !nome.isEmpty()) {
                preparedStatement.setString(1, nome);
            }

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String id = resultSet.getString("ID");
                String username = resultSet.getString("NAME");
                String email = resultSet.getString("AMOUNT");
                String funcao = resultSet.getString("PRICE");
                String status = resultSet.getString("STATUS");

                Product product = new Product(id, username, email, funcao, status);

                Products.add(product);
            }

            System.out.println("Sucesso na consulta de nome FUNCIONARIO");

            resultSet.close();
        } catch (Exception e) {
            System.out.println("Falha na conexão ou na consulta");
            e.printStackTrace(); // Imprima a exceção para depuração
        }

        return Products;
    }
}
