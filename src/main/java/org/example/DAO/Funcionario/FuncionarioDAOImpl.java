package org.example.DAO.Funcionario;

import org.example.DAO.DAO;
import org.example.Model.Funcionario.Funcionario;
import org.example.Model.Funcionario.Login;
import org.example.Service.PasswordEncrypt;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class FuncionarioDAOImpl implements DAO<Funcionario> {

    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.example_DevDeskP2_jar_1.0-SNAPSHOTPU");

    @Override
    public void salvar(Funcionario funcionario) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(funcionario);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void atualizar(Funcionario funcionario) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(funcionario);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void deletar(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Funcionario funcionario = entityManager.find(Funcionario.class, id);
        entityManager.remove(funcionario);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public Funcionario getById(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Funcionario funcionario = entityManager.find(Funcionario.class, id);
        entityManager.close();
        return funcionario;
    }

    @Override
    public List<Funcionario> getTodos() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Funcionario> funcionarios = entityManager.createQuery("SELECT f FROM Funcionario f", Funcionario.class).getResultList();
        entityManager.close();
        return funcionarios;
    }

    public Funcionario fazerLogin(Login login) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        String usuario = login.getUsuario();
        String senhaCrypt = PasswordEncrypt.encrypt(login.getSenha());

        Funcionario funcionario = entityManager.createQuery("SELECT f FROM Funcionario f WHERE f.usuario = :usuario", Funcionario.class).setParameter("usuario", usuario).getSingleResult();
        if (funcionario != null) {
            if (funcionario.getSenha().equals(senhaCrypt)) {
                return funcionario;
            }
        }
        return null;
    }
}
