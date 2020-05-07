package com.floor.decor.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admin_detail")
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="admin_id")
	private long id;
	@Column(name="admin_name")
	private String adminname;
	@Column(name="admin_email")
	private String email;
	@Column(name="admin_password")
	private String password;

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(long id, String name, String email, String password) {
		super();
		this.id = id;
		this.adminname = name;
		this.email = email;
		this.password = password;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAdminname() {
		return adminname;
	}

	public void setAdminname(String name) {
		this.adminname = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", adminname=" + adminname + ", email=" + email + ", password=" + password + "]";
	}
	
	
	

}
