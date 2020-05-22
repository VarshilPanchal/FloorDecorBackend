package com.floor.decor.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.floor.decor.demo.dto.OrderDetailDTO;
import com.floor.decor.demo.entity.Order;
import com.floor.decor.demo.entity.User;
import com.floor.decor.demo.entity.Order;
import com.floor.decor.demo.exception.ResourceNotFoundException;
import com.floor.decor.demo.repository.OrderDetailRpository;

@Service
public class OrderDetailService {

	@Autowired
	private OrderDetailRpository orderDetailRepository;
	
	@Autowired
	private UserServices userServices;
	
	
	
	public List<OrderDetailDTO> getAllDetailOfUser(Long id){
		List<OrderDetailDTO> serviceDetail = orderDetailRepository.orderDetailById(id);
		return serviceDetail;
	}
	
	public void changeStatus(long id, int number) {
		if(number==0) {
			 orderDetailRepository.isActive(id);
		}else {
			orderDetailRepository.isInActive(id);
		}
	}
	
	public boolean checkRejectedList() {
		List<Long> rejectedOrder = orderDetailRepository.existsRejectedOrder();
		if(rejectedOrder.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean checkApprovedList() {
		int approvedOrder = orderDetailRepository.existsApprovedOrder();
		if(approvedOrder>0) {
			return false;
		}else {
			return true;
		}
	}
	
	public Order updateOrderDetail(Order order) {
		Optional<Order> orderDetail = this.orderDetailRepository.findById(order.getId());

		if (orderDetail.isPresent()) {
			Order orderUpdate = orderDetail.get();
			orderUpdate.setId(order.getId());
			orderUpdate.setName(order.getName());
			orderUpdate.setAddress(order.getAddress());
			orderUpdate.setLandmark(order.getLandmark());
			orderUpdate.setCity(order.getCity());
			orderUpdate.setPincode(order.getPincode());
			orderUpdate.setPhoneNumber(order.getPhoneNumber());
			orderDetailRepository.save(orderUpdate);
			return orderUpdate;
		} else {
			throw new ResourceNotFoundException("User Not Found With This Id: " + order.getId());
		}

	}
	
	
	public Map<String, Integer> getChartDetails(){
		Map<String, Integer> orderDetail = new HashMap<String, Integer>();
		
		List<User> users = userServices.findAllUser();
		int totalOrders ;
		for (User user : users) {
			
			totalOrders = orderDetailRepository.getChartDetail(user.getId()).size() ;
			orderDetail.put(user.getUsername().toString(), (int)totalOrders);
			
		}
		
		return orderDetail;
		
	}

	
	
}
