package common;

import java.io.Serializable;
import java.util.*;

public class Project implements Serializable{
	private String title;
	private String leader;
	private List<String> members;
	private Map<String, Member> memberList;
	private boolean status = false;
	private Project p;
	
	public Project(){
	}
	
	public String getTitle(){
		return title;
	}
	
	public void setTitle(String title){
		this.title = title;
	}
	
	public String getLeader(){
		return leader;
	}
	
	public void setLeader(String leader){
		this.leader = leader;
	}
	
	public List<String> getMembers(){
		return members;
	}
	
	public void setMembers(List<String> members){
		this.members = members;
	}
	
	public String toString(){
		return title + "," + leader + "," + (status ? "completed," : "on-going,") + members;
	}
	
}