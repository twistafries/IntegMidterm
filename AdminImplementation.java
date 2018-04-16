package server;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.LocateRegistry;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

import common.*;

public class AdminImplementation extends UnicastRemoteObject implements AdminInterface {
	private Scanner scn = new Scanner(System.in);
	private List<Project> pList = new ArrayList<>();
	private List<User> ulist = new ArrayList<>();
	
	public AdminImplementation () throws RemoteException {
		try{
			String location = "Users.csv";
			BufferedReader br = new BufferedReader(new FileReader(location));
			String line = "";
			
			while((line = br.readLine()) != null){
				String[] user = line.split(",");
				User u = new User(user[0], user[1], user[2], user[3], user[4]);
				ulist.add(u);
			}
			
			location = "ProjectList.csv";
			line = "";
			while ((line = br.readLine()) != null) {
				String[] project = line.split(",");
				Project p = new Project(project[0], true);
				pList.add(p);
			}
		} catch (Exception err) {
		}
	}
	
	public List<User> loadUsers() throws RemoteException{
		return ulist;
	}

	public void createProject(String name, User leader) throws RemoteException {
		Project p = new Project(name, leader);
		pList.add(p);
	}

	public List<Project> viewProjectList() throws RemoteException {
		return pList;
	}
	
	public void assignLeader(User u) throws RemoteException{
		
	}
}