package servlet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import dao.FuncionarioDAO;
@WebServlet("/alterarStatusFuncionario")
public class AlterarStatusFuncionarioServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String idParam = request.getParameter("id");
        String statusParam = request.getParameter("status");

        if (idParam != null) {
            try {
                int id = Integer.parseInt(idParam);
                String novoStatus = statusParam;

                boolean sucesso = FuncionarioDAO.alterarStatusFuncionario(id,novoStatus);

                if (sucesso) {
                    response.getWriter().write("Inativo");
                } else {
                    response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                }
            } catch (NumberFormatException e) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            }
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}

