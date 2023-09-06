package dao;

import config.ConnectionPoolConfig;
import model.Product;

import java.sql.*;
import java.util.*;

public class ProductDAO {

    public void createProduct(Product product) {
        String insertProductSQL = "INSERT INTO produtos (name, price, amount, description) VALUES (?, ?, ?, ?)";

        try (Connection connection = ConnectionPoolConfig.getConnection();
             PreparedStatement productStatement = connection.prepareStatement(insertProductSQL, Statement.RETURN_GENERATED_KEYS)) {

            // Configurar os parâmetros para inserção dos dados do produto
            productStatement.setString(1, product.getName());
            productStatement.setString(2, product.getPrice());
            productStatement.setString(3, product.getAmount());
            productStatement.setString(4, product.getDescription());

            // Executar a inserção do produto
            int affectedRows = productStatement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Falha ao inserir o produto, nenhuma linha afetada.");
            }

            // Obter o ID do produto recém-inserido
            try (ResultSet generatedKeys = productStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int productId = generatedKeys.getInt(1);

                    // Inserir as imagens associadas ao produto
                    insertImagesForProduct(productId, product.getImages());

                    // Atualizar o campo image_paths na tabela produtos com o caminho da imagem principal
                    if (!product.getImages().isEmpty()) {
                        String mainImagePath = product.getImages().get(0); // Assumindo que a primeira imagem é a principal
                        updateProductImagePath(productId, mainImagePath);
                    }
                } else {
                    throw new SQLException("Falha ao obter o ID do produto após a inserção.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Lidar com exceções ou lançar exceções personalizadas, conforme necessário
        }
    }

    private void updateProductImagePath(int productId, String imagePath) {
        String updateImagePathsSQL = "UPDATE produtos SET image_paths = ? WHERE id = ?";

        try (Connection connection = ConnectionPoolConfig.getConnection();
             PreparedStatement updateStatement = connection.prepareStatement(updateImagePathsSQL)) {

            updateStatement.setString(1, imagePath);
            updateStatement.setInt(2, productId);

            // Execute a atualização
            updateStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Lidar com exceções ou lançar exceções personalizadas, conforme necessário
        }
    }

    private void insertImagesForProduct(int productId, List<String> images) {
        String insertImageSQL = "INSERT INTO imagens_produto (produto_id, image_path) VALUES (?, ?)";

        try (Connection connection = ConnectionPoolConfig.getConnection();
             PreparedStatement imageStatement = connection.prepareStatement(insertImageSQL)) {

            for (String imagePath : images) {
                // Configurar os parâmetros para inserção da imagem
                imageStatement.setInt(1, productId);
                imageStatement.setString(2, imagePath);

                // Executar a inserção da imagem
                imageStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Lidar com exceções ou lançar exceções personalizadas, conforme necessário
        }
    }




    public List<Product> selectProducts() {
        String SQL = "SELECT p.id, p.name, p.price, p.amount, GROUP_CONCAT(COALESCE(i.image_path, '')) AS image_paths " +
                "FROM produtos p " +
                "LEFT JOIN imagens_produto i ON p.id = i.produto_id " +
                "GROUP BY p.id, p.name, p.price, p.amount";

        try (Connection connection = ConnectionPoolConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            List<Product> products = new ArrayList<>();

            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                String price = resultSet.getString("price");
                String amount = resultSet.getString("amount");
                String imagePaths = resultSet.getString("image_paths");
                System.out.println("imagePaths antes da divisão: " + imagePaths);

                // Converta a lista de caminhos de imagens em uma lista de strings
                List<String> images = Arrays.asList(imagePaths.split(","));
                System.out.println("Lista de imagens: " + images);

                // Crie o objeto Product com os dados e a lista de caminhos de imagens
                Product product = new Product(id, name, price, amount, images);

                // Adicione o produto à lista
                products.add(product);
            }

            return products;
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
