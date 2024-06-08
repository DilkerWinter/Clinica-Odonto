package org.example.Model.Consulta;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class FormaPagamento {

    @Id
    @Column(name = "forma", unique = true, nullable = false)
    private String forma;
}
