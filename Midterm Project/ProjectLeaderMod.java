package common;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.*;

public interface ProjectLeaderMod extends Remote{
	public void login(String name, String pw, String IP, int port) throws RemoteException;
	public List<String> viewProjects(String name, int spec) throws RemoteException;
	public void addMember(String mem, String title) throws RemoteException;
}