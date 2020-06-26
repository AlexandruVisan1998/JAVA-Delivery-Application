package service;

import entities.User;
import lib.dto.UserDTO;

import java.rmi.RemoteException;

public interface UserService {

    void persist(User p);

    User find(int id);

    void remove(int id);

    void refresh(User p);

    void modifica(int codIdentificare, String nume);

    //int login(UserDTO userDTO) throws RemoteException;

    //int signin(UserDTO userDTO) throws RemoteException;
}
