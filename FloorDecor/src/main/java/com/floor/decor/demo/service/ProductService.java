package com.floor.decor.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.floor.decor.demo.entity.Product;
import com.floor.decor.demo.entity.User;
import com.floor.decor.demo.exception.ResourceNotFoundException;
import com.floor.decor.demo.repository.OrderDetailRpository;
import com.floor.decor.demo.repository.ProductRepository;

@Repository
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public Product updateProduct(Product product) {
		Optional<Product> productDetails = this.productRepository.findById(product.getId());

		if (productDetails.isPresent()) {
			Product productUpdate = productDetails.get();
			productUpdate.setId(product.getId());
			productUpdate.setName(product.getName());
			productUpdate.setProductDetail(product.getProductDetail());
			productUpdate.setPrize(product.getPrize());
			productRepository.save(productUpdate);
			return productUpdate;
		} else {
			throw new ResourceNotFoundException("User Not Found With This Id: " + product.getId());
		}

	}

	public String getFindNameById(long id) {
		return productRepository.findName(id);
	}

	public void changeStatus(long id, int number) {

		if (number == 0) {
			productRepository.isActive(id);
		} else {
			productRepository.isInActive(id);
		}
	}

//	public List<Product> findActiveProduct() {
//		return productRepository.findActiveProduct();
//	}
//	
//	public List<Product> findInActiveProduct() {
//		return productRepository.findInactiveProduct();
//	}
	
	public List<Product> findProductsByStatus(boolean status) {
		return productRepository.findProductsByStatus(status);
	}

}
