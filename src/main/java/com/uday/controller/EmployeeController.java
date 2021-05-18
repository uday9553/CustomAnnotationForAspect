package com.uday.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uday.model.Employee;
import com.uday.service.EmployeeService;

@RestController
@RequestMapping(value="/employee")
public class EmployeeController {
	
	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService=employeeService;
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Employee>> getEmployees(){
		return employeeService.fetchAll();
	}
	
	@GetMapping("/getempame/{id}")
	public Employee getEmployee(@PathVariable("id") Long id){
		System.out.println("id is "+id);
		return employeeService.getEmpName(id);
	}
	
}
 