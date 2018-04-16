package common;

import java.io.Serializable;

public class User implements Serializable{
	private String name;
	private String fname;
	private String lname;
	private String level;
	private boolean active;
	private String project;
	private String pw;

	public User(){
	}
	
	public User(String name, String level){
		this.name = name;
		this.level = level;
	}

	public User(String lname, String fname, String level, String bool, String pw){
		this.lname = lname;
		this.fname = fname;
		this.level = level;
		active = true;
		this.pw = pw;
		name = fname + " " + lname;
	}
	
	public void setProject(String project){
		this.project = project;
	}
	
	public String getProject(){
		return project;
	}
	
	public String getName(){
		name = fname + " " + lname;
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getLvl(){
		return level;
	}
	
	public void setLevel(String level){
		this.level = level;
	}
	public void setPW(String pw){
		this.pw = pw;
	}
	
	public String getPW(){
		return pw;
	}
	
	public String toString(){
		return "Name: " + name +", Currently: " + level + "\n";
	}
}