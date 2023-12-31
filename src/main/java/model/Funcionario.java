package model;

public class Funcionario {


    private String id;
    private String username;
    private String email;
    private String cpf;
    private String password;
    private String funcao ;
    private String status;



    public Funcionario() {

    }

    public Funcionario(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Funcionario(String id, String username, String email, String cpf, String password, String funcao) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.cpf = cpf;
        this.password = password;
        this.funcao  = funcao ;
    }

    public Funcionario(String id, String username, String email, String funcao, String status) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.funcao  = funcao ;
        this.status = status;
    }

    public Funcionario(String id, String username, String funcao, String status) {
        this.id = id;
        this.username = username;
        this.funcao  = funcao ;
        this.status = status;
    }

    public Funcionario(String id, String username, String email, String cpf, String password, String funcao, String status) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.cpf = cpf;
        this.password = password;
        this.funcao  = funcao ;
        this.status = status;
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

    public String getFuncao() {
        return funcao ;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
