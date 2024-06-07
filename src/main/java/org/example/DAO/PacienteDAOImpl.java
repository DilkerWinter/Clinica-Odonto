package org.example.DAO;



import org.example.Model.Paciente.Paciente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class PacienteDAOImpl implements DAO {

    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.example_DevDeskP2_jar_1.0-SNAPSHOTPU");

    @Override
    public void salvar(Paciente paciente) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(paciente);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void atualizar(Paciente paciente) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(paciente);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void deletar(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Paciente paciente = entityManager.find(Paciente.class, id);
        entityManager.remove(paciente);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public Paciente getById(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Paciente paciente = entityManager.find(Paciente.class, id);
        entityManager.close();
        return paciente;
    }

    @Override
    public List<Paciente> getTodos() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Paciente> pacientes = entityManager.createQuery("SELECT p FROM Paciente p", Paciente.class).getResultList();
        entityManager.close();
        return pacientes;
    }
}
