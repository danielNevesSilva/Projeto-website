package servlet;

import dao.FuncionarioDAO;
import model.Funcionario;
import service.AuthenticationService;
import service.ValidacaoUsuarios;

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

        ValidacaoUsuarios validacaoUsuarios = new ValidacaoUsuarios();
        AuthenticationService authService = new AuthenticationService();
        String senhaCriptografada = authService.criptografarSenha(password);


        FuncionarioDAO funcionariosDAO = new FuncionarioDAO();
        Funcionario funcionario = new Funcionario(id, nome, email, cpf, senhaCriptografada, funcao);

        if (validacaoUsuarios.emailCadastrado(email)) {
            request.setAttribute("message", "Email já cadastrado");
            request.getRequestDispatcher("index.jsp").forward(request, response);

        } else if (validacaoUsuarios.cpfCadastrado(cpf)){
            request.setAttribute("message", "CPF já cadastrado");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }else {
            request.setAttribute("message", "Usuario cadastrado com sucesso");

            funcionariosDAO.createaccount(funcionario);
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

}
