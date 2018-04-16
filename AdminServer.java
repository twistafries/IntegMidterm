package server;

import common.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class AdminServer{
	public static void main(String[] args){
		try{
			Registry reg = LocateRegistry.createRegistry(1099);
			AdminInterface serv = new AdminImplementation();
			PMessageInterface pmi = new PMessageImp();
			reg.rebind("admin", serv);
			reg.rebind("pmess", pmi);
			System.out.println("Server up and running.");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}