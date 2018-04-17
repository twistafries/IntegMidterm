package common;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.*;

public interface AdminModInterface extends Remote{
	public List<String> viewProjects() throws RemoteException;
	public List<Member> viewMembers() throws RemoteException;
	public void createProject(String title, String leader) throws RemoteException;
	public void modifyLeader(String title, String leader) throws RemoteException;
	public void registerMember(String member, boolean active) throws RemoteException;
}