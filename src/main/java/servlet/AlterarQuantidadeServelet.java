package servlet;

import dao.FuncionarioDAO;
import dao.ProductDAO;
import model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/atualizar-quantidade")
public class AlterarQuantidadeServelet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Obtenha os parâmetros da requisição
            String id = request.getParameter("id");
            String newQuantity = request.getParameter("amount");

            System.out.println(id);
            System.out.println(newQuantity);

            // Atualize o banco de dados com a nova quantidade
            ProductDAO produtoDAO = new ProductDAO();

            Product product = new Product(id, newQuantity);

            produtoDAO.alterarQuantidade(product);

            // Envie uma resposta de sucesso para o frontend
            response.sendRedirect("/products");
        } catch (Exception e) {
            // Em caso de erro, envie uma resposta de erro para o frontend
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.setContentType("application/json");
            response.getWriter().write("{\"message\": \"Erro ao atualizar a quantidade\"}");
        }
    }
}

