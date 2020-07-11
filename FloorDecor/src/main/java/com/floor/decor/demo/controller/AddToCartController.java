package com.floor.decor.demo.controller;

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

import com.floor.decor.demo.entity.AddToCart;
import com.floor.decor.demo.repository.AddToCartRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class AddToCartController {

	@Autowired
	private AddToCartRepository addToCartRepository;

	@GetMapping("/cart")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public Iterable<AddToCart> allAccess() {
		return addToCartRepository.findAll();
	}

	@GetMapping("/cart/product/{id}")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public Optional<AddToCart> getCartDetailById(@PathVariable long id) {
		return addToCartRepository.findById(id);
	}

	@PostMapping("/cart")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public ResponseEntity<?> addToCart(@RequestBody AddToCart entity) {
		addToCartRepository.save(entity);
		return ResponseEntity.ok(new AddToCart(
				entity.getId(), 
				entity.getCount(),
				entity.getAmount(),
				entity.getUserId(),
				entity.getProduct()));
	}

	@PutMapping("/cart/remove/{id}")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public void removeCartByUserId(@PathVariable long id) {
		addToCartRepository.removeItem(id);
		System.out.println("remove succesfully");
	}

	@GetMapping("/cart/{id}")
	public ResponseEntity<?> getCartByIserId(@PathVariable long id) {

		return ResponseEntity.ok().body(addToCartRepository.getCartItem(id));
	}

}
