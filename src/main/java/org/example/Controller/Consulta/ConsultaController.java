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
}
