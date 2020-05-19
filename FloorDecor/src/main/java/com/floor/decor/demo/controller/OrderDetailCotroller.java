package com.floor.decor.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.support.ExampleMatcherAccessor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.floor.decor.demo.dto.OrderDetailDTO;
import com.floor.decor.demo.entity.Order;
import com.floor.decor.demo.entity.User;
import com.floor.decor.demo.payload.JwtResponse;
import com.floor.decor.demo.payload.MessageResponse;
import com.floor.decor.demo.repository.OrderDetailRpository;
import com.floor.decor.demo.service.OrderDetailService;

@RestController
@RequestMapping("api/order/")
@CrossOrigin(origins = "http://localhost:4200")
public class OrderDetailCotroller {

	@Autowired
	OrderDetailRpository orderDetailRpository;

	@Autowired
	private OrderDetailService orderDetailService;

	@GetMapping("list")
	public List<Order> getAllOrder() {
		return orderDetailRpository.findAll();
	}
	
	@GetMapping("{id}")
	public Optional<Order> getSingleOrder(@PathVariable long id) {
		return orderDetailRpository.findById(id);
	}

	@PostMapping("place")
	public Order saveOrder(@RequestBody Order order) {
		return orderDetailRpository.save(order);
	}

	@GetMapping("myorder/{id}")
	public List<OrderDetailDTO> getAllDetailOfUser(@PathVariable long id) {
		return orderDetailService.getAllDetailOfUser(id);

	}

	@GetMapping("statuschange/{id}/{number}")
	public void changeStatus(@PathVariable long id, @PathVariable int number) {

		orderDetailService.changeStatus(id, number);
	}

	@GetMapping("approved/list")
	public List<Order> getApprovedOrder() {
//		if (orderDetailService.checkApprovedList()) {
//
//			return ResponseEntity.badRequest()
//					.body(new MessageResponse("Error: Not a single order is present in approved order list!"));
//
//		} else {
			return orderDetailRpository.findApprovedOrder();
//			return ResponseEntity.ok(new MessageResponse("approved order list display successfully!"));
//		}
	}

	@GetMapping("rejected/list")
	public List<Order> getRejectedOrder(boolean rejectedOrder) {
//		int approvedOrders = 0;
//		 Order approvedOrders
//		if (orderDetailService.checkRejectedList()) {
//
//			return ResponseEntity.badRequest()
//					.body(new MessageResponse("Error: Not a single order is present in rejected order list!"));
//
//		} else {
		return	orderDetailRpository.findRejectedOrder();
//			return ResponseEntity.ok(new MessageResponse("rejected order list display successfully!"));
//		}
	}
	
	@PutMapping("update/{id}")
	public ResponseEntity<Order> getUpdateUser(@PathVariable long id, @RequestBody Order order) {
		order.setId(id);
		return ResponseEntity.ok().body(this.orderDetailService.updateOrderDetail(order));//new User(user.getUsername(),user.getEmail(),user.getPassword())
	}

}
