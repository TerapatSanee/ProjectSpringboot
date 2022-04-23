package net.codejava.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Users {
	
	private Long user_id;
	private String username;
	private String fname;
	private String lname;
	private String ppid;
	
	public Users() {}
	
	public Users(Long user_id, String username, String fname, String lname, String ppid) {
		//super();
		this.user_id = user_id;
		this.username = username;
		this.fname = fname;
		this.lname = lname;
		this.ppid = ppid;
	}
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getPpid() {
		return ppid;
	}

	public void setPpid(String ppid) {
		this.ppid = ppid;
	}
}
