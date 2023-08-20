package model;

public class Funcionario {


    private String id;
    private String username;
    private String email;
    private String cpf;
    private String password;

    public Funcionario(String email, String password){

    }

    public Funcionario(String id, String username, String email, String cpf, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.cpf = cpf;
        this.password = password;
    }

    public Funcionario() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
