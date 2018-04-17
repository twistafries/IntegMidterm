package common;

import java.io.Serializable;
import java.util.*;

public class Member implements Serializable {
	
	private String fname;
	private String lname;
	private String name;
	private String pw;
	private String uName;
	private boolean active;
	
	public Member(){
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getUName(){
		return uName;
	}
	
	public void setUName(String uName){
		this.uName = uName;
	}
	
	public String getPW(){
		return pw;
	}
	
	public void setPW(String pw){
		this.pw = pw;
	}
	
	public void setName(String fname, String lname){
		this.fname = fname;
		this.lname = lname;
		this.name = fname + " " + lname;
	}
	
	public void setActive(boolean active){
		this.active = active;
	}
	
	public boolean getActive(){
		return active;
	}
	
	public String toString(){
		return lname + "," + fname + "," + uName + "," + (active ? "active" : "inactive");
	}
}