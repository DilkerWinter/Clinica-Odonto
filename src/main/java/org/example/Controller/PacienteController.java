package org.example.Controller;

import org.example.DAO.PacienteDAO;
import org.example.Model.Paciente.Paciente;

import java.util.List;

public class PacienteController {

    private PacienteDAO pacienteDAO;

    public PacienteController() {
        this.pacienteDAO = new PacienteDAO();
    }

    public List<Paciente> getAllPacientes() {
        return pacienteDAO.getAllPacientes();
    }
}
