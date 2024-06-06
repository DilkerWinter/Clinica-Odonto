package org.example;

import org.example.Controller.PacienteController;
import org.example.Model.Paciente.Paciente;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        PacienteController pacienteController = new PacienteController();

        List<Paciente> pacientes = pacienteController.getAllPacientes();

        for (Paciente paciente : pacientes) {
            System.out.println("Nome: " + paciente.getNome());
            System.out.println("Cpf: " + paciente.getCpf());
            System.out.println("Data de Nascimento: " + paciente.getData_nascimento());
            System.out.println("Endereco:");
            System.out.println("   Rua: " + paciente.getEndereco().getRua());
            System.out.println("   Numero: " + paciente.getEndereco().getNumero());
            System.out.println("   Cidade: " + paciente.getEndereco().getCidade().getCidade());
            System.out.println("   UF:" + paciente.getEndereco().getCidade().getUf().getSigla());
            System.out.println("Contato: ");
            System.out.println("   Tipo de Contato: " + paciente.getContato().getTipoContato().getTipo());
            System.out.println("   Informacao: " + paciente.getContato().getInformacao());
        }



    }
}
