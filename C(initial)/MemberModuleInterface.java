import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MemberModuleInterface extends Remote {
	public String viewListOfProjects() throws RemoteException; 
	public byte[] uploadFile(String upload) throws RemoteException;
}