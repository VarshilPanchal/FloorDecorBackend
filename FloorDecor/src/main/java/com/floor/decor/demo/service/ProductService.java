package com.floor.decor.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.floor.decor.demo.entity.Product;
import com.floor.decor.demo.exception.ResourceNotFoundException;
import com.floor.decor.demo.repository.ProductRepository;

@Repository
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public Product updateUser(Product product) {
		Optional<Product> userDetails=this.productRepository.findById(product.getId());
		
		if(userDetails.isPresent()) {
			Product productUpdate = userDetails.get();
			productUpdate.setId(product.getId());
			productUpdate.setName(product.getName());
			productUpdate.setProductDetail(product.getProductDetail());
			productUpdate.setPrize(product.getPrize());
			productRepository.save(productUpdate);
			return productUpdate;
		}else {
			throw new ResourceNotFoundException("User Not Found With This Id: "+product.getId());
		}
			
	}
	
	public String getFindNameById(long id) {
		return productRepository.findName(id);
	}
	
	
	
	
}
