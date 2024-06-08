package org.example.Model.Consulta;

import org.example.Model.Funcionario.Funcionario;
import org.example.Model.Paciente.Paciente;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "agendamento")
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "data", nullable = false)
    private Date data;

    @Column(name = "horario", nullable = false)
    private Date horario;

    @ManyToOne
    @JoinColumn(name = "funcionario_id", nullable = false)
    private Funcionario funcionario;

    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;

}
