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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.floor.decor.demo.entity.Product;
import com.floor.decor.demo.entity.User;
import com.floor.decor.demo.payload.MessageResponse;
import com.floor.decor.demo.repository.ProductRepository;
import com.floor.decor.demo.service.ProductService;

@RestController
@RequestMapping("api/")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductService productService;

//	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
//	@GetMapping("products")
//	public List<Product> getAllProducts() {
//		return (List<Product>) productRepository.findAll();
//	}

//	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
//	@GetMapping("products/{id}")
//	public ResponseEntity<?> getSingleProduct(@PathVariable Long id) {
//		if(productRepository.findById(id).isPresent()) {
//			
////			 productRepository.findById(id);
//			return ResponseEntity.ok(productRepository.findById(id));
//		}
//		return  ResponseEntity.badRequest().body(new MessageResponse("ERROR : product is not present"));
//		
//	}
	
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	@GetMapping("products/l")
	public ResponseEntity<?> getSingleProduct(@RequestParam(value = "id")  Long id) {
		
		if(id != null ) {
		if(productRepository.findById(id).isPresent()) {

			return ResponseEntity.ok(productRepository.findById(id));
		}
		return  ResponseEntity.badRequest().body(new MessageResponse("ERROR : product is not present"));
		}
		return ResponseEntity.ok(productRepository.findAll());
	}

	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	@PostMapping("products")
	public ResponseEntity<?> saveProduct(@RequestBody Product entity) {
		productRepository.save(entity);
		return ResponseEntity.ok(new Product(
				entity.getId(),
				entity.getImage(),
				entity.getName(),
				entity.getPrize(),
				entity.isActiveflag(),
				entity.getProductDetail()
				));
		
	}

	@GetMapping("products/productname/{id}")
	public String getFindName(@PathVariable long id) {
		return productService.getFindNameById(id);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("products/{id}")
	public ResponseEntity<Product> getUpdateProduct(@PathVariable long id, @RequestBody Product product) {
		product.setId(id);
		return ResponseEntity.ok().body(this.productService.updateProduct(product));
	}

	
//	@PreAuthorize("hasRole('ADMIN')")
//	@GetMapping("products/active")
//	public List<Product> getActiveUser() {
//		return productService.findActiveProduct();
//	}
//
//	@PreAuthorize("hasRole('ADMIN')")
//	@GetMapping("products/inactive")
//	public List<Product> getInactiveProducts() {
//		return productService.findInActiveProduct();
//	}

	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("products/p")
	public List<Product> getInactiveProducts(@RequestParam (value = "status") boolean status) {
//		if(status != null)
		return productService.findProductsByStatus(status);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("products/{id}/{number}")
	public ResponseEntity<?> changeStatus(@PathVariable long id, @PathVariable int number) {
		if (productRepository.existsById(id)) {
			productService.changeStatus(id, number);
			return ResponseEntity.ok(new MessageResponse("product status change successfully!"));
		} else {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: product does not exist!"));
		}
	}

}
