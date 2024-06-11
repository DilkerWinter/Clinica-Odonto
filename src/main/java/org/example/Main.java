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
import org.example.Telas.tela_login;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        tela_login telaLogin = new tela_login();
        telaLogin.setVisible(true);


    }
}
