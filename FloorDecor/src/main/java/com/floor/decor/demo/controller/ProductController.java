package com.floor.decor.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
import com.floor.decor.demo.repository.ProductRepository;
import com.floor.decor.demo.service.ProductService;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductService productService;

	@GetMapping("/product/list")
	public List<Product> getAllUser() {
		return (List<Product>) productRepository.findAll();
	}
	
	@GetMapping("/product/{id}")
	public Optional<Product> getSingleUser(@PathVariable Long id) {
		return productRepository.findById(id);
	}
	
	@PostMapping("/product/save")
	public Product saveProduct(@RequestBody Product entity) {
		return productRepository.save(entity);
	}
	
	@GetMapping("/product/productname/{id}")
	public String getFindName(@PathVariable long id) {
		return productService.getFindNameById(id);
	}
	
	@PutMapping("/product/update/{id}")
	public ResponseEntity<Product> getUpdateUser(@PathVariable long id, @RequestBody Product product) {
		product.setId(id);
		return ResponseEntity.ok().body(this.productService.updateUser(product));
	}
	
}
