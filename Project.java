package common;

import java.util.Scanner;
import java.io.Serializable;


class Project  implements Serializable {
	Scanner kbd = new Scanner(System.in);

	private String title;
	private String leader;
	private boolean status;
	
	//new Project, no attributes
	public Project(){
	}
	
	//create a project with a title only
	public Project(String title){
		this.title = title;
	}
	
	//create a project with a title and leader. Automatically 'on-going'
	public Project(String title, String leader) {
		this.title = title;
		this.leader = leader;
		status = false;
	}

	public String getTitle() {
		return title;
	}

	public String getleader() {
		return leader;
	}

	public boolean status(String stat) {
		if (stat.equals("on-going")){
			return false;
		}return true;
	}

	public void setTitle() {
		System.out.print("Enter the title of the Project: ");
		title = kbd.nextLine();
	}

	public void setleader() {
		System.out.print("Enter the name of the Leader: ");
		leader = kbd.nextLine();
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
}