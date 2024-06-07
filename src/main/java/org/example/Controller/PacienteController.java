package org.example.Controller;

import org.example.DAO.Paciente.PacienteDAOImpl;
import org.example.Model.Paciente.Paciente;

import java.util.List;

public class PacienteController {

    private final PacienteDAOImpl pacienteDAO = new PacienteDAOImpl();

    public void addPaciente(Paciente paciente) {
        pacienteDAO.salvar(paciente);
    }

    public void atualizarPaciente(Paciente paciente) {
        pacienteDAO.atualizar(paciente);
    }

    public void deletarPaciente(int id) {
        pacienteDAO.deletar(id);
    }

    public Paciente getPacientePorId(int id) {
        return pacienteDAO.getById(id);
    }

    public List<Paciente> getAllPacientes() {
        return pacienteDAO.getTodos();
    }

}
