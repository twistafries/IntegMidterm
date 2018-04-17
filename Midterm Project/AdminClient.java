package admin;

import common.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class AdminClient{
	public static void main(String[] args){
		Scanner kbd = new Scanner(System.in);
		String title;
		String leader;
		try{
			Registry registry = LocateRegistry.getRegistry(1099);
			AdminModInterface admin = (AdminModInterface) registry.lookup("admin");
			while(true){
				System.out.println("Welcome, admin. What would you like to do?");
				System.out.println("1 - View All Members");
				System.out.println("2 - View All Projects");
				System.out.println("3 - Create a new project");
				System.out.println("4 - Set leader of a project");
				System.out.println("5 - Register a user");
				System.out.println("6 - Exit program");
				int input = kbd.nextInt();
				kbd.nextLine();
				if(input == 1){
					System.out.println(admin.viewMembers());
				}else if(input == 2){
					System.out.println(admin.viewProjects());
				}else if(input == 3){
					System.out.println("Enter the project name:");
					title = kbd.nextLine().trim();
					System.out.println("Enter the complete name of the project leader:");
					leader = kbd.nextLine().trim();
					admin.createProject(title, leader);
				}else if(input == 4){
					System.out.println("Changing the leader of a project.");
					System.out.println("Enter the project name ");
					title = kbd.nextLine().trim();
					System.out.println("Enter the complete name of the leader:");
					leader = kbd.nextLine().trim();
					admin.modifyLeader(title, leader);
				}else if(input == 5){
					System.out.println("Setting activity of member.");
					System.out.println("Please enter the full name of the member:");
					String name = kbd.nextLine().trim();
					System.out.println("Set active [1] \nSet inactive [2]");
					int in = kbd.nextInt();
					if(in == 1){
						admin.registerMember(name, true);
					} else if (in == 2){
						admin.registerMember(name, false);
					}
				} else if(input == 6){
					break;
				}
			}
		}catch(Exception e){
		}
	}
}