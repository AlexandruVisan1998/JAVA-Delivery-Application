package service;

import entities.Produs;

public interface ProdusService {

    void persist(Produs p);

    Produs find(int id);

    void remove(int id);

    void refresh(Produs p);

    void modifica(int id, String nume);
}
