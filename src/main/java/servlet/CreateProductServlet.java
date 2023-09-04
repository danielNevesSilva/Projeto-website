package servlet;

import dao.ProductDAO;
import model.Product;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import service.FormatacaoImage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.sql.Timestamp;


import static org.apache.commons.fileupload.servlet.ServletFileUpload.isMultipartContent;


@WebServlet("/create-product")
public class CreateProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Verifique se o formulário possui o atributo enctype="multipart/form-data"
        if (ServletFileUpload.isMultipartContent(req)) {
            try {
                // Configure a fábrica de itens de arquivo e o analisador
                DiskFileItemFactory factory = new DiskFileItemFactory();
                ServletFileUpload upload = new ServletFileUpload(factory);

                // Parse o formulário para obter os campos e arquivos enviados
                List<FileItem> items = upload.parseRequest(req);

                // Crie objetos para armazenar informações do produto e imagens
                Product product = new Product();
                List<String> imagePaths = new ArrayList<>();
                String contextPath = req.getContextPath(); // Obtém o contexto do aplicativo web

                for (FileItem item : items) {
                    if (item.isFormField()) {
                        // Processar campos de texto (não imagens)
                        String fieldName = item.getFieldName();
                        String fieldValue = item.getString("UTF-8"); // Certifique-se de ajustar a codificação corretamente

                        if ("name".equals(fieldName)) {
                            product.setName(fieldValue);
                        } else if ("description".equals(fieldName)) {
                            product.setDescription(fieldValue);
                        } else if ("amount".equals(fieldName)) {
                            product.setAmount(fieldValue);
                        } else if ("price".equals(fieldName)) {
                            product.setPrice(fieldValue);
                        }
                    } else {
                        // Processar campos de arquivo (imagens)
                        String fileName = item.getName();
                        if (fileName != null && !fileName.isEmpty()) {
                            // Gere um nome único para a imagem
                            String uniqueFileName = generateUniqueFileName(fileName);

                            // Salve a imagem no servidor
                            String imagePath = saveImageToFileSystem(item, uniqueFileName);

                            // Adicione o contexto ao caminho da imagem
                            String imagePathWithContext = contextPath + "/img/" + uniqueFileName;

                            // Adicione o caminho da imagem à lista
                            product.getImages().add(imagePathWithContext);
                        }
                    }
                }

                ProductDAO productDAO = new ProductDAO();
                productDAO.createProduct(product);

                // Redirecione para a página de listagem de produtos ou outra página relevante
                resp.sendRedirect("/products");
            } catch (Exception e) {
                e.printStackTrace();
                resp.sendRedirect("error.html"); // Trate erros adequadamente
            }
        }
    }

    // Método para gerar um nome de arquivo único
        private String generateUniqueFileName (String originalFileName){
            String uniqueFileName = null;
            try {
                // Obtenha a extensão do arquivo original
                String fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));

                // Crie um nome único com base na data e hora atual
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
                String timestamp = sdf.format(new Date());

                // Combine o timestamp e a extensão do arquivo para obter um nome único
                uniqueFileName = timestamp + fileExtension;
            } catch (Exception e) {
                e.printStackTrace();
            }

            return uniqueFileName;
        }

// Método para salvar a imagem no sistema de arquivos do servidor
            private String saveImageToFileSystem (FileItem item, String fileName) throws Exception {
                String imagePath = null;
                try {
                    // Defina o diretório onde deseja salvar as imagens
                    // Obtenha o caminho real para o diretório raiz da aplicação
                    String rootPath = getServletContext().getRealPath("/");
                    String uploadDirectory = rootPath + "img/";

                    // Crie o caminho completo do arquivo
                    imagePath = uploadDirectory + fileName;

                    // Crie um objeto File para representar o arquivo no sistema de arquivos
                    File imageFile = new File(imagePath);

                    // Salve o arquivo
                    item.write(imageFile);
                } catch (Exception e) {
                    e.printStackTrace();
                    throw e; // Relance a exceção para tratamento posterior
                }

                return imagePath;
            }
    }
