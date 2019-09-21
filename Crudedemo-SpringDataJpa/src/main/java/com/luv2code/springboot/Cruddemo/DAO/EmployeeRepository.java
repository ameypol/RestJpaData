package com.luv2code.springboot.Cruddemo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.springboot.Cruddemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
