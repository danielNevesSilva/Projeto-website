package servlet;

import dao.ProductDAO;
import model.Product;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import service.FileService;
import service.FormatacaoImage;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.sql.Timestamp;
import java.util.List;


import static org.apache.commons.fileupload.servlet.ServletFileUpload.isMultipartContent;


@WebServlet("/create-product")
@MultipartConfig
public class CreateProductServlet extends HttpServlet {
            @Override
            protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                ProductDAO productDAO = new ProductDAO();

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
                    }
                }

                Product product = new Product(name, description, amount, price, avaliacao);

                String id = productDAO.createProduct(product);

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
                        productDAO.insertImagesForProduct(caminho, imgDefault, id);
                    }
                }
                response.sendRedirect("/products");
            }
        }