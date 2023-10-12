package model;

public class Cliente {

    private String id;
    private String username;
    private String email;
    private String cpf;
    private String gender;
    private String password;


public Cliente(){

}

public Cliente(String id, String username, String email, String cpf,String gender, String password) {
    this.id = id;
    this.username = username;
    this.email = email;
    this.cpf = cpf;
    this.gender = gender;
    this.password = password;

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}