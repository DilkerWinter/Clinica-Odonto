package org.example.DAO.Paciente.Endereco;

import org.example.DAO.DAO;
import org.example.Model.Paciente.Endereco.Endereco;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class EnderecoDAOImpl implements DAO<Endereco> {

    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.example_DevDeskP2_jar_1.0-SNAPSHOTPU");

    @Override
    public void salvar(Endereco endereco) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(endereco);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void atualizar(Endereco endereco) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(endereco);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void deletar(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Endereco endereco = entityManager.find(Endereco.class, id);
        if (endereco != null) {
            entityManager.remove(endereco);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public Endereco getById(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Endereco endereco = entityManager.find(Endereco.class, id);
        entityManager.close();
        return endereco;
    }

    @Override
    public List<Endereco> getTodos() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Endereco> enderecos = entityManager.createQuery("SELECT e FROM Endereco e", Endereco.class).getResultList();
        entityManager.close();
        return enderecos;
    }
}
