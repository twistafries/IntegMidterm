package client;

import common.*;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ProjectMessageImp extends UnicastRemoteObject implements ProjectMessage{
	private User user;
	
	public ProjectMessageImp(User u) throws RemoteException{
		this.user = u;
	}
	
	public User showUser() throws RemoteException{
		return this.user;
	}
	
	public void broadCastMessage(User u, String message) throws RemoteException {
		System.out.println("IN (user)" + u.getName() + ": " + message);
	}
}