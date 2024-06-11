package org.example.DAO.Consulta;

import org.example.DAO.DAO;
import org.example.Model.Consulta.Consulta;
import org.example.Model.Paciente.Paciente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Connection;
import java.util.List;

public class ConsultaDAOImpl implements DAO<Consulta> {

    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.example_DevDeskP2_jar_1.0-SNAPSHOTPU");

    @Override
    public void salvar(Consulta consulta) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(consulta);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void atualizar(Consulta consulta) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(consulta);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void deletar(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Consulta consulta = entityManager.find(Consulta.class, id);
        if (consulta != null) {
            entityManager.remove(consulta);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public Consulta getById(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Consulta consulta = entityManager.find(Consulta.class, id);
        entityManager.close();
        return consulta;
    }

    @Override
    public List<Consulta> getTodos() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Consulta> consultas = entityManager.createQuery("SELECT c FROM Consulta c", Consulta.class).getResultList();
        entityManager.close();
        return consultas;
    }

    public List<Consulta> getConsultaPorPaciente(Paciente paciente) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Consulta> consultas = entityManager.createQuery("SELECT c FROM Consulta c WHERE c.paciente = :paciente", Consulta.class)
                .setParameter("paciente", paciente)
                .getResultList();
        entityManager.close();
        return consultas;
    }

}
