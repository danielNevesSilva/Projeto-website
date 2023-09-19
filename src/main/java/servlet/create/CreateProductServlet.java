package servlet.create;

import dao.ProductDAO;
import model.Product;
import service.FileService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.SQLException;


import static org.apache.commons.fileupload.servlet.ServletFileUpload.isMultipartContent;


@WebServlet("/create-product")
@MultipartConfig
public class CreateProductServlet extends HttpServlet {
            @Override
            protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                String id = request.getParameter("id");
                ProductDAO productDAO = new ProductDAO();
                Product existingProduct = null;

                if (id != null && !id.isEmpty()) {
                    // Se o ID estiver presente, carregue o produto existente
                    int productId = Integer.parseInt(id);
                    try {
                        existingProduct = productDAO.getProductById(productId);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }

                    if (existingProduct == null) {
                        // Lide com o caso em que o produto não foi encontrado
                    } else {
                        // Atualize os dados do produto existente com base no formulário
                        existingProduct.setName(request.getParameter("name"));
                        existingProduct.setDescription(request.getParameter("description"));
                        existingProduct.setAmount(request.getParameter("amount"));
                        existingProduct.setPrice(request.getParameter("price"));

                        String ratingParam = request.getParameter("rating");

                        if (ratingParam != null && !ratingParam.isEmpty()) {
                            try {
                                BigDecimal avaliacao = new BigDecimal(ratingParam);
                                existingProduct.setAvaliacao(avaliacao);
                            } catch (NumberFormatException e) {
                                // Lide com erros de conversão de avaliação
                            }
                        }

                        // Atualize o produto no banco de dados
                        productDAO.updateProduct(existingProduct);
                        productDAO.deleteImagesForProduct(existingProduct.getId());

                        // Agora, faça a associação de imagens ao produto existente
                        String nameImgDefault = request.getParameter("selectedImage");

                        for (Part newfile : request.getParts()) {
                            if (newfile.getName().equals("images[]")) {
                                String imgDefault;
                                InputStream arquivoCarregado = newfile.getInputStream();
                                FileService arquivo = new FileService();
                                String caminho = arquivo.upload("src/main/webapp/img", newfile, arquivoCarregado);
                                String nomeImg = arquivo.nomeArquivoOriginal(newfile);
                                System.out.println(nomeImg + " Nome original");

                                if (nomeImg.equals(nameImgDefault)) {
                                    imgDefault = "yes";
                                } else {
                                    imgDefault = "no";
                                }

                                // Verifique se a imagem já está associada ao produto antes de inseri-la novamente
                                if (!productDAO.isImageAssociatedWithProduct(existingProduct.getId(), caminho)) {
                                    productDAO.insertImagesForProduct(caminho, imgDefault, existingProduct.getId());
                                }
                            }
                        }
                    }
                } else {
                    // Se o ID estiver em branco, crie um novo produto
                    String name = request.getParameter("name");
                    String description = request.getParameter("description");
                    String amount = request.getParameter("amount");
                    String price = request.getParameter("price");
                    BigDecimal avaliacao = null;

                    String ratingParam = request.getParameter("rating");

                    if (ratingParam != null && !ratingParam.isEmpty()) {
                        try {
                            avaliacao = new BigDecimal(ratingParam);
                        } catch (NumberFormatException e) {
                            // Lide com erros de conversão de avaliação
                        }
                    }

                    Product product = new Product(name, description, amount, price, avaliacao);

                    String idProduct = productDAO.createProduct(product);

                    String nameImgDefault = request.getParameter("selectedImage");
                    System.out.println(nameImgDefault);

                    for (Part newfile : request.getParts()) {
                        if (newfile.getName().equals("images[]")) {
                            String imgDefault;
                            InputStream arquivoCarregado = newfile.getInputStream();
                            FileService arquivo = new FileService();
                            String caminho = arquivo.upload("src/main/webapp/img", newfile, arquivoCarregado);
                            String nomeImg = arquivo.nomeArquivoOriginal(newfile);
                            System.out.println(nomeImg + " Nome original");

                            if (nomeImg.equals(nameImgDefault)) {
                                imgDefault = "yes";
                            } else {
                                imgDefault = "no";
                            }
                            System.out.println(imgDefault);
                            productDAO.insertImagesForProduct(caminho, imgDefault, idProduct);
                        }
                    }
                }
                response.sendRedirect("/products");
            }
        }