package servlet;

import dao.FuncionarioDAO;
import model.Funcionario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/create-account")
public class CreateCadastroServelet extends HttpServlet {
    @Override

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String id = request.getParameter("id");
        String nome = request.getParameter("username");
        String email = request.getParameter("email");
        String cpf = request.getParameter("cpf");
        String password = request.getParameter("password");

        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        Funcionario funcionario= new Funcionario(id,nome,email,cpf,password);

        funcionarioDAO.createaccount(funcionario);
    }

}
