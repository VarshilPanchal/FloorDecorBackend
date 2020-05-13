package com.floor.decor.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.floor.decor.demo.dto.UserDTO;
import com.floor.decor.demo.entity.User;
import com.floor.decor.demo.repository.UserRepository;
import com.floor.decor.demo.service.UserServices;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

	@Autowired
	private UserServices userService;
	
	@Autowired
	private UserRepository userRepository;
	

//	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	@GetMapping("/user/list")
	public List<User> getAllUser() {
		return (List<User>) userRepository.findAll();
	}

//	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	@GetMapping("/user/single/{id}")
	public Optional<User> getSingleUser(@PathVariable Long id) {
		return userRepository.findById(id);
	}

//	@PostMapping(value = "/user/save")
//	public User saveUser(@RequestBody User user) {
//		return userService.saveUser(user);
//	}
	
//	@PostMapping("/user/authenticate")
//	public ResponseEntity<?> authenticateUser(@RequestBody UserDTO userDTO) {
//		return ResponseEntity.ok().body(this.userService.authenticateUser(userDTO.getusername(), userDTO.getPassword()));
//	}
//	
	@GetMapping("/user/{username}")
	public long getFindIdByname(@PathVariable String username) {
		return userService.getFindId(username);
	}
	
//	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	@PutMapping("/user/update/{id}")
	public ResponseEntity<User> getUpdateUser(@PathVariable long id, @RequestBody User user) {
		user.setId(id);
		return ResponseEntity.ok().body(this.userService.updateUser(user));//new User(user.getUsername(),user.getEmail(),user.getPassword())
	}

//	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/user/delete/{id}")
	public void deleteUser(@PathVariable long id) {
		userRepository.deleteById(id);
	}
	
	

}
