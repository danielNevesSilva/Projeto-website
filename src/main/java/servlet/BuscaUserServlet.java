package servlet;

import dao.FuncionarioDAO;
import model.Funcionario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/filtrar-funcionarios")
public class BuscaUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");

        List<Funcionario> funcionarios = new FuncionarioDAO().pesquisa(username);

        request.setAttribute("funcionarios", funcionarios);
        request.getRequestDispatcher("funcionarios.jsp").forward(request, response);
    }
}
