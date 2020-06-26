package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import entities.User;
import lib.dto.UserDTO;
import service.UserService;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.OneToOne;
import javax.persistence.Persistence;
import java.rmi.RemoteException;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    @OneToOne
    private UserDao UserDao;

    public UserServiceImpl() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence-unit");
        EntityManager em = emf.createEntityManager();

        this.UserDao = new UserDaoImpl(em);
    }

    @Override
    public void persist(User p) {
        UserDao.persist(p);
    }

    @Override
    public User find(int id) {
        return UserDao.find(id);
    }

    @Override
    public void remove(int id) {
        User p = find(id);
        UserDao.remove(p);
    }

    @Override
    public void refresh(User p) {
        UserDao.refresh(p);
    }

    @Override
    public void modifica(int CodIdentificare, String nume) {
        User p = new User();
        p.setId(CodIdentificare);
        p.setUsername(nume);
        UserDao.modifica(p);
    }
    
    // NU AM REUSIT SA LE FAC SA MEARGA FUNCTIILE - DE ASTA FLOW-UL APLICATIEI INCEPE CU A DOUA
    // FEREASTRA SI NU CU CEA DE LOGIN




    /*
    public int login(UserDTO userDTO)  throws RemoteException
    {
        Optional<User> userOptional = UserDaoImpl.find(userDTO.getUsername());

        return userOptional
                .filter(user -> user.getPassword().equals(userDTO.getPassword()))
                .map(User::getId)
                .orElseThrow(IllegalArgumentException::new);
    }

    public int signin(UserDTO userDTO) throws RemoteException
    {
        Optional<User> userOptional = UserDaoImpl
                .find(userDTO.getUsername());

        if (userOptional.isEmpty()) {
            return UserDaoImpl.persist(userDTO).getId();
        } else {
            throw new IllegalArgumentException();
        }
    }
    */
}
