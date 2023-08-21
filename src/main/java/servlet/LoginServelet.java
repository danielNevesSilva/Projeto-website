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

        AuthenticationService authService = new AuthenticationService();
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        Funcionario user = funcionarioDAO.getFuncionarioByEmail(email);

        if (user != null && authService.verificarSenha(password, user.getPassword())) {

            String funcao = user.getFuncao(); // Recupere a função do usuário
            String status  = user.getStatus();

            if ("Admin".equals(funcao) && "Ativo".equals(status)) {
                resp.sendRedirect("dashbord.jsp");

            } else if ("Estoquista".equals(funcao) && "Ativo".equals(status)  ) {

                resp.sendRedirect("produtos.jsp");

            } else if("Cliente".equals(funcao)){
                resp.sendRedirect("loginCliente.jsp");
            }
        } else {
            req.setAttribute("message", "Credenciais inválidas ou usuário inativo");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
}
