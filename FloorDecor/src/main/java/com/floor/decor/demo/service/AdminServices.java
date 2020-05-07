package com.floor.decor.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.floor.decor.demo.entity.Admin;
import com.floor.decor.demo.exception.ResourceNotFoundException;
import com.floor.decor.demo.repository.AdminRepository;

@Service
public class AdminServices {
	@Autowired
	private AdminRepository adminRepository;

	public void saveAdmin(Admin entity) {
		adminRepository.save(entity);
	}

	public List<Admin> getAllAdmins() {
		return (List<Admin>) adminRepository.findAll();
	}

	public Optional<Admin> getAdminById(Long id) {
		return adminRepository.findById(id);
	}

	public Admin getUpdateAdmin(Admin admin) {
		Optional<Admin> adminDetail = this.adminRepository.findById(admin.getId());

		if (adminDetail.isPresent()) {
			Admin adminUpdate = adminDetail.get();
			adminUpdate.setId(admin.getId());
			adminUpdate.setAdminname(admin.getAdminname());
			adminUpdate.setEmail(admin.getEmail());
			adminUpdate.setPassword(admin.getPassword());
			adminRepository.save(adminUpdate);
			return adminUpdate;
		} else {
			throw new ResourceNotFoundException("Admin Not Found With This Id: " + admin.getId());
		}

	}

	public void deleteById(long id) {
//		Admin Admin = null;
//		Optional<Admin> AdminDetail=this.AdminRepository.findById(Admin.getId());
//		if(AdminDetail.isPresent()) {
		adminRepository.deleteById(id);
//		}else {
//			throw new ResourceNotFoundException("Admin Not Found With This Id: "+Admin.getId());
//		}

	}

}
