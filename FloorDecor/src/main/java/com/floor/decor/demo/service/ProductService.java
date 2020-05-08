package com.floor.decor.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.floor.decor.demo.repository.UserRepository;

@Repository
public class ProductService {

	@Autowired
	private UserRepository userRepository;
	

}
