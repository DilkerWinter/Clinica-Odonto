package org.example.DAO.Consulta;

import org.example.DAO.DAO;
import org.example.Model.Consulta.Agendamento;
import org.example.Model.Paciente.Paciente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class AgendamentoDAOImpl implements DAO<Agendamento> {

    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.example_DevDeskP2_jar_1.0-SNAPSHOTPU");

    @Override
    public void salvar(Agendamento agendamento) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(agendamento);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void atualizar(Agendamento agendamento) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(agendamento);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void deletar(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Agendamento agendamento = entityManager.find(Agendamento.class, id);
        if (agendamento != null) {
            entityManager.remove(agendamento);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public Agendamento getById(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Agendamento agendamento = entityManager.find(Agendamento.class, id);
        entityManager.close();
        return agendamento;
    }

    @Override
    public List<Agendamento> getTodos() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Agendamento> agendamentos = entityManager.createQuery("SELECT a FROM Agendamento a", Agendamento.class).getResultList();
        entityManager.close();
        return agendamentos;
    }

    public List<Agendamento> getAgendamentosPorPaciente(Paciente paciente) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Agendamento> agendamentos = entityManager.createQuery("SELECT a FROM Agendamento a WHERE a.paciente = :paciente", Agendamento.class)
                .setParameter("paciente", paciente)
                .getResultList();
        entityManager.close();
        return agendamentos;
    }

}
