package dao.impl;

import dao.ProdusDao;
import entities.Produs;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ProdusDaoImpl implements ProdusDao {

    EntityManagerFactory emf = Persistence
            .createEntityManagerFactory("persistence-unit");

    EntityManager entityManager = emf.createEntityManager();

    public ProdusDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void persist(Produs p)
    {

        entityManager.getTransaction().begin();
        entityManager.persist(p);
        entityManager.getTransaction().commit();
    }

    @Override
    public Produs find(int id)
    {
        return entityManager.find(Produs.class, id);
    }

    @Override
    public void remove(Produs p) // DELETE
    {
        entityManager.getTransaction().begin();
        entityManager.remove(p);
        entityManager.getTransaction().commit();
    }

    @Override
    public Produs refresh(Produs p)
    {
        entityManager.refresh(p);
        return p;
    }

    @Override
    public Produs merge(Produs p)
    {
        return entityManager.merge(p);
    }

    @Override
    public void detach(Produs p)
    {
        entityManager.detach(p);
    }

    @Override
    public void clear()
    {
        entityManager.clear();
    }

    @Override
    public void modifica(Produs p) //UPDATE
    {
        entityManager.getTransaction().begin();
        Produs merged = merge(p);
        entityManager.getTransaction().commit();
    }
}
