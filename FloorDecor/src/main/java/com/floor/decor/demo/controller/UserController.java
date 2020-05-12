package com.floor.decor.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
import com.floor.decor.demo.service.UserServices;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

	@Autowired
	private UserServices userService;
	
	

	@GetMapping("/user/list")
	public List<User> getAllUser() {
		return userService.getAllUsers();
	}

	@GetMapping("/user/{id}")
	public Optional<User> getSingleUser(@PathVariable Long id) {
		return userService.getUserById(id);
	}

	@PostMapping(value = "/save/user")
	public User saveUser(@RequestBody User user) {
		return userService.save(user);
	}
	
//	@PostMapping("/authenticate/user")
//	public ResponseEntity<?> authenticateUser(@RequestBody UserDTO userDTO) {
//		return ResponseEntity.ok().body(this.userService.authenticateUser(userDTO.getusername(), userDTO.getPassword()));
//	}
	
	@GetMapping("{username}")
	public long getFindId(@PathVariable String username) {
		return userService.getFindId(username);
	}

	@PutMapping("/update/user/{id}")
	public ResponseEntity<User> getUpdateUser(@PathVariable long id, @RequestBody User user) {
		user.setId(id);
		return ResponseEntity.ok().body(this.userService.updateUser(user));
	}

	@DeleteMapping("delete/user/{id}")
	public void deleteUser(@PathVariable long id) {
		userService.deleteById(id);
	}

}
