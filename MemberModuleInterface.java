import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MemberModuleInterface extends Remote {
	public void viewListOfProjects() throws RemoteException; 
	public boolean uploadFile(String upload) throws RemoteException;
}
