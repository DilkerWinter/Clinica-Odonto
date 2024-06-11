package org.example.Controller.Consulta;

import org.example.DAO.Consulta.AgendamentoDAOImpl;
import org.example.DAO.Consulta.ProntuarioDAOImpl;
import org.example.Model.Consulta.Agendamento;
import org.example.Model.Consulta.Prontuario;
import org.example.Model.Paciente.Paciente;

import java.util.List;

public class AgendamentoController {

    private final AgendamentoDAOImpl agendamentoDAO = new AgendamentoDAOImpl();

    public void addAgendamento(Agendamento agendamento) {
        agendamentoDAO.salvar(agendamento);
    }

    public void atualizarAgendamento(Agendamento agendamento) {
        agendamentoDAO.atualizar(agendamento);
    }

    public void deletarAgendamento(int id) {
        agendamentoDAO.deletar(id);
    }

    public Agendamento getAgendamentoPorId(int id) {
        return agendamentoDAO.getById(id);
    }

    public List<Agendamento> getAllAgendamentos() {
        return agendamentoDAO.getTodos();
    }

    public List<Agendamento> getAgendamentosPorPaciente(Paciente paciente) {
        return agendamentoDAO.getAgendamentosPorPaciente(paciente);
    }
}
