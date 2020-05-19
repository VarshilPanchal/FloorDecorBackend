package com.floor.decor.demo.entity;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "order_detail")
public class Order {

//	@ForeignKey(foreignKeyDefinition = productId )

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

//	@NotBlank
	private long productId;

//	@ManyToMany
//	@NotBlank
	private long userId;

//	@NotBlank
	private String name;
	
//	private String productName;

//	@NotBlank
	private String address;

//	@NotBlank
	private String landmark;

//	@NotBlank
	private long pincode;

//	@NotBlank
	private String city;

//	@NotBlank
	private long phoneNumber;

	private boolean activeStatus;
	
	private boolean approvedOrder;
	
	private boolean rejectedOrder;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(long id, @NotBlank long productId, @NotBlank long userId, @NotBlank String name,
			@NotBlank String address, @NotBlank String landmark, @NotBlank long pincode, @NotBlank String city,
			@NotBlank long phoneNumber, @NotBlank boolean activeStatus,boolean approvedOrder,boolean rejectedOrder) {
		super();
		this.id = id;
		this.productId = productId;
		this.userId = userId;
		this.name = name;
//		this.productName=productName;
		this.address = address;
		this.landmark = landmark;
		this.pincode = pincode;
		this.city = city;
		this.phoneNumber = phoneNumber;
		this.activeStatus = activeStatus;
		this.approvedOrder = approvedOrder;
		this.rejectedOrder = rejectedOrder;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public long getPincode() {
		return pincode;
	}

	public void setPincode(long pincode) {
		this.pincode = pincode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public boolean getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(boolean activeStatus) {
		this.activeStatus = activeStatus;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", productId=" + productId + ", userId=" + userId + ", name=" + name + ", address="
				+ address + ", landmark=" + landmark + ", pincode=" + pincode + ", city=" + city + ", phoneNumber="
				+ phoneNumber + "]";
	}

	public boolean isApprovedOrder() {
		return approvedOrder;
	}

	public void setApprovedOrder(boolean approvedOrder) {
		this.approvedOrder = approvedOrder;
	}

	public boolean isRejectedOrder() {
		return rejectedOrder;
	}

	public void setRejectedOrder(boolean rejectedOrder) {
		this.rejectedOrder = rejectedOrder;
	}

//	public String getProductName() {
//		return productName;
//	}
//
//	public void setProductName(String productName) {
//		this.productName = productName;
//	}

}
