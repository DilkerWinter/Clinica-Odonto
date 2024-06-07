package org.example.Controller.Funcionario;

import org.example.DAO.Funcionario.FuncionarioDAOImpl;
import org.example.DAO.Paciente.Contato.CargoDAOImpl;
import org.example.Model.Funcionario.Cargo;
import org.example.Model.Funcionario.Funcionario;
import org.example.Model.Funcionario.Login;
import org.example.Model.Paciente.Contato.Contato;
import org.example.Model.Paciente.Contato.TipoContato;
import org.example.Model.Paciente.Paciente;
import org.example.Service.PasswordEncrypt;

import java.util.List;

public class FuncionarioController {

    private final FuncionarioDAOImpl funcionarioDAO = new FuncionarioDAOImpl();
    private final CargoDAOImpl cargoDAO = new CargoDAOImpl();

    public void addFuncionario(Funcionario funcionario) {

        Cargo cargo = cargoDAO.getByCargo(funcionario.getCargo().getCargo());
        if (cargo == null) {
            cargoDAO.salvar(funcionario.getCargo());
        } else {
            funcionario.setCargo(cargo);
        }

        funcionario.setSenha(PasswordEncrypt.encrypt(funcionario.getSenha()));

        funcionarioDAO.salvar(funcionario);
    }

    public void atualizarFuncionario(Funcionario funcionario) {
        funcionarioDAO.atualizar(funcionario);
    }

    public void deletarFuncionario(int id) {
        funcionarioDAO.deletar(id);
    }

    public Funcionario getFuncionarioPorId(int id) {
        return funcionarioDAO.getById(id);
    }

    public List<Funcionario> getAllFuncionarios() {
        return funcionarioDAO.getTodos();
    }

    public Funcionario fazerLogin(Login login) {
        return funcionarioDAO.fazerLogin(login);
    }

    public List<Cargo> getAllCargos(){
        return cargoDAO.getTodos();
    }
}
