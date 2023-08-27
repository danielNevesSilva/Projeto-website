package service;

import dao.FuncionarioDAO;
import model.Funcionario;
import org.mindrot.jbcrypt.BCrypt;
public class AuthenticationService {

    public String criptografarSenha(String password) {
        // Gere um salt
        String salt = BCrypt.gensalt();

        // Criptografe a senha com o salt
        return BCrypt.hashpw(password, salt);
    }

    public boolean verificarSenha(String password, String passwordCriptografada) {
        return BCrypt.checkpw(password, passwordCriptografada);
    }


}
