package common;

import java.rmi.*;

//interface for sending out messages to all members of a project
public interface PMessageInterface extends Remote{
	public void logIn(ProjectMessage pm) throws RemoteException;
	public void sendoutMsg(ProjectMessage pm, String msg) throws RemoteException;
	public void logOut(ProjectMessage pm) throws RemoteException;
}