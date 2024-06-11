package org.example.Controller.Consulta;

import org.example.DAO.Consulta.ConsultaDAOImpl;
import org.example.DAO.Consulta.FormaPagamentoDAOImpl;
import org.example.DAO.Consulta.ProntuarioDAOImpl;
import org.example.Model.Consulta.Consulta;
import org.example.Model.Consulta.FormaPagamento;
import org.example.Model.Consulta.Prontuario;
import org.example.Model.Paciente.Contato.Contato;
import org.example.Model.Paciente.Contato.TipoContato;
import org.example.Model.Paciente.Paciente;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class ConsultaController {

    private final ConsultaDAOImpl consultaDAO = new ConsultaDAOImpl();
    private final FormaPagamentoDAOImpl formaPagamentoDAO = new FormaPagamentoDAOImpl();

    public void addConsulta(Consulta consulta) {
        FormaPagamento formaPagamento = formaPagamentoDAO.getByForma(consulta.getFormaPagamento().getForma());
        if (formaPagamento== null) {
            formaPagamentoDAO.salvar(consulta.getFormaPagamento());
        } else {
            consulta.setFormaPagamento(formaPagamento);
        }
        consultaDAO.salvar(consulta);
    }

    public void atualizarConsulta(Consulta consulta) {
        consultaDAO.atualizar(consulta);
    }

    public void deletarConsulta(int id) {
        consultaDAO.deletar(id);
    }

    public Consulta getConsultaPorId(int id) {
        return consultaDAO.getById(id);
    }

    public List<Consulta> getAllConsultas() {
        return consultaDAO.getTodos();
    }

    public List<Consulta> getConsultasPorPaciente(Paciente paciente) {
        return consultaDAO.getConsultaPorPaciente(paciente);
    }

    public List<FormaPagamento> getAllFormaPagamentos() {
        return formaPagamentoDAO.getTodos();
    }

    private static final String URL = "jdbc:postgresql://localhost:5432/desk_p2";
    private static final String USER = "postgres";
    private static final String PASSWORD = "123";

    public Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao conectar com o banco de dados", e);
        }
    }
}
