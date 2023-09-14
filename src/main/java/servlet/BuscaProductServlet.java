package servlet;

import dao.FuncionarioDAO;
import dao.ProductDAO;
import model.Funcionario;
import model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/filtrar-produtos")
public class BuscaProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("name");


        List<Product> Products = new ProductDAO().pesquisa(username);

        request.setAttribute("Products", Products);

        request.getRequestDispatcher("Produtos.jsp").forward(request, response);
    }
}
