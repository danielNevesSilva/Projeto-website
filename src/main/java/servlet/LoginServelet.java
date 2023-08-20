package servlet;

import dao.FuncionarioDAO;
import model.Funcionario;
import service.AuthenticationService; // Importe a classe AuthenticationService

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServelet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        // Verifique se o email e a senha correspondem usando a classe AuthenticationService
        AuthenticationService authService = new AuthenticationService();
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

        Funcionario user = funcionarioDAO.getFuncionarioByEmail(email);

        if (user != null && authService.verificarSenha(password, user.getPassword())) {
            req.getSession().setAttribute("username", user);
            resp.sendRedirect("index.jps");
        } else {
            req.setAttribute("message", "Credenciais inválidas");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
}
