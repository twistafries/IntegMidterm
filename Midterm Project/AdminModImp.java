package admin;

import common.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

import java.nio.file.*;
import java.nio.charset.*;

public class AdminModImp extends UnicastRemoteObject implements AdminModInterface{
	private Map<String, Project> projects = new Hashtable<>();
	private Map<String, Member> memberMap = new Hashtable<>();
	private List<String> ptitles = new ArrayList<>();
	private List<Member> members = new ArrayList<>();
	private List<String> projMemb = new ArrayList<>();
	private Project p;
	private FileWriter fw;
	private Member m;
	BufferedReader br;
	BufferedReader fr;
	
	public AdminModImp() throws RemoteException{
		try{
			br = new BufferedReader(new FileReader("./Resources/Projects.csv"));
			fr = new BufferedReader(new FileReader("./Resources/Members.csv"));
			String[] str = null;
			String line = "";
			
			while((line = br.readLine()) != null){
				str = line.split(",");
				p = new Project();
				p.setTitle(str[0]);
				p.setLeader(str[1]);
				for(int i=3; str.length > i; i++){
					projMemb.add(str[i]);
				}
				ptitles.add(str[0]);
				projects.put(str[0], p);
				
			}
			
			br.close();
			str = null;
			line = "";
			
			while((line = fr.readLine()) != null){
				str = line.split(",");
				m = new Member();
				m.setName(str[1], str[0]);
				m.setPW(str[3]);
				m.setUName(str[2]);
				m.setActive(str[4].trim().equalsIgnoreCase("active") ? true : false);
				members.add(m);
				memberMap.put(m.getName(), m);
			}
			
		}catch(Exception e){
		}
	}
	
	public List<String> viewProjects() throws RemoteException{
		return ptitles;
	}
	
	public List<Member> viewMembers() throws RemoteException{
		return members;
	}
	
	public void createProject(String title, String leader) throws RemoteException{
		p = new Project();
		if(!projects.containsKey(title) && memberMap.containsKey(leader)){
			p.setTitle(title);
			p.setLeader(leader);
			projects.put(title, p);
			ptitles.add(title);
			
			try{
				fw = new FileWriter("./Resources/Projects.csv", true);
				fw.append(System.lineSeparator());
				fw.append(title + "," + leader + ",on-going");
				fw.flush();
				fw.close();
			}catch(Exception e){
			}
		} else {
		}
	}

	public void modifyLeader(String title, String leader) throws RemoteException{
		if(projects.containsKey(title) && memberMap.containsKey(leader)){
			p = projects.get(title);
			p.setLeader(leader);
			try{
				fw = new FileWriter("./Resources/Projects.csv");
				Set<String> proj = projects.keySet();
				for(String t: proj){
					fw.append(projects.get(t).toString());
					fw.append(System.lineSeparator());
				}
				fw.flush();
				fw.close();
			}catch(Exception e){
			}
		}
	}
	
	public void registerMember(String member, boolean active) throws RemoteException{
		if(memberMap.containsKey(member)){
			m = memberMap.get(member);
			m.setActive(active);
			try{
				fw = new FileWriter("./Resources/Members.csv");
				Set<String> memb = memberMap.keySet();
				for(String x: memb){
					fw.append(memberMap.get(x).toString());
					fw.append(System.lineSeparator());
				}
				fw.flush();
				fw.close();
			}catch(Exception e){
			}
		}
	}
}