package com.floor.decor.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.floor.decor.demo.entity.Product;
import com.floor.decor.demo.entity.User;
import com.floor.decor.demo.payload.MessageResponse;
import com.floor.decor.demo.repository.ProductRepository;
import com.floor.decor.demo.service.ProductService;

@RestController
@RequestMapping("api/product/")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductService productService;

	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	@GetMapping("list")
	public List<Product> getAllUser() {
		return (List<Product>) productRepository.findAll();
	}

	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	@GetMapping("{id}")
	public Optional<Product> getSingleUser(@PathVariable Long id) {
		return productRepository.findById(id);
	}

	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	@PostMapping("save")
	public Product saveProduct(@RequestBody Product entity) {
		return productRepository.save(entity);

	}

	@GetMapping("productname/{id}")
	public String getFindName(@PathVariable long id) {
		return productService.getFindNameById(id);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("update/{id}")
	public ResponseEntity<Product> getUpdateUser(@PathVariable long id, @RequestBody Product product) {
		product.setId(id);
		return ResponseEntity.ok().body(this.productService.updateUser(product));
	}

	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("active")
	public List<Product> getActiveUser() {
		return productService.findActiveProduct();
	}

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("inactive")
	public List<Product> getInactiveUser() {
		return productService.findInActiveProduct();
	}

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("changestatus/{id}/{number}")
	public ResponseEntity<?> changeStatus(@PathVariable long id, @PathVariable int number) {
		if (productRepository.existsById(id)) {
			productService.changeStatus(id, number);
			return ResponseEntity.ok(new MessageResponse("product status change successfully!"));
		} else {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: product does not exist!"));
		}
	}

}
