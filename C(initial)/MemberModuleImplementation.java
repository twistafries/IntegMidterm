import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.io.*;
import java.util.*;

public class MemberModuleImplementation extends UnicastRemoteObject implements MemberModuleInterface {
	private String name;

	public MemberModuleImplementation(String s) throws RemoteException {
	super();
      	name = s;
	}

	@Override
	public void viewListOfProjects() throws RemoteException {
		try {
			System.out.println("\nList of Projects\n: ");
			BufferedReader breader = new BufferedReader(new FileReader("ProjectList.csv"));
			List<String> list = new ArrayList<String>();
			String[] str = null;
			String line = "";
			while ((line = breader.readLine()) != null) {
				list.add(line);
			}
			System.out.format("%-30s%-30s%-10s", "Project Name", "ProjectLeader", "ProjectStatus");
			System.out.println();
			for(int x = 0; x < list.size(); x++){
				str = list.get(x).split(",");
				System.out.printf("%-30s%-30s%-10s", str[0], str[1], str[2]);
				System.out.println();
			}
			breader.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			}
	}


	public byte[] uploadFile(String upload) throws RemoteException {
		try {
         File file = new File(upload);
         byte buffer[] = new byte[(int)file.length()];
         BufferedInputStream input = new
      	 BufferedInputStream(new FileInputStream(upload));
         input.read(buffer,0,buffer.length);
         input.close();
         return(buffer);
      	} catch(Exception e){
	 e.printStackTrace();
 System.out.println("MemberModuleImplementation: "+e.getMessage());
	}
         return(null);
   }
}