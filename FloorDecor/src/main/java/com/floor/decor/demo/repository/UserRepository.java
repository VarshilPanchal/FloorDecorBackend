package com.floor.decor.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.floor.decor.demo.entity.User;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
	public User findByUsername(String username);

}
