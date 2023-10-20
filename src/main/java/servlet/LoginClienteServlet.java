package servlet;

import dao.ClienteDAO;
import model.Cliente;
import service.AuthenticationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/loginCliente")
public class LoginClienteServlet extends HttpServlet {
    private static final String LOGINCLIENTE_PAGE ="LoginCliente.jsp";
    private static final String NOVIDADES_PAGE = "novidades";
    private static final String ERROR = "error.html";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        req.getRequestDispatcher(LOGINCLIENTE_PAGE).forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
        String email = req.getParameter("email");
        String password = req.getParameter("password");
    try{
        AuthenticationService authService = new AuthenticationService();
        ClienteDAO clienteDAO = new ClienteDAO();
        Cliente user = clienteDAO.getClienteByEmail(email);

        if(user != null && authService.verificarSenha(password, user.getPassword())) {
            HttpSession session = req.getSession(true);
            String tipoUsuario = "Cliente";
            session.setAttribute("clienteLogado", user);
            req.getSession().setAttribute("tipoUsuario", tipoUsuario);
            resp.sendRedirect(NOVIDADES_PAGE);
        }else {
            req.setAttribute("message", "usuario não encontrado");
            req.getRequestDispatcher(LOGINCLIENTE_PAGE).forward(req, resp);
        }
        }catch (Exception e){
            e.printStackTrace();
            req.setAttribute("message","Ocorreu um erro durante o login");
            req.getRequestDispatcher(ERROR).forward(req,resp);
        }
    }
}