package org.example;

import org.example.Controller.ContatoController;
import org.example.Controller.EnderecoController;
import org.example.Controller.PacienteController;
import org.example.Model.Paciente.Contato.Contato;
import org.example.Model.Paciente.Contato.TipoContato;
import org.example.Model.Paciente.Endereco.Cidade;
import org.example.Model.Paciente.Endereco.Endereco;
import org.example.Model.Paciente.Endereco.Uf;
import org.example.Model.Paciente.Paciente;

import java.sql.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//
//        PacienteController pacienteController = new PacienteController();
//        EnderecoController enderecoController = new EnderecoController();
//        ContatoController contatoController = new ContatoController();
//
//        Cidade cidadeExistente = new Cidade();
//        cidadeExistente.setNome("Sao paulo");
//
//        Uf ufExistente = new Uf();
//        ufExistente.setSigla("SP");
//
//        Endereco enderecoExistente = new Endereco();
//        enderecoExistente.setRua("Rua da Laranja");
//        enderecoExistente.setNumero("222");
//        enderecoExistente.setCidade(cidadeExistente);
//        enderecoExistente.getCidade().setUf(ufExistente);
//        enderecoController.addEndereco(enderecoExistente);
//
//        Paciente novoPaciente = new Paciente();
//        novoPaciente.setNome("Marcelo");
//        novoPaciente.setCpf("2212124");
//        novoPaciente.setData_nascimento(Date.valueOf("2003-03-23"));
//        novoPaciente.setEndereco(enderecoExistente);
//
//        Contato novoContato = new Contato();
//        novoContato.setInformacao("6799999");
//
//        TipoContato novoTipoContato = new TipoContato();
//        novoTipoContato.setTipo("telefone");
//
//        novoContato.setTipoContato(novoTipoContato);
//        contatoController.addContato(novoContato);
//        novoPaciente.setContato(novoContato);
//
//        pacienteController.addPaciente(novoPaciente);
//
//        List<Paciente> pacientes = pacienteController.getAllPacientes();
//
//        for (Paciente paciente : pacientes) {
//            System.out.println("---------- Paciente ----------");
//            System.out.println("Nome: " + paciente.getNome());
//            System.out.println("Cpf: " + paciente.getCpf());
//            System.out.println("Data de Nascimento: " + paciente.getData_nascimento());
//            System.out.println("--- Contato ---");
//            System.out.println("Tipo de contato: " + paciente.getContato().getTipoContato().getTipo());
//            System.out.println("Contato: " + paciente.getContato().getInformacao());
//            System.out.println("--- Endereco ---");
//            System.out.println("Estado: " + paciente.getEndereco().getCidade().getUf().getSigla());
//            System.out.println("Cidade: " + paciente.getEndereco().getCidade().getNome());
//            System.out.println("Rua: " + paciente.getEndereco().getRua());
//            System.out.println("Numero: " + paciente.getEndereco().getNumero());
//            System.out.println();
//        }




    }
}
