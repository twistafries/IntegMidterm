package common;
import java.rmi.Remote;
import java.rmi.RemoteException;

//project callback
public interface ProjectMessage extends Remote{
	public User showUser() throws RemoteException;
	public void broadCastMessage(User u, String message) throws RemoteException;
}