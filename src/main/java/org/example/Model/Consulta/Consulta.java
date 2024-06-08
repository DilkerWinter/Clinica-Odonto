    package org.example.Model.Consulta;


    import org.example.Model.Funcionario.Funcionario;
    import org.example.Model.Paciente.Paciente;

    import javax.persistence.*;

    @Entity
    @Table (name = "consulta")
    public class Consulta {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        @Column(name = "observacao")
        private String observacao;

        @ManyToOne
        @JoinColumn(name = "formapagamento", nullable = false)
        private FormaPagamento formaPagamento;

        @Column(name = "valor", nullable = false)
        private Float valor;

        @ManyToOne
        @JoinColumn(name = "funcionario_id", nullable = false)
        private Funcionario funcionario;

        @ManyToOne
        @JoinColumn(name = "paciente_id", nullable = false)
        private Paciente paciente;

        @OneToOne
        @JoinColumn(name = "prontuario", unique = true)
        private Prontuario prontuario;

    }
