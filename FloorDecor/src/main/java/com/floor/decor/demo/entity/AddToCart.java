package com.floor.decor.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cart_detail")
public class AddToCart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private long count;
	private long amount;

	@ManyToOne
	@JoinColumn(name = "cart_id", referencedColumnName = "product_id")
	private Product products;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "carts")
	private List<Order> orders;

	private Long userId;

	public AddToCart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AddToCart(long id, long count, long amount, Long userId, Product product) {
		super();
		this.id = id;
		this.count = count;
		this.amount = amount;
		this.userId = userId;
		this.products = product;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public Product getProduct() {
		return products;
	}

	public void setProduct(Product product) {
		this.products = product;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
