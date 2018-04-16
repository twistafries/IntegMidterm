package client;

import common.*;
import java.io.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.*;

public class Client{
	public static void main(String[] args){			
		try{
			Registry reg = LocateRegistry.getRegistry(1099);
			PMessageInterface pmess = (PMessageInterface) reg.lookup("pmess");
			Scanner kbd = new Scanner(System.in);
			String line = "";
			ProjectMessageImp pmi = null;
			
			while(true){
				try{
					System.out.print("Enter your name: ");
					line = kbd.nextLine().trim();
					
					User u = new User();
					u.setName(line);
					pmi = new ProjectMessageImp(u);
					pmess.logIn(pmi);
					break;
				} catch(Exception ex){
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}