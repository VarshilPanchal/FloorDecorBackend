package com.floor.decor.demo.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.floor.decor.demo.entity.User;
import com.floor.decor.demo.jwt.JwtRequest;
import com.floor.decor.demo.jwt.JwtResponse;
import com.floor.decor.demo.jwt.JwtTokenUtil;
import com.floor.decor.demo.service.UserServices;



//@CrossOrigin(origins = "http://localhost:4200")
@RestController
//@RequestMapping({ "/employeesjwt" })
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserServices userDetailsService;
//
//	
//	@Autowired
//	RegistrationService registrationService;
//	Registration registration;
//	
//	@RequestMapping("/registration/List")
//	public List<DAOUser> getUser(){
//		return (List<DAOUser>) registrationService.getAllUser();
//	}
//	
//	@PostMapping("/users")
//	public void addUser(@RequestBody DAOUser user) {
//		registrationService.addUser(user);
//	}
//	
//	@RequestMapping(value = "/users/{userName}",method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//	public List<DAOUser> getSingleUser(@PathVariable String userName){
//		return registrationService.getSingleUser(userName);
//	}
//		 
//	@PutMapping("/users/{id}")
//	public void updateUser(@RequestBody DAOUser user,@PathVariable Long id) {
//		registrationService.updateUser(id, user);
//	}
//	
//	@DeleteMapping("users/{id}")
//	public void deleteUser(@PathVariable Long id) {
//		registrationService.deleteUser(id);
//	}
//	
//	@RequestMapping("users/name/{name}")
//	public DAOUser findByUserName(@PathVariable String name) {
//		return registrationService.findByUserName(name);
//	}

	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new JwtResponse(token));
	}
	
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody User user) throws Exception {
		return ResponseEntity.ok(userDetailsService.save(user));
	}

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}