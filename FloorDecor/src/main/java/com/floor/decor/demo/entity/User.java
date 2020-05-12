package com.floor.decor.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_detail")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private long id;
	@Column(name = "user_name")
	private String username;
	@Column(name = "user_email")
	private String email;
	@Column(name = "user_password")
	private String password;
	@Column(name = "activeflag")
	private boolean activeflag;
	@Column(name = "total_orders")
	private int orders;
	@Column(name = "approved_order ")
	private int approvedOrders;
	@Column(name = "rejected_order")
	private int rejectedOrders;
	@Column(name = "user_phonenumber")
	private long phonenumber;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(long id, String name, String email, String password, boolean activeflag, int orders, int approvedOrders,
			int rejectedOrders, long phonenumber) {
		super();
		this.id = id;
		this.username = name;
		this.email = email;
		this.password = password;
		this.activeflag = activeflag;
		this.orders = orders;
		this.approvedOrders = approvedOrders;
		this.rejectedOrders = rejectedOrders;
		this.phonenumber = phonenumber;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String name) {
		this.username = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isActiveflag() {
		return activeflag;
	}

	public void setActiveflag(boolean activeflag) {
		this.activeflag = activeflag;
	}

	public int getOrders() {
		return orders;
	}

	public void setOrders(int orders) {
		this.orders = orders;
	}

	public int getApprovedOrders() {
		return approvedOrders;
	}

	public void setApprovedOrders(int approvedOrders) {
		this.approvedOrders = approvedOrders;
	}

	public int getRejectedOrders() {
		return rejectedOrders;
	}

	public void setRejectedOrders(int rejectedOrders) {
		this.rejectedOrders = rejectedOrders;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", activeflag=" + activeflag + ", orders=" + orders + ", approvedOrders=" + approvedOrders
				+ ", rejectedOrders=" + rejectedOrders + ",phonenumber=" + phonenumber + "]";
	}

	public long getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(long phonenumber) {
		this.phonenumber = phonenumber;
	}

}
