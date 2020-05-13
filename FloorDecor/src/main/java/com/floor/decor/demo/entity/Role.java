package com.floor.decor.demo.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author Ramesh Fadatare
 *
 */
//@Entity
//@Table(name="roles")
//public class Role
//{
//	@Id @GeneratedValue(strategy=GenerationType.AUTO)
//	private Integer id;
//	@Column(nullable=false, unique=true)
//	@NotEmpty
//	private String name;
//		
//	@ManyToMany(mappedBy="roles")
//	private List<User> users;
//
//	public Integer getId()
//	{
//		return id;
//	}
//
//	public void setId(Integer id)
//	{
//		this.id = id;
//	}
//
//	public String getName()
//	{
//		return name;
//	}
//
//	public void setName(String name)
//	{
//		this.name = name;
//	}
//
//	public List<User> getUsers() {
//		return users;
//	}
//
//	public void setUsers(List<User> users) {
//		this.users = users;
//	}
//	
//}


@Entity
@Table(name = "roles")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private ERole name;

	public Role() {

	}

	public Role(ERole name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ERole getName() {
		return name;
	}

	public void setName(ERole name) {
		this.name = name;
	}
}
