package service;

import dao.ClienteDAO;
import dao.FuncionarioDAO;
import model.Cliente;
import model.Funcionario;

public class ValidacaoUsuariosService {
    public boolean emailCadastrado(String email) {
        FuncionarioDAO funcionariosDAO = new FuncionarioDAO();
        Funcionario funcionario = funcionariosDAO.getFuncionarioByEmail(email);

        if (funcionario != null) {
            return true;
        } else {

            return false;
        }
    }

    public boolean cpfCadastrado(String cpf) {
        FuncionarioDAO funcionariosDAO = new FuncionarioDAO();
        Funcionario funcionario = funcionariosDAO.getFuncionarioByCpf(cpf);

        if (funcionario != null) {
            return true;
        } else {

            return false;
        }
    }




}
