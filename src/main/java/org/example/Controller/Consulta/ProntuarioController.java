package org.example.Controller.Consulta;

import org.example.DAO.Consulta.ProntuarioDAOImpl;
import org.example.DAO.Paciente.PacienteDAOImpl;
import org.example.Model.Consulta.Prontuario;
import org.example.Model.Paciente.Paciente;

import java.util.List;

public class ProntuarioController {

    private final ProntuarioDAOImpl prontuarioDAO = new ProntuarioDAOImpl();

    public void addProntuario(Prontuario prontuario) {
        prontuarioDAO.salvar(prontuario);
    }

    public void atualizarProntuario(Prontuario prontuario) {
        prontuarioDAO.atualizar(prontuario);
    }

    public void deletarProntuario(int id) {
        prontuarioDAO.deletar(id);
    }

    public Prontuario getProntuarioPorId(int id) {
        return prontuarioDAO.getById(id);
    }

    public List<Prontuario> getAllProntuarios() {
        return prontuarioDAO.getTodos();
    }

    public List<Prontuario> getProntuariosPorPaciente(Paciente paciente) {
        return prontuarioDAO.getProntuarioPorPaciente(paciente);
    }
}
