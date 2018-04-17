package admin;

import common.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server{
	public static void main(String[] args){
		try{
			Registry registry = LocateRegistry.createRegistry(1099);
			AdminModInterface admin = new AdminModImp();
			ProjectLeaderMod pLead = new ProjectModImp();
			registry.rebind("admin", admin);
			registry.rebind("pLead", pLead);
			System.out.println("Server Running");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}