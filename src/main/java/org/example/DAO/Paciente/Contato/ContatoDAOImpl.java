package org.example.DAO.Paciente.Contato;

import org.example.DAO.DAO;
import org.example.Model.Paciente.Contato.Contato;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ContatoDAOImpl implements DAO<Contato> {

    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.example_DevDeskP2_jar_1.0-SNAPSHOTPU");

    @Override
    public void salvar(Contato contato) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(contato);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void atualizar(Contato contato) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(contato);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void deletar(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Contato contato = entityManager.find(Contato.class, id);
        if (contato != null) {
            entityManager.remove(contato);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public Contato getById(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Contato contato = entityManager.find(Contato.class, id);
        entityManager.close();
        return contato;
    }

    @Override
    public List<Contato> getTodos() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Contato> contatos = entityManager.createQuery("SELECT c FROM Contato c", Contato.class).getResultList();
        entityManager.close();
        return contatos;
    }
}
