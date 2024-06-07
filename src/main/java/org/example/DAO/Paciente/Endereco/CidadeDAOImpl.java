package org.example.DAO.Paciente.Endereco;

import org.example.DAO.DAO;
import org.example.Model.Paciente.Endereco.Cidade;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class CidadeDAOImpl implements DAO<Cidade> {

    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.example_DevDeskP2_jar_1.0-SNAPSHOTPU");

    @Override
    public void salvar(Cidade cidade) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(cidade);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void atualizar(Cidade cidade) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(cidade);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void deletar(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Cidade cidade = entityManager.find(Cidade.class, id);
        if (cidade != null) {
            entityManager.remove(cidade);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public Cidade getById(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Cidade cidade = entityManager.find(Cidade.class, id);
        entityManager.close();
        return cidade;
    }

    @Override
    public List<Cidade> getTodos() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Cidade> cidades = entityManager.createQuery("SELECT c FROM Cidade c", Cidade.class).getResultList();
        entityManager.close();
        return cidades;
    }

    public Cidade getByNome(String nome) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<Cidade> query = entityManager.createQuery("SELECT c FROM Cidade c WHERE c.nome = :nome", Cidade.class);
        query.setParameter("nome", nome);
        Cidade cidade = null;
        try {
            cidade = query.getSingleResult();
        } catch (Exception e) {

        }
        entityManager.close();
        return cidade;
    }
}
