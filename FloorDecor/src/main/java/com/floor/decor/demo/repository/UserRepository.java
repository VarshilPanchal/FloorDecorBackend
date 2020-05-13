package com.floor.decor.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.floor.decor.demo.entity.User;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
//	public User findByUsernames(String username);
//
//	@Query("SELECT u.id FROM User u WHERE u.username = :username")
// 	public long findId(@Param("username") String username);
	
//	public User findByUsername(String username);

	@Query("SELECT u.id FROM User u WHERE u.username = :username")
 	public long findId(@Param("username") String username);


	
	Optional<User> findByUsername(String username);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);
	
//	List<User> isUserActive(List<User> user);
	
}
