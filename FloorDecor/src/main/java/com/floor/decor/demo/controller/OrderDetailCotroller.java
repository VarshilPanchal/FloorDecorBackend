package com.floor.decor.demo.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.support.ExampleMatcherAccessor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("list")
	public List<Order> getAllOrder() {
		return orderDetailRpository.findAll();
	}
	
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	@GetMapping("{id}")
	public Optional<Order> getSingleOrder(@PathVariable long id) {
		return orderDetailRpository.findById(id);
	}

	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	@PostMapping("place")
	public Order placeOrder(@RequestBody Order order) {
		return orderDetailRpository.save(order);
	}

	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	@GetMapping("myorder/{id}")
	public List<OrderDetailDTO> getAllDetailOfUser(@PathVariable long id) {
		return orderDetailService.getAllDetailOfUser(id);

	}

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("statuschange/{id}/{number}")
	public void changeStatus(@PathVariable long id, @PathVariable int number) {

		orderDetailService.changeStatus(id, number);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("approved/list")
	public List<Order> getApprovedOrder() {
		return orderDetailRpository.findApprovedOrder();	
	}

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("rejected/list")
	public List<Order> getRejectedOrder(boolean rejectedOrder) {

		return	orderDetailRpository.findRejectedOrder();

	}
	
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	@PutMapping("update/{id}")
	public ResponseEntity<Order> getUpdateUser(@PathVariable long id, @RequestBody Order order) {
		order.setId(id);
		return ResponseEntity.ok().body(this.orderDetailService.updateOrderDetail(order));//new User(user.getUsername(),user.getEmail(),user.getPassword())
	}
	
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	@DeleteMapping("delete/{id}")
	public void deleteOrderById(@PathVariable long id) {
		orderDetailRpository.deleteById(id);
	}
	
	@GetMapping("charts")
	public Map<String, Integer> getChartDetails(){
		return orderDetailService.getChartDetails();
	}

}
