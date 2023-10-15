package servlet.create;


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
        String id = request.getParameter("id");
        String cep = request.getParameter("cep");
        String rua = request.getParameter("rua");
        String numero = request.getParameter("numero");
        String bairro = request.getParameter("bairro");
        String cidade = request.getParameter("cidade");
        String uf = request.getParameter("uf");
        String logradouro = request.getParameter("logradouro");

        EnderecoEntrega enderecoEntrega = new EnderecoEntrega(id,cep, rua, numero, bairro, cidade, uf, logradouro);
        EnderecoEntregaDAO enderecoEntregaDAO = new EnderecoEntregaDAO();
        enderecoEntregaDAO.createEnderecoEntrega(enderecoEntrega);

        response.sendRedirect("/CadastroEnderecoFaturamento.jsp");
    }
}