package common;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface AdminInterface extends Remote {
	public List loadUsers() throws RemoteException;
	public List viewProjectList() throws RemoteException;
	public void createProject(String name, User leader) throws RemoteException;
	public void assignLeader(User u) throws RemoteException;
}