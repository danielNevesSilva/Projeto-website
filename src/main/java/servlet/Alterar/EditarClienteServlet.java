package servlet.Alterar;

import dao.ClienteDAO;
import dao.ProductDAO;
import model.Cliente;
import model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet("/editarCliente")
public class EditarClienteServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obter o ID do cliente da solicitação
        int clienteId = Integer.parseInt(request.getParameter("id"));

        // Recuperar o cliente com base no ID (Você pode usar um serviço ou DAO)
        Cliente cliente = null;
        try {
            cliente = new ClienteDAO().getClienteById(clienteId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // Armazenar o cliente na sessão para uso posterior na página de edição
        request.getSession().setAttribute("clienteParaEdicao", cliente);

        // Redirecionar para a página de edição do cliente
        response.sendRedirect("paginaDeEdicaoCliente.jsp");
    }

}