package admin;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class AdminServer{
	public static void main(String[] args){
		try{
			Registry reg = LocateRegistry.createRegistry(1099);
			System.out.println("Server up and running.");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}