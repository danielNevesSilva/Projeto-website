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
public class ListFuncionarios extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (null == req.getSession().getAttribute("nome_cad")) {

            req.setAttribute("Message", "Usuario invalido");

            req.getRequestDispatcher("login.jsp").forward(req, resp);
        } else {

            List<Funcionario> Cadastros = new FuncionarioDAO().findAllCadastro();

            req.setAttribute("Cadastros", Cadastros);

            req.getRequestDispatcher("Dashboard.jsp").forward(req, resp);
        }
    }

}
