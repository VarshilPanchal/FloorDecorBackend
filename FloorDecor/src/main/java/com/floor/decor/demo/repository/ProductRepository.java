package com.floor.decor.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.floor.decor.demo.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
	
	

}
