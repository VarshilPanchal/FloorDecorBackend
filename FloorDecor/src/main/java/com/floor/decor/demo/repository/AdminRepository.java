package com.floor.decor.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.floor.decor.demo.entity.Admin;

@Repository
public interface AdminRepository extends CrudRepository<Admin, Long> {

}
