package server;

import common.*;
import java.rmi.*;
import java.rmi.server.*;
import java.util.*;

public class PMessageImp extends UnicastRemoteObject implements PMessageInterface{
	private Map<String, ProjectMessage> pms = new Hashtable<>();
	public PMessageImp() throws RemoteException{
	}
	
	public void logIn(ProjectMessage pm) throws RemoteException {
		User u = pm.showUser();
		pms.put(u.getName(), pm);
		System.out.println("logged in: " + u.getName());
	}
	
	public void sendoutMsg(ProjectMessage pm, String msg) throws RemoteException{
		User u = pm.showUser();
		for(String name: pms.keySet()){
			pms.get(name).broadCastMessage(u, msg);
		}
	}
	
	public void logOut(ProjectMessage pm) throws RemoteException{
		User u = pm.showUser();
		pms.remove(u.getName());
		System.out.println("logged out: " + u.getName());
	}
}