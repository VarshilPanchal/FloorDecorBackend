package com.floor.decor.demo.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_list")
public class Product {

	@Id
	@Column(name = "product_id")
	private long id;
	@Column(name = "product_image")
	private String image;
	@Column(name = "product_name")
	private String name;
	@Column(name = "product_prize")
	private long prize;
	@Column(name = "product_activeflag")
	private boolean activeflag;
	@Column(name = "product_detail")
	private String productDetail;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(long id, String image, String name, long prize, boolean activeflag,String productDetail) {
		super();
		this.id = id;
		this.image = image;
		this.name = name;
		this.prize = prize;
		this.activeflag = activeflag;
		this.productDetail = productDetail;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getProductDetail() {
		return productDetail;
	}

	public void setProductDetail(String productDetail) {
		this.productDetail = productDetail;
	}

}
