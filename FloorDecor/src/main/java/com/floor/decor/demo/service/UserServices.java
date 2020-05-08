package com.floor.decor.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.floor.decor.demo.entity.User;
import com.floor.decor.demo.exception.ResourceNotFoundException;
import com.floor.decor.demo.repository.UserRepository;

@Service
public class UserServices {

	@Autowired
	private UserRepository userRepository; 
	
	public User saveUser(User entity) {
		return userRepository.save(entity);
	}
	
	public List<User> getAllUsers(){
		return (List<User>) userRepository.findAll();
	}
	
	public Optional<User> getUserById(Long id) {
		return userRepository.findById(id);
	}
	
	public User updateUser(User user) {
		Optional<User> userDetail=this.userRepository.findById(user.getId());
		
		if(userDetail.isPresent()) {
			User userUpdate = userDetail.get();
			userUpdate.setId(user.getId());
			userUpdate.setUsername(user.getUsername());
			userUpdate.setEmail(user.getEmail());
			userUpdate.setPassword(user.getPassword());
			userRepository.save(userUpdate);
			return userUpdate;
		}else {
			throw new ResourceNotFoundException("User Not Found With This Id: "+user.getId());
		}
			
	}
	
	public boolean authenticateUser(String username,String password) {
		User user=userRepository.findByUsername(username);
			if(password.equals(user.getPassword())) {
				return true;
			}
			return false;
	}
	
	public User findByUsername(String name) {
		return userRepository.findByUsername(name);
	}
	
	public void deleteById(long id) {
//		User user = null;
//		Optional<User> userDetail=this.userRepository.findById(user.getId());
//		if(userDetail.isPresent()) {
		 userRepository.deleteById(id);
//		}else {
//			throw new ResourceNotFoundException("User Not Found With This Id: "+user.getId());
//		}
		
	}
	 
}
