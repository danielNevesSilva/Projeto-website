package servlet;

import dao.ProductDAO;
import model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
@WebServlet("/product-details")
public class ListProductsDetalisServlet extends HttpServlet {
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            // Recupere o ID do produto da solicitação
            int productId = Integer.parseInt(request.getParameter("id"));

            // Use sua classe DAO para obter o produto pelo ID
            ProductDAO productDAO = new ProductDAO(); // Substitua ProductDAO pelo nome da sua classe DAO
            Product product = null;
            try {
                product = productDAO.getProductById(productId);

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            // Configure o produto como um atributo da solicitação
            request.setAttribute("product", product);

            // Encaminhe a solicitação para a página JSP de detalhes do produto
            request.getRequestDispatcher("Detalhes.jsp").forward(request, response);
        }
    }
