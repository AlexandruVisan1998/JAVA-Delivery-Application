import service.impl.UserServiceImpl;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MainServer {

    public static void main(String [] args) throws RemoteException {
        Registry registry = LocateRegistry.createRegistry(8080);
        registry.rebind("userService", (Remote) new UserServiceImpl());
    }

}
