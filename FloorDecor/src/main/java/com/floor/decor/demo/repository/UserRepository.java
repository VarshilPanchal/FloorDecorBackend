package com.floor.decor.demo.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.floor.decor.demo.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

//	public User findByUsernames(String username);

	@Query("SELECT u FROM User u WHERE u.username = :username")
 	public User findUser(@Param("username") String username);

//	public User findByUsername(String username);

//	@Query("SELECT u FROM User u WHERE u.username = :username")
//	public long findId(@Param("username") String username);
	
	@Query("SELECT u.username FROM User u ")
	public List<String> findUsername();
	
//	@Query("SELECT u.username FROM User u ")
//	public List<String> findUsername();

	
	@Query("SELECT u.id FROM User u WHERE u.username = :username")
	public long findId(@Param("username") String username);

	@Query("SELECT u FROM User u WHERE u.isActive = 0")
	public List<User> findInactiveUser();

	@Query("SELECT u FROM User u WHERE u.isActive = 1")
	public List<User> findActiveUser();
	
	@Transactional
	@Modifying
	@Query("UPDATE User u SET u.isActive = 1 WHERE u.id = :id")
	public void isActive(@Param("id") long id );
	
	@Transactional
	@Modifying
	@Query("UPDATE User u SET u.isActive = 0 WHERE u.id = :id")
	public void isInActive(@Param("id") long id );
	

	Optional<User> findByUsername(String username);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);

//	List<User> isUserActive(List<User> user);

}
