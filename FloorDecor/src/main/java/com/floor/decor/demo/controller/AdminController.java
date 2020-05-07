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
import com.floor.decor.demo.entity.Admin;
import com.floor.decor.demo.service.AdminServices;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {
	
	@Autowired
	private AdminServices adminServices;
	
	@GetMapping("/list")
	public List<Admin> getAllAdmin() {
		return adminServices.getAllAdmins();
	}
	
	@GetMapping("/admin/{id}")
	public Optional<Admin> getSingleAdmin(@PathVariable Long id) {
		return adminServices.getAdminById(id);
	}
	
	@PostMapping(value = "/admin/save")//, consumes = "application/json", produces = "application/json"
	public void saveAdmin(@RequestBody Admin entity) {
		 adminServices.saveAdmin(entity);
	}
	
	@PutMapping("/update/admin/{id}")
	public ResponseEntity<Admin> getUpdateAdmin(@PathVariable long id, @RequestBody Admin admin) {
		admin.setId(id);
		return ResponseEntity.ok().body(this.adminServices.getUpdateAdmin(admin));
	}
	
	@DeleteMapping("delete/admin/{id}")
	public String deleteAdmin(@PathVariable long id) {
		adminServices.deleteById(id);
		return "succesfully delete id:" + id;
	}

}
