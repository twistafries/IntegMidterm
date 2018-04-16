package admin;

import common.*;
import java.io.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.*;

public class AdminClient{
	public static void main(String[] args){		
		BufferedReader kbd = new BufferedReader(new InputStreamReader(System.in));
		int in;	
		try{
			Registry reg = LocateRegistry.getRegistry(1099);
			AdminInterface adm = (AdminInterface) reg.lookup("admin");
			System.out.println("Welcome, admin. What would you like to do today?");
			System.out.println("[1] Create a project. \n[2] Load all users. \n[3] View All Projects");
			in = Integer.parseInt(kbd.readLine());
			
			List<User> list =  new ArrayList<>(); 
			List<Project> plist = new ArrayList<>();	
			try{
				list = adm.loadUsers();	
				plist = adm.viewProjectList();
				
				if(in == 1){
					User leader = null;
					System.out.print("Enter Project Name: ");
					String projectName = kbd.readLine();
					System.out.print("Project Leader Name: ");
					String projectLeader = kbd.readLine();
					
					System.out.print(plist);
					for(User u: list){
						if(u.getName().equals(projectLeader)){
							leader = u;
							u.setLevel("Project Leader");
						}
					}
					kbd.close();
					adm.createProject(projectName, leader);
				} else if(in == 2){
					System.out.print(list);
				} else if(in == 3){
					System.out.print(plist);
				}
			}catch(Exception ae){
				ae.printStackTrace();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}