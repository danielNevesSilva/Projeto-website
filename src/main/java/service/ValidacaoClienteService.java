package service;
import dao.ClienteDAO;
import model.Cliente;

public class ValidacaoClienteService {
    public boolean emailCadastradoCliente(String email) {
        ClienteDAO clienteDAO = new ClienteDAO();
        Cliente cliente = clienteDAO.getClienteByEmail(email);

        if (cliente != null) {
            return true;
        } else {

            return false;
        }
    }

    public boolean cpfCadastradoCliente(String cpf) {
        ClienteDAO clienteDAO = new ClienteDAO();
        Cliente cliente = clienteDAO.getClienteByCpf(cpf);

        if (cliente != null) {
            return true;
        } else {

            return false;
        }
    }
}
