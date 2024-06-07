package org.example.DAO.Paciente.Contato;

import org.example.DAO.DAO;
import org.example.Model.Paciente.Contato.TipoContato;
import org.example.Model.Paciente.Endereco.Uf;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class TipoContatoDAOImpl implements DAO<TipoContato> {

    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.example_DevDeskP2_jar_1.0-SNAPSHOTPU");

    @Override
    public void salvar(TipoContato tipoContato) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(tipoContato);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void atualizar(TipoContato tipoContato) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(tipoContato);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void deletar(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        TipoContato tipoContato = entityManager.find(TipoContato.class, id);
        if (tipoContato != null) {
            entityManager.remove(tipoContato);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public TipoContato getById(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TipoContato tipoContato = entityManager.find(TipoContato.class, id);
        entityManager.close();
        return tipoContato;
    }

    @Override
    public List<TipoContato> getTodos() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<TipoContato> tiposContato = entityManager.createQuery("SELECT tc FROM TipoContato tc", TipoContato.class).getResultList();
        entityManager.close();
        return tiposContato;
    }

    public TipoContato getByTipo(String tipo) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<TipoContato> query = entityManager.createQuery("SELECT t FROM TipoContato t WHERE t.tipo = :tipo", TipoContato.class);
        query.setParameter("tipo", tipo);
        TipoContato tipoContato = null;
        try {
            tipoContato = query.getSingleResult();
        } catch (Exception e) {

        }
        entityManager.close();
        return tipoContato;
    }
}
