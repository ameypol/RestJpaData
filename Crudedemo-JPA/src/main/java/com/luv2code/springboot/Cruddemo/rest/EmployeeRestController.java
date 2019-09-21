package com.luv2code.springboot.Cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springboot.Cruddemo.entity.Employee;
import com.luv2code.springboot.Cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	
	private EmployeeService employeeService;
	
	// quick and dirty : injection employee DAO
	@Autowired
	public EmployeeRestController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}
	
	// expose "/ employee" list 
	@GetMapping("/employees")
	public List<Employee> getEmployees(){
		return employeeService.getList();
	}
	
	@PostMapping("/employees")
	public void saveEmployees(@RequestBody Employee theEmployee){
	
		employeeService.save(theEmployee);
		
	}
	
	@PutMapping("/employees")
	public void updateEmployees(@RequestBody Employee theEmployee){
	
		employeeService.save(theEmployee);
		
	}
	
	@DeleteMapping("/employees/{theId}")
	public void deleteEmployees(@PathVariable int theId){
		employeeService.deleteById(theId);	
	}
	
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployeesById(@PathVariable int employeeId){
		return employeeService.findById(employeeId);
	}
	
	
}
