package com.floor.decor.demo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.floor.decor.demo.entity.AddToCart;

@Repository
public interface AddToCartRepository extends CrudRepository<AddToCart, Long> {

	@Transactional
	@Modifying
	@Query("DELETE FROM AddToCart a WHERE a.userId = :id")
	public void removeItem(@Param("id") Long id);

	@Query("SELECT a FROM AddToCart a WHERE a.userId = :id")
	public List<AddToCart> getCartItem(@Param("id") Long id);

}
