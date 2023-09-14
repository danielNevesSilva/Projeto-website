package servlet;

import dao.FuncionarioDAO;
import model.Funcionario;
import service.AuthenticationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final String LOGIN_PAGE = "index.jsp";
    private static final String DASHBOARD_PAGE = "dashboard.jsp";
    private static final String PRODUCTS_PAGE = "CadastroProduto.jsp";
    private static final String CLIENT_LOGIN_PAGE = "loginCliente.jsp";

    private static final String ERROR = "error.html";

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


            if (user != null && authService.verificarSenha(password, user.getPassword())) {
                String funcao = user.getFuncao();
                String status = user.getStatus();

                if ("Admin".equals(funcao) && "Ativo".equals(status)) {
                    String tipoUsuario = "Admin";
                    req.getSession().setAttribute("tipoUsuario", tipoUsuario);
                    resp.sendRedirect(DASHBOARD_PAGE);
                } else if ("Estoquista".equals(funcao) && "Ativo".equals(status)) {
                    String tipoUsuario = "Estoquista";
                    req.getSession().setAttribute("tipoUsuario", tipoUsuario);
                    resp.sendRedirect(DASHBOARD_PAGE);
                    String quantidade = req.getParameter("amount");
                } else if ("Cliente".equals(funcao)) {
                    resp.sendRedirect(CLIENT_LOGIN_PAGE);
                } else if ("Inativo".equals(status)){
                    req.setAttribute("message", "usuário inativo");
                    req.getRequestDispatcher(LOGIN_PAGE).forward(req, resp);
                }

            } else {

                req.setAttribute("message", "Credenciais inválidas");
                req.getRequestDispatcher(LOGIN_PAGE).forward(req, resp);

            }
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("message", "Ocorreu um erro durante o login.");
            req.getRequestDispatcher(LOGIN_PAGE).forward(req, resp);
        }
    }



}


