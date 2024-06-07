package org.example;

import org.example.Model.Paciente.Paciente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("org.example_DevDeskP2_jar_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();

        Query query = em.createQuery("SELECT p FROM Paciente p");
        List<Paciente> pacientes = query.getResultList();

        for (Paciente paciente : pacientes) {
            System.out.println("---------- Paciente ----------");
            System.out.println("Nome: " + paciente.getNome());
            System.out.println("Cpf: " + paciente.getCpf());
            System.out.println("Data de Nascimento: " + paciente.getData_nascimento());
            System.out.println("--- Contato ---");
            System.out.println("Tipo de contato: " + paciente.getContato().getTipoContato().getTipo());
            System.out.println("Contato: " + paciente.getContato().getInformacao());
            System.out.println("--- Endereco ---");
            System.out.println("Estado: " + paciente.getEndereco().getCidade().getUf().getSigla());
            System.out.println("Cidade: " + paciente.getEndereco().getCidade().getNome());
            System.out.println("Rua: " + paciente.getEndereco().getRua());
            System.out.println("Numero: " + paciente.getEndereco().getNumero());
            System.out.println();
        }

        em.close();
        emf.close();



    }
}
