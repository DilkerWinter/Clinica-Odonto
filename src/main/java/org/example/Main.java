package org.example;

import org.example.Controller.Consulta.AgendamentoController;
import org.example.Controller.Consulta.ConsultaController;
import org.example.Controller.Funcionario.FuncionarioController;
import org.example.Controller.Paciente.ContatoController;
import org.example.Controller.Paciente.EnderecoController;
import org.example.Controller.Paciente.PacienteController;
import org.example.Model.Consulta.Agendamento;
import org.example.Model.Consulta.Consulta;
import org.example.Model.Consulta.FormaPagamento;
import org.example.Model.Consulta.Prontuario;
import org.example.Model.Funcionario.Cargo;
import org.example.Model.Funcionario.Funcionario;
import org.example.Model.Paciente.Contato.Contato;
import org.example.Model.Paciente.Contato.TipoContato;
import org.example.Model.Paciente.Endereco.Cidade;
import org.example.Model.Paciente.Endereco.Endereco;
import org.example.Model.Paciente.Endereco.Uf;
import org.example.Model.Paciente.Paciente;
import org.example.Telas.TelaLogin;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        TelaLogin telaLogin = new TelaLogin();
        telaLogin.setVisible(true);

//PACIENTE
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
//
//FUNCIONARIOS
//        FuncionarioController funcionarioController = new FuncionarioController();
//        Funcionario novoFuncionario = new Funcionario();
//
//        novoFuncionario.setNome("Bruno");
//        novoFuncionario.setUsuario("bruno");
//        novoFuncionario.setSenha("123");
//        Cargo novoCargo = new Cargo();
//
//        novoCargo.setCargo("Funcionario");
//        novoFuncionario.setCargo(novoCargo);
//       funcionarioController.addFuncionario(novoFuncionario);


//AGENDAMENTO
//        PacienteController pacienteController = new PacienteController();
//        Paciente novoPaciente = pacienteController.getPacientePorId(17);
//        FuncionarioController funcionarioController = new FuncionarioController();
//        Funcionario novoFuncionario = funcionarioController.getFuncionarioPorId(19);
//        AgendamentoController agendamentoController = new AgendamentoController();
//
//        Agendamento novoAgendamento = new Agendamento();
//        novoAgendamento.setFuncionario(novoFuncionario);
//        novoAgendamento.setPaciente(novoPaciente);
//        novoAgendamento.setData(Date.valueOf("2024-06-10")); // Correção aqui
//        novoAgendamento.setHorario(Time.valueOf("10:00:00"));
//        agendamentoController.addAgendamento(novoAgendamento);
//
//        List<Agendamento> agendamentos = agendamentoController.getAllAgendamentos();
//
//        for (Agendamento agendamento : agendamentos) {
//            System.out.println("---------- Agendamento ----------");
//            System.out.println("Data: " + agendamento.getData());
//            System.out.println("Horario: " + agendamento.getHorario());
//            System.out.println("--- Funcionario ---");
//            System.out.println("Nome: " + agendamento.getFuncionario().getNome());
//            System.out.println("Cargo: " + agendamento.getFuncionario().getCargo().getCargo());
//            System.out.println("--- Paciente ---");
//            System.out.println("Nome: " + agendamento.getPaciente().getNome());
//            System.out.println("CPF: " + agendamento.getPaciente().getCpf());
//            System.out.println("--- Endereco ---");
//            System.out.println("Estado: " + agendamento.getPaciente().getEndereco().getCidade().getUf().getSigla());
//            System.out.println("Cidade: " + agendamento.getPaciente().getEndereco().getCidade().getNome());
//            System.out.println("Rua: " + agendamento.getPaciente().getEndereco().getRua());
//            System.out.println("Numero: " + agendamento.getPaciente().getEndereco().getNumero());
//            System.out.println();
//        }

//CONSULTA
//        Consulta novaConsulta = new Consulta();
//
//        PacienteController pacienteController = new PacienteController();
//        Paciente novoPaciente = pacienteController.getPacientePorId(17);
//        FuncionarioController funcionarioController = new FuncionarioController();
//        Funcionario novoFuncionario = funcionarioController.getFuncionarioPorId(19);
//
//        novaConsulta.setPaciente(novoPaciente);
//        novaConsulta.setFuncionario(novoFuncionario);
//
//        FormaPagamento novaFormaPagamento = new FormaPagamento();
//        novaFormaPagamento.setForma("Pix");
//        novaConsulta.setFormaPagamento(novaFormaPagamento);
//        novaConsulta.setValor(54.03f);
//        novaConsulta.setObservacao("Ta com o dente doendo ai cara");
//
//        Prontuario novoProntuario = new Prontuario();
//        novoProntuario.setDescricao("Cara tem q escova o dente cara");
//
//        novaConsulta.setProntuario(novoProntuario);
//
//        ConsultaController consultaController = new ConsultaController();
//        consultaController.addConsulta(novaConsulta);

    }
}
