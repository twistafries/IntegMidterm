package client;

import common.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client{
	public static void main(String[] args){
		Scanner kbd = new Scanner(System.in);
		String title;
		String name;
		int spec;
		String mem;
		try{
			Registry registry = LocateRegistry.getRegistry(1099);
			ProjectLeaderMod plead = (ProjectLeaderMod) registry.lookup("pLead");
			System.out.println("Welcome to the project management client. Please log in first.");
			
			while(true){
				System.out.println("What would you like to do?");
				System.out.println("[1] Show Projects \n[2] Add Members to the Project \n[3] Update member list \n[4] Set Project Status \n[5] Upload a file \n[6] Exit");
				int choice = kbd.nextInt();
				kbd.nextLine();
				if(choice == 1){
					System.out.println("Enter full member name here: ");
					name = kbd.nextLine().trim();
					System.out.println("[1] Show projects that you lead \n[2] Show projects that you are a member of\n[3] Show both");
					spec = kbd.nextInt();
					kbd.nextLine();
					System.out.println(plead.viewProjects(name, spec));
				} else if(choice == 2){
					System.out.println("Which project?");
					title = kbd.nextLine();
					System.out.println("Which member?");
					mem = kbd.nextLine();
					plead.addMember(mem, title);
				} else if(choice == 3){
				} else if(choice == 4){
				} else if(choice == 5){
				} else if(choice == 6){
					break;
				}
			}
		}catch(Exception e){
		}
	}
}