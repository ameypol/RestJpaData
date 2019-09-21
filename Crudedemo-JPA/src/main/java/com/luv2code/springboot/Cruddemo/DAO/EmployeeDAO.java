package com.luv2code.springboot.Cruddemo.DAO;

import java.util.List;

import com.luv2code.springboot.Cruddemo.entity.Employee;

public interface EmployeeDAO {
	
	public List<Employee> getList();
	
	public Employee findById(int theId);

	public void save(Employee theEmployee);

	public void deleteById(int employeeId);
}
