package dao;

import entities.Comanda;

public interface ComandaDao {

    void persist(Comanda p);

    Comanda find(int id);

    void remove(Comanda p);

    Comanda refresh(Comanda p);

    Comanda merge(Comanda p);

    void detach(Comanda p);

    void clear();

    void modifica(Comanda p);
}
