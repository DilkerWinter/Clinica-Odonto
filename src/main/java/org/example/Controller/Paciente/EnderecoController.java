package org.example.Controller.Paciente;

import org.example.DAO.Paciente.Endereco.CidadeDAOImpl;
import org.example.DAO.Paciente.Endereco.UfDAOImpl;
import org.example.DAO.Paciente.Endereco.EnderecoDAOImpl;
import org.example.Model.Paciente.Endereco.Cidade;
import org.example.Model.Paciente.Endereco.Endereco;
import org.example.Model.Paciente.Endereco.Uf;

import java.util.List;

public class EnderecoController {

    private final EnderecoDAOImpl enderecoDAO = new EnderecoDAOImpl();
    private final CidadeDAOImpl cidadeDAO = new CidadeDAOImpl();
    private final UfDAOImpl ufDAO = new UfDAOImpl();

    public void addEndereco(Endereco endereco) {
        Uf recebidoUf = ufDAO.getBySigla(endereco.getCidade().getUf().getSigla());
        if (recebidoUf == null) {
            ufDAO.salvar(endereco.getCidade().getUf());
        } else {
            endereco.getCidade().setUf(recebidoUf);
        }

        Cidade recebidaCidade = cidadeDAO.getByNome(endereco.getCidade().getNome());
        if (recebidaCidade == null) {
            cidadeDAO.salvar(endereco.getCidade());
            recebidaCidade = endereco.getCidade();
        }

        endereco.setCidade(recebidaCidade);
        enderecoDAO.salvar(endereco);
    }

    public void atualizarEndereco(Endereco endereco) {
        enderecoDAO.atualizar(endereco);
    }

    public void deletarEndereco(int id) {
        enderecoDAO.deletar(id);
    }

    public Endereco getEnderecoporId(int id) {
        return enderecoDAO.getById(id);
    }

    public List<Endereco> getAllEndereco() {
        return enderecoDAO.getTodos();
    }

    public List<Cidade> getAllCidade() {
        return cidadeDAO.getTodos();
    }

    public List<Uf> getAllUf(){
        return ufDAO.getTodos();
    }

}
