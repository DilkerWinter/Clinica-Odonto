package org.example.Model.Funcionario;

public class Login {

    private String usuario;
    private String senha;
    private Funcionario funcionario;

    public String getUsuario() {
        return usuario;
    }
    //teste
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
}
