package com.floor.decor.demo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.floor.decor.demo.entity.Order;
import com.floor.decor.demo.entity.Product;
import com.floor.decor.demo.entity.User;

public interface ProductRepository extends CrudRepository<Product, Long> {
	
	public User findByName(String name);

	@Query("SELECT p.name FROM Product p WHERE p.id = :id")
 	public String findName(@Param("id") Long id);
	
	@Transactional
	@Modifying
	@Query("UPDATE Product p SET p.activeflag = 1 WHERE p.id = :id")
	public void isActive(@Param("id") long id );
	
	@Transactional
	@Modifying
	@Query("UPDATE Product p SET p.activeflag = 0 WHERE p.id = :id")
	public void isInActive(@Param("id") long id );
	
	
	@Query("SELECT p FROM Product p WHERE p.activeflag = 0")
	public List<Product> findInactiveProduct();

	@Query("SELECT p FROM Product p WHERE p.activeflag = 1")
	public List<Product> findActiveProduct();

}
