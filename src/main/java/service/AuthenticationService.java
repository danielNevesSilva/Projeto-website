package service;

import org.mindrot.jbcrypt.BCrypt;
public class AuthenticationService {

    public String criptografarSenha(String senha) {
        // Gere um salt
        String salt = BCrypt.gensalt();

        // Criptografe a senha com o salt
        return BCrypt.hashpw(senha, salt);
    }

    public boolean verificarSenha(String senha, String senhaCriptografada) {
        return BCrypt.checkpw(senha, senhaCriptografada);
    }
}
