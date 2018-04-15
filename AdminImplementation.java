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
	public AdminImplementation () throws RemoteException {
	}

	@Override

	public void createProject() throws RemoteException {
		System.out.println("\nCreate Project\n");
		try {
			PrintWriter pw = new PrintWriter(new FileWriter("Project.csv", true));
			System.out.print("Enter Project Name: ");
			String projectName = scn.nextLine();

			System.out.print("Enter Project Leader: ");
			String projectLeader = scn.nextLine();

			boolean projectStatus = false;

			pw.println(projectName + "," + projectLeader + "," +projectStatus);
			new Project (projectName, projectLeader, projectStatus);
			pw.append(projectName + "," + projectLeader + "," +projectStatus);
			pw.close();
		} catch(Exception err) {}
	}


	public void viewProjectList() throws RemoteException {
		try {
			System.out.println("\nProject List\n");
			BufferedReader br = new BufferedReader(new FileReader("/Uploads/ProjectList.csv"));
			List<String> list = new ArrayList<String>();
			String[] str = null;
			String line = "";
			while ((line = br.readLine()) != null) {
				list.add(line);
			}
			System.out.format("%-30s%-30s%-10s", "Project Name", "ProjectLeader", "ProjectStatus");
			System.out.println();
			for(int x = 0; x < list.size(); x++){
				str = list.get(x).split(",");
				System.out.printf("%-30s%-30s%-10s", str[0], str[1], str[2]);
				System.out.println();
			}
			br.close();
		} catch (Exception err) {}
	}
}