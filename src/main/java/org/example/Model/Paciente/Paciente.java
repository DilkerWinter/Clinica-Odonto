package org.example.Model.Paciente;


import org.example.Model.Paciente.Contato.Contato;
import org.example.Model.Paciente.Endereco.Endereco;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "paciente")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column(unique = true, nullable = false)
    private String cpf;

    @Column(name = "datanascimento", nullable = false)
    private Date data_nascimento;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "contato", referencedColumnName = "id")
    private Contato contato;


    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "endereco", referencedColumnName = "id")
    private Endereco endereco;

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

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}