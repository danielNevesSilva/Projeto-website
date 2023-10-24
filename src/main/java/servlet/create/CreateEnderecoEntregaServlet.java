/*package servlet.create;

import dao.EnderecoEntregaDAO;
import model.EnderecoEntrega;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/create-endereco-entrega")
public class CreateEnderecoEntregaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String cep = request.getParameter("cep");
        String rua = request.getParameter("rua");
        String numero = request.getParameter("numero");
        String bairro = request.getParameter("bairro");
        String cidade = request.getParameter("cidade");
        String uf = request.getParameter("uf");
        String logradouro = request.getParameter("logradouro");
        String cliente_id = request.getParameter("cliente_id"));

        // Obtém o ID do cliente a partir de algum lugar
        // Vamos supor que você tenha um método para obter o ID do cliente
        String clienteId = metodoParaObterIdDoCliente(request);

        EnderecoEntrega enderecoEntrega = new EnderecoEntrega(cep, rua, numero, bairro, cidade, uf, logradouro);

        EnderecoEntregaDAO enderecoEntregaDAO = new EnderecoEntregaDAO();
        enderecoEntregaDAO.createEnderecoEntrega(enderecoEntrega);

        response.sendRedirect("/CadastroEnderecoEntrega.jsp");
    }

    // Adicione um método para obter o ID do cliente
    // Obtém o ID do cliente a partir de uma solicitação HTTP
    private String metodoParaObterIdDoCliente(HttpServletRequest request) {
        String cliente_id = request.getParameter("cliente_id");
        return cliente_id;
    }

}*/
