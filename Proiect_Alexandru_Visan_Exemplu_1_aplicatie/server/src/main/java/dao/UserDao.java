package dao;

import entities.User;

public interface UserDao {

    void persist(User p);

    User find(int codIdentificare);

    void remove(User p);

    User refresh(User p);

    User merge(User p);

    void detach(User p);

    void clear();

    void modifica(User p);
}
