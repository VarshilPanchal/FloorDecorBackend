package com.floor.decor.demo.entity;

public class Product {

	private long id;
	private String name;
	private long prize;
	private boolean activeflag;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(long id, String name, long prize, boolean activeflag) {
		super();
		this.id = id;
		this.name = name;
		this.prize = prize;
		this.activeflag = activeflag;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPrize() {
		return prize;
	}

	public void setPrize(long prize) {
		this.prize = prize;
	}

	public boolean isActiveflag() {
		return activeflag;
	}

	public void setActiveflag(boolean activeflag) {
		this.activeflag = activeflag;
	}

}
