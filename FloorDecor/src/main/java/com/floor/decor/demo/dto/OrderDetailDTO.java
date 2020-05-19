package com.floor.decor.demo.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderDetailDTO {

	@JsonProperty(value = "id")
	private Long id;

	@JsonProperty(value = "name")
	private String name;

	@JsonProperty(value = "productName")
	private String productName;

	@JsonProperty(value = "phone_number")
	private Long phoneNumber;

	@JsonProperty(value = "address")
	private String address;

//	@JsonProperty(value = "productId")
//	private String productId;
//
//	@JsonProperty(value = "userId")
//	private String userId;

	@JsonProperty(value = "landmark")
	private String landmark;

	@JsonProperty(value = "city")
	private String city;

	@JsonProperty(value = "pincode")
	private Long pincode;

//	@JsonProperty(value = "product_name")
//	private String productname;

	@JsonProperty(value = "activeStatus")
	private boolean activeStatus;

	@JsonProperty(value = "approvedOrder")
	private boolean approvedOrder;

	@JsonProperty(value = "rejectedOrder")
	private boolean rejectedOrder;

	public OrderDetailDTO(Long id, String name, String productName, Long phoneNumber, String address, String landmark,
			String city, Long pincode, boolean activeStatus,boolean approvedOrder,boolean rejectedOrder) {
		super();
		this.id = id;
		this.name = name;
		this.productName = productName;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.landmark = landmark;
		this.city = city;
		this.pincode = pincode;
		this.activeStatus = activeStatus;
		this.setApprovedOrder(approvedOrder);
		this.setRejectedOrder(rejectedOrder);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

//	public String getProductId() {
//		return productId;
//	}
//
//	public void setProductId(String productId) {
//		this.productId = productId;
//	}
//
//	public String getUserId() {
//		return userId;
//	}
//
//	public void setUserId(String userId) {
//		this.userId = userId;
//	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Long getPincode() {
		return pincode;
	}

	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}

//	public String getProductname() {
//		return productname;
//	}
//
//	public void setProductname(String productname) {
//		this.productname = productname;
//	}

	public boolean getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(boolean activeStatus) {
		this.activeStatus = activeStatus;
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

}
