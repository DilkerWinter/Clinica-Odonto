package org.example.DAO;


import org.example.Model.Paciente.Paciente;

import java.util.List;

public interface DAO<T> {
    void salvar(T t);
    void atualizar(T t);
    void deletar(int id);
    T getById(int id);
    List<T> getTodos();
}
