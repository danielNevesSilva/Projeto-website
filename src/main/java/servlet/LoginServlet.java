package servlet;

import dao.FuncionarioDAO;
import model.Funcionario;
import service.AuthenticationService; // Importe a classe AuthenticationService

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final String LOGIN_PAGE = "login.jsp";
    private static final String DASHBOARD_PAGE = "dashboard.jsp";
    private static final String PRODUCTS_PAGE = "produtos.jsp";
    private static final String CLIENT_LOGIN_PAGE = "loginCliente.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(LOGIN_PAGE).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        try {
            AuthenticationService authService = new AuthenticationService();
            FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
            Funcionario user = funcionarioDAO.getFuncionarioByEmail(email);

            HttpSession session = req.getSession();
            int loginAttempts = (int) session.getAttribute("loginAttempts");
            loginAttempts++;

            if (user != null && authService.verificarSenha(password, user.getPassword())) {
                String funcao = user.getFuncao();
                String status = user.getStatus();

                if ("Admin".equals(funcao) && "Ativo".equals(status)) {
                    resp.sendRedirect(DASHBOARD_PAGE);
                    resetLoginAttempts(session); // Redefina as tentativas após o login bem-sucedido
                } else if ("Estoquista".equals(funcao) && "Ativo".equals(status)) {
                    resp.sendRedirect(PRODUCTS_PAGE);
                    resetLoginAttempts(session);
                } else if ("Cliente".equals(funcao)) {
                    resp.sendRedirect(CLIENT_LOGIN_PAGE);
                    resetLoginAttempts(session);
                }
            } else {
                if (loginAttempts >= 3) { // Defina o limite de tentativas malsucedidas aqui
                    // Bloqueie a conta ou execute ação apropriada (por exemplo, enviar um email de alerta)
                }

                req.setAttribute("message", "Credenciais inválidas ou usuário inativo");
                req.getRequestDispatcher(LOGIN_PAGE).forward(req, resp);
                session.setAttribute("loginAttempts", loginAttempts);
            }
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("message", "Ocorreu um erro durante o login.");
            req.getRequestDispatcher(LOGIN_PAGE).forward(req, resp);
        }
    }

    private void resetLoginAttempts(HttpSession session) {
        session.setAttribute("loginAttempts", 0);
    }
}


