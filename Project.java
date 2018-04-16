package common;

import java.util.Scanner;
import java.io.Serializable;


public class Project implements Serializable{
	Scanner kbd = new Scanner(System.in);

	private String title;
	private User leader;
	private boolean status;
	
	//new Project, no attributes
	public Project(){
	}
	
	//create a project with a title only
	public Project(String title){
		this.title = title;
	}
	
	//create a project with a title and leader. Automatically 'on-going'
	public Project(String title, User leader) {
		this.title = title;
		this.leader = leader;
		status = false;
	}
	
	public Project(String title, Boolean b){
		this.title = title;
		status = b;
	}
	public String getTitle() {
		return title;
	}

	public User getleader() {
		return leader;
	}

	public boolean status(String stat) {
		if (stat.equals("on-going")){
			return false;
		}return true;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setleader(User leader) {
		this.leader = leader;
	}

	public void setStatus(){
		System.out.print("Is your project completed? Y/N");
		String stat = kbd.nextLine();
		if(stat.equals("[Yy]")){
			status = true;
		}else{
			status = false;
		}
	}
	
	public String toString(){
		return "Project : " + title + "\nLeader: " + leader;
	}
}