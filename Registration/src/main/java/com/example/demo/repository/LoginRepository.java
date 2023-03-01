package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Employee;

@Repository
public interface LoginRepository extends JpaRepository<Employee, Long>{
	Employee findByUsernameAndPassword(String username, String password);

}