package org.example.Model.Consulta;

import javax.persistence.*;

@Entity
@Table(name = "prontuario")
public class Prontuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "descricao",nullable = false)
    private String descricao;



}
