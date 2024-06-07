package org.example.DAO.Paciente.Contato;

import org.example.DAO.DAO;
import org.example.Model.Funcionario.Cargo;
import org.example.Model.Paciente.Contato.TipoContato;
import org.example.Model.Paciente.Endereco.Uf;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class CargoDAOImpl implements DAO<Cargo> {

    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.example_DevDeskP2_jar_1.0-SNAPSHOTPU");

    @Override
    public void salvar(Cargo cargo) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(cargo);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void atualizar(Cargo cargo) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(cargo);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void deletar(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Cargo cargo = entityManager.find(Cargo.class, id);
        if (cargo != null) {
            entityManager.remove(cargo);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public Cargo getById(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Cargo cargo = entityManager.find(Cargo.class, id);
        entityManager.close();
        return cargo;
    }

    @Override
    public List<Cargo> getTodos() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Cargo> cargos = entityManager.createQuery("SELECT c FROM Cargo c", Cargo.class).getResultList();
        entityManager.close();
        return cargos;
    }

    public Cargo getByCargo(String cargo) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<Cargo> query = entityManager.createQuery("SELECT c FROM Cargo c WHERE c.cargo = :cargo", Cargo.class);
        query.setParameter("cargo", cargo);
        Cargo  cargoReturn = null;
        try {
            cargoReturn = query.getSingleResult();
        } catch (Exception e) {

        }
        entityManager.close();
        return cargoReturn;
    }
}
