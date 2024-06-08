package org.example.DAO.Consulta;

import org.example.DAO.DAO;
import org.example.Model.Consulta.Prontuario;
import org.example.Model.Paciente.Paciente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ProntuarioDAOImpl implements DAO<Prontuario> {

    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.example_DevDeskP2_jar_1.0-SNAPSHOTPU");

    @Override
    public void salvar(Prontuario prontuario) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(prontuario);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void atualizar(Prontuario prontuario) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(prontuario);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void deletar(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Prontuario prontuario = entityManager.find(Prontuario.class, id);
        if (prontuario != null) {
            entityManager.remove(prontuario);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public Prontuario getById(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Prontuario prontuario = entityManager.find(Prontuario.class, id);
        entityManager.close();
        return prontuario;
    }

    @Override
    public List<Prontuario> getTodos() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Prontuario> prontuarios = entityManager.createQuery("SELECT p FROM Prontuario p", Prontuario.class).getResultList();
        entityManager.close();
        return prontuarios;
    }

    public List<Prontuario> getProntuarioPorPaciente(Paciente paciente) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Prontuario> prontuarios = entityManager.createQuery("SELECT p FROM Prontuario p WHERE p.paciente = :paciente", Prontuario.class)
                .setParameter("paciente", paciente)
                .getResultList();
        entityManager.close();
        return prontuarios;
    }

}
