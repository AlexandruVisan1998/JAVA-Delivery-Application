package dao.impl;

import dao.ComandaDao;
import dao.ComandaDao;
import entities.Comanda;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ComandaDaoImpl implements ComandaDao {
    EntityManagerFactory emf = Persistence
            .createEntityManagerFactory("persistence-unit");

    EntityManager entityManager = emf.createEntityManager();

    public ComandaDaoImpl(EntityManager entityManager)
    {
        this.entityManager = entityManager;
    }

    @Override
    public void persist(Comanda p) {

        entityManager.getTransaction().begin();
        entityManager.persist(p);
        entityManager.getTransaction().commit();
    }

    @Override
    public Comanda find(int id) {
        return entityManager.find(Comanda.class, id);
        //id asociat in baza de date in ordinea introducerii
    }

    @Override
    public void remove(Comanda p) //DELETE
    {
        entityManager.getTransaction().begin();
        entityManager.remove(p);
        entityManager.getTransaction().commit();
    }

    @Override
    public Comanda refresh(Comanda p) {
        entityManager.refresh(p);
        return p;
    }

    @Override
    public Comanda merge(Comanda p) {
        return entityManager.merge(p);
    }

    @Override
    public void detach(Comanda p) {
        entityManager.detach(p);
    }

    @Override
    public void clear() {
        entityManager.clear();
    }

    @Override
    public void modifica(Comanda p) //UPDATE
    {
        entityManager.getTransaction().begin();
        Comanda merged = merge(p);
        entityManager.getTransaction().commit();
    }
}
