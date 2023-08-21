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

@WebServlet("/funcionarios")
public class ListFuncionariosServelet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


            List<Funcionario> funcionarios = new FuncionarioDAO().findAllCadastro();

            req.setAttribute("funcionarios", funcionarios);

            req.getRequestDispatcher("funcionarios.jsp").forward(req, resp);

    }

}
