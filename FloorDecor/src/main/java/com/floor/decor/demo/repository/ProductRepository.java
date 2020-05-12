package com.floor.decor.demo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.floor.decor.demo.entity.Product;
import com.floor.decor.demo.entity.User;

public interface ProductRepository extends CrudRepository<Product, Long> {
	
	public User findByName(String name);

	@Query("SELECT p.name FROM Product p WHERE p.id = :id")
 	public String findName(@Param("id") Long id);

}
