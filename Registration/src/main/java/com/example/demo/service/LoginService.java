package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.LoginRepository;

@Service
public class LoginService {
@Autowired
private LoginRepository repo;
@Autowired
private EmployeeRepository employeeRepository;
  
  public Employee employee(String username, String password) {
  Employee user = repo.findByUsernameAndPassword(username, password);
   return user;
  }
  public void saveEmployee(Employee employee) {
		this.employeeRepository.save(employee);
		
	}
 
}