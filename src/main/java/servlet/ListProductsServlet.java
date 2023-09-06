package servlet;

import dao.ProductDAO;
import model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/products")
public class ListProductsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Product> Products = new ProductDAO().selectProducts();
        for (Product product : Products) {
            System.out.println("Produto ID: " + product.getId());
            System.out.println("Imagens: " + product.getImages());
        }

        req.setAttribute("Products", Products);

        req.getRequestDispatcher("Produtos.jsp").forward(req, resp);
    }
}
