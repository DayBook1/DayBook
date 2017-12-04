package com.example.aluno.daybook;



public class Usuario {
    private String login;
    private String senha;

    Usuario(String login, String senha){
        this.login = login;
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean equals(Object obj){
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if(!this.login.equals(other.login) && this.senha.equals(other.senha)){
            return false;
        }
        return true;
    }
}
