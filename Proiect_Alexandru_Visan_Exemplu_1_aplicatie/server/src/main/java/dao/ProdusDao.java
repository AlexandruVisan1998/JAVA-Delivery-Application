package dao;

import entities.Produs;

public interface ProdusDao {

    void persist(Produs p);

    Produs find(int id);

    void remove(Produs p);

    Produs refresh(Produs p);

    Produs merge(Produs p);

    void detach(Produs p);

    void clear();

    void modifica(Produs p);


}
