package servlet;

import dao.FuncionarioDAO;
import model.Funcionario;
import service.AuthenticationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/create-account")
public class CreateCadastroServelet extends HttpServlet {
    @Override

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String nome = request.getParameter("username");
        String email = request.getParameter("email");
        String cpf = request.getParameter("cpf");
        String password = request.getParameter("password");
        String funcao = request.getParameter("funcao");


        AuthenticationService authService = new AuthenticationService();
        String senhaCriptografada = authService.criptografarSenha(password);

        FuncionarioDAO funcionariosDAO = new FuncionarioDAO();
        Funcionario funcionario = new Funcionario(id, nome, email, cpf, senhaCriptografada, funcao);

        if (emailCadastrado(email)) {
            request.setAttribute("message", "Usuario já cadastrado");
            request.getRequestDispatcher("index.jsp").forward(request, response);

        } else {
            request.setAttribute("message", "Usuario cadastrado com sucesso");

            funcionariosDAO.createaccount(funcionario);
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    private boolean emailCadastrado(String email) {
        FuncionarioDAO funcionariosDAO = new FuncionarioDAO();
        Funcionario funcionario = funcionariosDAO.getFuncionarioByEmail(email);

        if (funcionario != null) {
            return true;
            } else {

            return false;
        }
    }
}
