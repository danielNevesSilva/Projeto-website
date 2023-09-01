package servlet;

import dao.FuncionarioDAO;
import model.Funcionario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        String nome = request.getParameter("username");
        String funcao = request.getParameter("funcao");
        String status = request.getParameter("status");

        Funcionario funcionario = new Funcionario(id, nome, funcao, status);

        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

        // funcionarioDAO.update(funcionario);

        response.sendRedirect("/funcionarios");

       }
    }
