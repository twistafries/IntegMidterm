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


	public boolean uploadFile(String upload) throws RemoteException {
		try {
        		File file = new File(upload);
			if(file.exits()){
				FileOutputStream writefile = new FileOutputStream("./Files/"+fileName+"."+fileType);
				FileInputStream readFile = new FileInputStream(file);
				byte b[] = new byte[(int)file.length()];
				writefile.write(b);
				writefile.close();
			}else{
				return false;
			}
      		} catch(Exception e){
	 		e.printStackTrace();
 			System.out.println("MemberModuleImplementation: "+e.getMessage());
			return false;
		}
         	return true;
   	}
}
