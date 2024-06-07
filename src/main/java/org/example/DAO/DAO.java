package org.example.DAO;


import org.example.Model.Paciente.Paciente;

import java.util.List;

public interface DAO {
    void salvar(Paciente paciente);
    void atualizar(Paciente paciente);
    void deletar(int id);
    Paciente getById(int id);
    List<Paciente> getTodos();
}
