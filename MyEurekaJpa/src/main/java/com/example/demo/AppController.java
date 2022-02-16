package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
	
	@Autowired
	EmpRepo empRepo;
	
	@GetMapping("getEmp/{id}")
	public Employee getEmp(@PathVariable int id) {
		
		return empRepo.findById(id).get();
	}

}
