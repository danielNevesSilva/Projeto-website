package servlet.Buscar;

import dao.ProductDAO;
import model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/produtos")
public class BuscaProductPrincipalServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("name");

        List<Product> Products = new ProductDAO().pesquisaPrincipal(username);

        request.setAttribute("Products", Products);

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
