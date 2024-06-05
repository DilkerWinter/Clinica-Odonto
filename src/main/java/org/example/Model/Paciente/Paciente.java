package org.example.Model.Paciente;


import org.example.Model.Paciente.Contato.Contato;

import java.sql.Date;

public class Paciente {

    private Integer id;

    private String nome;

    private String cpf;

    private Date datanascimento;

    private Contato contato;





    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDatanascimento() {
        return datanascimento;
    }

    public void setDatanascimento(Date datanascimento) {
        this.datanascimento = datanascimento;
    }

}