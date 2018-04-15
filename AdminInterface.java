import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AdminInterface extends Remote {
	public void viewProjectList() throws RemoteException;
	public void createProject() throws RemoteException;
}