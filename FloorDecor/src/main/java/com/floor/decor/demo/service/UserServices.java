package com.floor.decor.demo.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.AuthorityUtils;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.floor.decor.demo.entity.User;
import com.floor.decor.demo.exception.ResourceNotFoundException;
import com.floor.decor.demo.repository.UserRepository;

@Service
public class UserServices {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder bcryptEncoder;

//	public User saveUser(User entity) {
//		return userRepository.save(entity);
//	}

	public List<User> getAllUsers() {
		return (List<User>) userRepository.findAll();
	}

	public Optional<User> getUserById(Long id) {
		return userRepository.findById(id);
	}

	public User updateUser(User user) {
		Optional<User> userDetail = this.userRepository.findById(user.getId());

		if (userDetail.isPresent()) {
			User userUpdate = userDetail.get();
			userUpdate.setId(user.getId());
			userUpdate.setUsername(user.getUsername());
			userUpdate.setEmail(user.getEmail());
			userUpdate.setPassword(bcryptEncoder.encode(user.getPassword()));
			userRepository.save(userUpdate);
			return userUpdate;
		} else {
			throw new ResourceNotFoundException("User Not Found With This Id: " + user.getId());
		}

	}

//	public boolean authenticateUser(String username, String password) {
//		User user = userRepository.findByUsername(username);
//		if (password.equals(user.getPassword())) {
//			return true;
//		}
//		return false;
//	}
//
	public long getFindId(String username) {
		return userRepository.findId(username);
	}

//	public User findByUsername(String name) {
//		return userRepository.findByUsername(name);
//	}

	public void deleteById(long id) {
//		User user = null;
//		Optional<User> userDetail=this.userRepository.findById(user.getId());
//		if(userDetail.isPresent()) {
		userRepository.deleteById(id);
//		}else {
//			throw new ResourceNotFoundException("User Not Found With This Id: "+user.getId());
//		}

	}


//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		User user = userRepository.findByUsername(username);
////				.orElseThrow(() -> new UsernameNotFoundException("Email " + userName + " not found"));
//		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
//				getAuthorities(user));
//	}
//
//	private static Collection<? extends GrantedAuthority> getAuthorities(User user) {
//		String[] userRoles = user.getRoles().stream().map((role) -> role.getName()).toArray(String[]::new);
//		Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(userRoles);
//		return authorities;
//	}

//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		User user = userRepository.findByUsername(username);
//		if (user == null) {
//			throw new UsernameNotFoundException("User not found with username: " + username);
//		}
//		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
//				new ArrayList<>());
//	}
//	
//	public User save(User user) {
////		DAOUser newUser = new DAOUser();
//		user.getUsername();
//		user.setPassword(bcryptEncoder.encode(user.getPassword()));
//		return userRepository.save(user);
//	}

}
