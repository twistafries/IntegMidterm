package admin;

import common.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

public class ProjectModImp extends UnicastRemoteObject implements ProjectLeaderMod{
	private Map<String, Project> projects = new Hashtable<>();
	private Map<String, Member> memberMap = new Hashtable<>();
	private List<String> ptitles = new ArrayList<>();
	private List<Project> plist = new ArrayList<>();
	private List<Member> members = new ArrayList<>();

	private Project p;
	private Member m;
	BufferedReader br;
	BufferedReader fr;
	private FileWriter fw;
	
	public ProjectModImp() throws RemoteException{
			try{
				br = new BufferedReader(new FileReader("./Resources/Projects.csv"));
				fr = new BufferedReader(new FileReader("./Resources/Members.csv"));
				String[] str = null;
				String line = "";
				
				while((line = br.readLine()) != null){
					str = line.replaceAll("[\\[\\]]", "").split(",");
					p = new Project();
					p.setTitle(str[0]);
					p.setLeader(str[1].trim());
					List<String> projMemb = new ArrayList<>();
						for(int i=3; str.length > i; i++){
							projMemb.add(str[i].trim());
						}
					p.setMembers(projMemb);
					ptitles.add(str[0]);
					plist.add(p);
					projects.put(str[0], p);
					
				}
				
				br.close();
				str = null;
				line = "";
				
				while((line = fr.readLine()) != null){
					str = line.split(",");
					m = new Member();
					m.setName(str[1].trim(), str[0].trim());
					m.setPW(str[3]);
					m.setUName(str[2]);
					m.setActive(str[4].trim().equalsIgnoreCase("active") ? true : false);
					members.add(m);
					memberMap.put(m.getName(), m);
				}
			
				fr.close();
			}catch(Exception e){
			}
	}
	
	public void login(String name, String pw, String IP, int port) throws RemoteException{
		
	}
	
	public List<String> viewProjects(String name, int spec) throws RemoteException{
		List<String> viewable = new ArrayList<>();
		if(spec == 1){
			if(memberMap.containsKey(name)){
				for(Project proj: plist){			
					if(name.trim().equalsIgnoreCase(proj.getLeader().trim())){
						viewable.add(proj.getTitle());
					}
				}
			}
			return viewable;
		} else if (spec == 2){
			for(Project proj: plist){
				if((proj.getMembers()).contains(name)){
					viewable.add(proj.getTitle());
				}
			}
			return viewable;
		} else if (spec == 3){
			return ptitles;
		} else return viewable;
	}
	
	public void addMember(String mem, String title) throws RemoteException{
		if(memberMap.containsKey(mem)){
			try{
				fw = new FileWriter("./Resources/Projects.csv");
				Set<String> proj = projects.keySet();
				for(String t: proj){
					fw.append(t);
					fw.append(System.lineSeparator());
				}
			}catch(Exception e){
			}
		}
	}
}