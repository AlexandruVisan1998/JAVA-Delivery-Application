package service.impl;

import dao.ProdusDao;
import dao.impl.ProdusDaoImpl;
import entities.Produs;
import service.ProdusService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.OneToOne;
import javax.persistence.Persistence;

public class ProdusServiceImpl implements ProdusService {

    @OneToOne
    private ProdusDao ProdusDao;

    public ProdusServiceImpl() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence-unit");
        EntityManager em = emf.createEntityManager();

        this.ProdusDao = new ProdusDaoImpl(em);
    }

    @Override
    public void persist(Produs p) {
        ProdusDao.persist(p);
    }

    @Override
    public Produs find(int id) {
        return ProdusDao.find(id);
    }

    @Override
    public void remove(int id) {
        Produs p = find(id);
        ProdusDao.remove(p);
    }

    @Override
    public void refresh(Produs p) {
        ProdusDao.refresh(p);
    }

    @Override
    public void modifica(int id, String nume) {
        Produs p = new Produs();
        p.setId(id);
        p.setNume(nume);
        ProdusDao.modifica(p);
    }
}
