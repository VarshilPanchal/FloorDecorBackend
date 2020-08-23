package com.floor.decor.demo.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.floor.decor.demo.entity.AddToCart;

public class OrderDetailOfuser {

	@JsonProperty(value = "id")
	private Long id;

	@JsonProperty(value = "name")
	private String name;

	@JsonProperty(value = "userId")
	private long userId;

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

	@JsonProperty(value = "cartDetail")
	private List<?> cartDetail;

	public OrderDetailOfuser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderDetailOfuser(Long id, long userId, String name, Long phoneNumber, String address, String landmark,
			String city, Long pincode, boolean activeStatus, boolean approvedOrder, boolean rejectedOrder
//			,List<?> cartDetail
	) {
		super();
		this.id = id;
		this.userId = userId;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.landmark = landmark;
		this.city = city;
		this.pincode = pincode;
		this.activeStatus = activeStatus;
		this.approvedOrder = approvedOrder;
		this.rejectedOrder = rejectedOrder;
//		this.cartDetail = cartDetail;
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

	public boolean isActiveStatus() {
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

	public List<?> getCartDetail() {
		return cartDetail;
	}

	public void setCartDetail(List<AddToCart> cartDetail) {
		this.cartDetail = cartDetail;
	}

}
