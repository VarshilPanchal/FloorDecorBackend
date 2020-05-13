package com.floor.decor.demo.entity;
//

//import java.util.HashSet;
//
//import java.util.Set;
//import java.util.List;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
//import javax.persistence.ManyToMany;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "user_detail")
//public class User {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Column(name = "user_id")
//	private long id;
//	@Column(name = "user_name")
//	private String username;
//	@Column(name = "user_email")
//	private String email;
//	@Column(name = "user_password")
//	private String password;
//	@Column(name = "activeflag")
//	private boolean activeflag;
//	@Column(name = "total_orders")
//	private int orders;
//	@Column(name = "approved_order ")
//	private int approvedOrders;
//	@Column(name = "rejected_order")
//	private int rejectedOrders;
//	@Column(name = "user_phonenumber")
//	private long phonenumber;
//
////	@ManyToMany(cascade=CascadeType.MERGE)
////	@JoinTable(
////	      name="user_role",
////	      joinColumns={@JoinColumn(name="USER_ID", referencedColumnName="user_id")},
////	      inverseJoinColumns={@JoinColumn(name="ROLE_ID", referencedColumnName="id")})
////	private List<Role> roles;
//
//	@ManyToMany(fetch = FetchType.LAZY)
//	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
//	private Set<Role> roles = new HashSet<>();
//
//	public User() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//	public User(long id, String name, String email, String password, boolean activeflag, int orders, int approvedOrders,
//			int rejectedOrders, long phonenumber) {
//		super();
//		this.id = id;
//		this.username = name;
//		this.email = email;
//		this.password = password;
//		this.activeflag = activeflag;
//		this.orders = orders;
//		this.approvedOrders = approvedOrders;
//		this.rejectedOrders = rejectedOrders;
//		this.phonenumber = phonenumber;
//	}
//
//	public long getId() {
//		return id;
//	}
//
//	public void setId(long id) {
//		this.id = id;
//	}
//
//	public String getUsername() {
//		return username;
//	}
//
//	public void setUsername(String name) {
//		this.username = name;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public boolean isActiveflag() {
//		return activeflag;
//	}
//
//	public void setActiveflag(boolean activeflag) {
//		this.activeflag = activeflag;
//	}
//
//	public int getOrders() {
//		return orders;
//	}
//
//	public void setOrders(int orders) {
//		this.orders = orders;
//	}
//
//	public int getApprovedOrders() {
//		return approvedOrders;
//	}
//
//	public void setApprovedOrders(int approvedOrders) {
//		this.approvedOrders = approvedOrders;
//	}
//
//	public int getRejectedOrders() {
//		return rejectedOrders;
//	}
//
//	public void setRejectedOrders(int rejectedOrders) {
//		this.rejectedOrders = rejectedOrders;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
////	public List<Role> getRoles() {
////		return roles;
////	}
////
////	public void setRoles(List<Role> roles) {
////		this.roles = roles;
////	}
//	
//	public Set<Role> getRoles() {
//		return roles;
//	}
//
//	public void setRoles(Set<Role> roles) {
//		this.roles = roles;
//	}
//
//
//	@Override
//	public String toString() {
//		return "User [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password
//				+ ", activeflag=" + activeflag + ", orders=" + orders + ", approvedOrders=" + approvedOrders
//				+ ", rejectedOrders=" + rejectedOrders + ",phonenumber=" + phonenumber + "]";
//	}
//
//	public long getPhonenumber() {
//		return phonenumber;
//	}
//
//	public void setPhonenumber(long phonenumber) {
//		this.phonenumber = phonenumber;
//	}
//
//}

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users", uniqueConstraints = { @UniqueConstraint(columnNames = "username"),
		@UniqueConstraint(columnNames = "email") })
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(max = 20)
	private String username;

	@NotBlank
	@Size(max = 50)
	@Email
	private String email;

	@NotBlank
	@Size(max = 120)
	private String password;

	private boolean isActive;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();

	public User() {
	}

	public User(String username, String email, String password, boolean isActive) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.isActive = isActive;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public boolean getActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
}