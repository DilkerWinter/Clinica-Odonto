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

        @OneToOne(cascade = CascadeType.PERSIST)
        @JoinColumn(name = "prontuario_id", unique = true)
        private Prontuario prontuario;


        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getObservacao() {
            return observacao;
        }

        public void setObservacao(String observacao) {
            this.observacao = observacao;
        }

        public FormaPagamento getFormaPagamento() {
            return formaPagamento;
        }

        public void setFormaPagamento(FormaPagamento formaPagamento) {
            this.formaPagamento = formaPagamento;
        }

        public Float getValor() {
            return valor;
        }

        public void setValor(Float valor) {
            this.valor = valor;
        }

        public Funcionario getFuncionario() {
            return funcionario;
        }

        public void setFuncionario(Funcionario funcionario) {
            this.funcionario = funcionario;
        }

        public Paciente getPaciente() {
            return paciente;
        }

        public void setPaciente(Paciente paciente) {
            this.paciente = paciente;
        }

        public Prontuario getProntuario() {
            return prontuario;
        }

        public void setProntuario(Prontuario prontuario) {
            this.prontuario = prontuario;
        }
    }
