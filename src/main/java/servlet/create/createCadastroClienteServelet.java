package servlet.create;
import dao.ClienteDAO;
import model.Cliente;
import model.EnderecoEntrega;
import service.AuthenticationService;
import service.ValidacaoClienteService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/create-accountcliente")
public class createCadastroClienteServelet extends HttpServlet{

    @Override

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String nome = request.getParameter("username");
        String email = request.getParameter("email");
        String cpf = request.getParameter("cpf");
        String gender = request.getParameter("gender");
        String birthdate = request.getParameter("birthdate");
        String password = request.getParameter("password");

        ValidacaoClienteService ValidacaoClientService = new ValidacaoClienteService();
        AuthenticationService authService = new AuthenticationService();
        String senhaCriptografada = authService.criptografarSenha(password);


        ClienteDAO clienteDAO = new ClienteDAO();
        Cliente cliente = new Cliente(id, nome, email, cpf, gender, birthdate, senhaCriptografada);

        if (id.isBlank()) {

            if (ValidacaoClientService.emailCadastradoCliente(email)) {
                request.setAttribute("message", "Email já cadastrado");
                request.getRequestDispatcher("CadastroCliente.jsp").forward(request, response);

            } else if (ValidacaoClientService.cpfCadastradoCliente(cpf)) {
                request.setAttribute("message", "CPF já cadastrado");
                request.getRequestDispatcher("CadastroCliente.jsp").forward(request, response);
            }
            request.setAttribute("message", "Usuario cadastrado com sucesso");


            String idcliente = clienteDAO.createaccountCliente(cliente);

            String cep = request.getParameter("cep");
            String rua = request.getParameter("rua");
            String numero = request.getParameter("numero");
            String bairro = request.getParameter("bairro");
            String cidade = request.getParameter("cidade");
            String uf = request.getParameter("uf");
            String logradouro = request.getParameter("logradouro");

            EnderecoEntrega enderecoEntrega = new EnderecoEntrega(cep, rua, numero, bairro, cidade, uf, logradouro);
            clienteDAO.EnderecoEntrega(enderecoEntrega, idcliente);

            response.sendRedirect("/loginCliente");
        }
    }
}
