package org.example.DAO.Consulta;

import org.example.DAO.DAO;
import org.example.Model.Consulta.FormaPagamento;
import org.example.Model.Paciente.Contato.TipoContato;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class FormaPagamentoDAOImpl implements DAO<FormaPagamento> {

    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.example_DevDeskP2_jar_1.0-SNAPSHOTPU");

    @Override
    public void salvar(FormaPagamento formaPagamento) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(formaPagamento);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void atualizar(FormaPagamento formaPagamento) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(formaPagamento);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void deletar(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        FormaPagamento formaPagamento = entityManager.find(FormaPagamento.class, id);
        if (formaPagamento != null) {
            entityManager.remove(formaPagamento);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public FormaPagamento getById(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        FormaPagamento formaPagamento = entityManager.find(FormaPagamento.class, id);
        entityManager.close();
        return formaPagamento;
    }

    @Override
    public List<FormaPagamento> getTodos() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<FormaPagamento> formasPagamento = entityManager.createQuery("SELECT f FROM FormaPagamento f", FormaPagamento.class).getResultList();
        entityManager.close();
        return formasPagamento;
    }

    public FormaPagamento getByForma(String forma) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<FormaPagamento> query = entityManager.createQuery("SELECT f FROM FormaPagamento f WHERE f.forma = :forma", FormaPagamento.class);
        query.setParameter("forma", forma);
        FormaPagamento formaPagamento= null;
        try {
            formaPagamento = query.getSingleResult();
        } catch (Exception e) {

        }
        entityManager.close();
        return formaPagamento;
    }
}
