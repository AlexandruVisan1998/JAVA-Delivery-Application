package dao.impl;

import dao.UserDao;
import entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.Optional;

public class UserDaoImpl implements UserDao {

    EntityManagerFactory emf = Persistence
            .createEntityManagerFactory("persistence-unit");

    EntityManager entityManager = emf.createEntityManager();

    public UserDaoImpl(EntityManager entityManager)
    {
        this.entityManager = entityManager;
    }

    @Override
    public void persist(User p)
    {
        entityManager.getTransaction().begin();
        entityManager.persist(p);
        entityManager.getTransaction().commit();
    }

    @Override
    public User find(int codIdentificare)
    {
        return entityManager.find(User.class, codIdentificare);
    }

    @Override
    public void remove(User p) // DELETE
    {
        entityManager.getTransaction().begin();
        entityManager.remove(p);
        entityManager.getTransaction().commit();
    }

    @Override
    public User refresh(User p)
    {
        entityManager.refresh(p);
        return p;
    }

    @Override
    public User merge(User p)
    {
        return entityManager.merge(p);
    }

    @Override
    public void detach(User p)
    {
        entityManager.detach(p);
    }

    @Override
    public void clear()
    {
        entityManager.clear();
    }

    @Override
    public void modifica(User p) // UPDATE
    {
        entityManager.getTransaction().begin();
        User merged = merge(p);
        entityManager.getTransaction().commit();
    }

    public Optional<User> find(String username) {
        TypedQuery<User> query = entityManager.createNamedQuery("User.findByUsername", User.class);

        query.setParameter("username", username);

        return query.getResultStream().findFirst();
    }
}