package org.example.Controller.Paciente;

import org.example.DAO.Paciente.Contato.ContatoDAOImpl;
import org.example.DAO.Paciente.Contato.TipoContatoDAOImpl;
import org.example.Model.Paciente.Contato.Contato;
import org.example.Model.Paciente.Contato.TipoContato;

import java.util.List;

public class ContatoController {

    private final ContatoDAOImpl contatoDAO = new ContatoDAOImpl();
    private final TipoContatoDAOImpl tipoContatoDAO = new TipoContatoDAOImpl();

    public void addContato(Contato contato) {
        TipoContato tipoContato = tipoContatoDAO.getByTipo(contato.getTipoContato().getTipo());
        if (tipoContato == null) {
            tipoContatoDAO.salvar(contato.getTipoContato());
        } else {
            contato.setTipoContato(tipoContato);
        }
        contatoDAO.salvar(contato);
    }


    public void atualizarContato(Contato contato) {
        contatoDAO.atualizar(contato);
    }

    public void deletarContato(int id) {
        contatoDAO.deletar(id);
    }

    public Contato buscarContatoPorId(int id) {
        return contatoDAO.getById(id);
    }

    public List<Contato> buscarTodosContatos() {
        return contatoDAO.getTodos();
    }

    public List<TipoContato> getAllTiposContatos() {
        return tipoContatoDAO.getTodos();
    }

}
