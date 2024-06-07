package org.example.DAO.Paciente.Endereco;

import org.example.DAO.DAO;
import org.example.Model.Paciente.Endereco.Uf;

import javax.persistence.*;
import java.util.List;

public class UfDAOImpl implements DAO<Uf> {

    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.example_DevDeskP2_jar_1.0-SNAPSHOTPU");

    @Override
    public void salvar(Uf uf) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(uf);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void atualizar(Uf uf) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(uf);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void deletar(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Uf uf = entityManager.find(Uf.class, id);
        if (uf != null) {
            entityManager.remove(uf);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public Uf getById(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Uf uf = entityManager.find(Uf.class, id);
        entityManager.close();
        return uf;
    }

    @Override
    public List<Uf> getTodos() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Uf> ufs = entityManager.createQuery("SELECT u FROM Uf u", Uf.class).getResultList();
        entityManager.close();
        return ufs;
    }

    public Uf getBySigla(String sigla) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<Uf> query = entityManager.createQuery("SELECT u FROM Uf u WHERE u.sigla = :sigla", Uf.class);
        query.setParameter("sigla", sigla);
        Uf uf = null;
        try {
            uf = query.getSingleResult();
        } catch (NoResultException e) {

        } finally {
            entityManager.close();
        }
        return uf;
    }

}
