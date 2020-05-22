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

import com.floor.decor.demo.entity.User;
import com.floor.decor.demo.repository.UserRepository;
import com.floor.decor.demo.service.UserServices;

@RestController
@RequestMapping("api/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

	@Autowired
	private UserServices userService;

	@Autowired
	private UserRepository userRepository;

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/list")
	public List<User> getAllUser() {
		return (List<User>) userRepository.findAll();
	}

	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	@GetMapping("/single/{id}")
	public Optional<User> getSingleUser(@PathVariable Long id) {
		return userRepository.findById(id);
	}

	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	@GetMapping("/{username}")
	public long getFindIdByname(@PathVariable String username) {
		return userService.getFindId(username);
	}

	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	@PutMapping("/update/{id}")
	public ResponseEntity<User> getUpdateUser(@PathVariable long id, @RequestBody User user) {
		user.setId(id);
		return ResponseEntity.ok().body(this.userService.updateUserDetail(user));// new
																			// User(user.getUsername(),user.getEmail(),user.getPassword())
	}

	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	@GetMapping("/updatestatus/{id}/{number}")
	public void changeStatus(@PathVariable long id, @PathVariable int number) {

		userService.changeStatus(id, number);

	}

	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/delete/{id}")
	public void deleteUserById(@PathVariable long id) {
		userRepository.deleteById(id);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/active")
	public List<User> getActiveUser() {
		return userService.findActiveUser();
	}

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/inactive")
	public List<User> getInactiveUser() {
		return userService.findInactiveUser();
	}

	@GetMapping("username")
	public List<String> getUsername() {
		return userRepository.findUsername();
	}

	@PutMapping("editpassword/{id}")
	public ResponseEntity<User> editPassword(@PathVariable("id") Long id, @RequestBody User user) {
		
		user.setId(id);
		return ResponseEntity.ok().body(this.userService.updateUserPassword(user));

		
	}

}
