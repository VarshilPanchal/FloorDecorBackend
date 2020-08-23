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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.floor.decor.demo.dto.OrderDetailDTO;
import com.floor.decor.demo.dto.OrderDetailOfuser;
import com.floor.decor.demo.entity.Order;
import com.floor.decor.demo.entity.User;
import com.floor.decor.demo.payload.JwtResponse;
import com.floor.decor.demo.payload.MessageResponse;
import com.floor.decor.demo.repository.OrderDetailRpository;
import com.floor.decor.demo.service.OrderDetailService;

@RestController
@RequestMapping("api/")
@CrossOrigin(origins = "http://localhost:4200")
public class OrderDetailCotroller {

	@Autowired
	OrderDetailRpository orderDetailRpository;

	@Autowired
	private OrderDetailService orderDetailService;

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("orders")
	public List<Order> getAllOrder() {
		return orderDetailRpository.findAll();
	}

	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	@GetMapping("orders/{id}")
	public Optional<Order> getSingleOrder(@PathVariable long id) {
		return orderDetailRpository.findById(id);
	}

	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	@PostMapping("orders")
	public Order placeOrder(@RequestBody Order order) {
		return orderDetailRpository.save(order);
	}

	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	@GetMapping("orders/myorder/{id}")
	public List<?> getAllDetailOfUser(@PathVariable long id) {
		return orderDetailService.getAllDetailOfUser(id);

	}

//	@GetMapping("orders/random/{id}")
//	public List<OrderDetailDTO> random(@PathVariable long id) {
//		return orderDetailRpository.orderDetailById(id);
//
//	}

	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("orders/{id}/{number}")
	public void changeStatus(@PathVariable long id, @PathVariable int number) {

		orderDetailService.changeStatus(id, number);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("orders/approved")
	public List<Order> getApprovedOrder() {
		return orderDetailRpository.findApprovedOrder();
	}

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("orders/rejected")
	public List<Order> getRejectedOrder(boolean rejectedOrder) {

		return orderDetailRpository.findRejectedOrder();

	}

	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	@PutMapping("orders/{id}")
	public ResponseEntity<Order> getUpdateOrderDetailByUserId(@PathVariable long id, @RequestBody Order order) {
		order.setId(id);
		return ResponseEntity.ok().body(this.orderDetailService.updateOrderDetail(order));// new
																							// User(user.getUsername(),user.getEmail(),user.getPassword())
	}

	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	@DeleteMapping("orders/{id}")
	public void deleteOrderById(@PathVariable long id) {
		orderDetailRpository.deleteById(id);
	}

	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	@GetMapping("orders/s")
	public ResponseEntity<?> getOrders(@RequestParam(name = "status", required = false) boolean status) {

		if (status) {
			return ResponseEntity.ok().body(orderDetailRpository.findApprovedOrder());
		} else if (!status) {
			return ResponseEntity.ok().body(orderDetailRpository.findRejectedOrder());
		} else {
			return null;
		}

	}

	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	@GetMapping("orders/user")
	public ResponseEntity<?> getOrdersByUserId(@RequestParam(value = "id") Long id,
			@RequestParam(value = "status", required = false) Long status) {

		if (status != null) {
			if (status == 1) {
				return ResponseEntity.ok().body(orderDetailRpository.approveOrderDetailByUserId(id));
			} else if (status == 0) {
				return ResponseEntity.ok().body(orderDetailRpository.rejectOrderDetailByUserId(id));
			} else {
				return null;
			}
		} else {
			return ResponseEntity.ok().body(orderDetailRpository.orderDetailByUserId(id, false));
		}
	}

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("orders/charts")
	public Map<String, Integer> getChartDetails() {
		return orderDetailService.getChartDetails();
	}
}
