package com.floor.decor.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.floor.decor.demo.entity.Product;
import com.floor.decor.demo.repository.ProductRepository;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;

	@GetMapping("/product/list")
	public List<Product> getAllUser() {
		return (List<Product>) productRepository.findAll();
	}
	
}
