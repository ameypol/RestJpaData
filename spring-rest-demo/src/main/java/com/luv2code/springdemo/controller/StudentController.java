package com.luv2code.springdemo.controller;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Student;
import com.luv2code.springdemo.rest.StudentNotFoundException;

@RestController
@RequestMapping("/api")
public class StudentController {
	
	List<Student> theStudent; 
	
	@PostConstruct
	public void loadData() {
		
	theStudent = new ArrayList<>(); 	
	theStudent.add(new Student("amey","pol","amey.pol86"));
	theStudent.add(new Student("ame","po","ame"));
	theStudent.add(new Student("am","p","amey86"));
	}

	@GetMapping("/students")
	public List<Student> getStudent(){
		
		    return theStudent;
	}
	
	@GetMapping("/student/{id}")
	public Student getStudentById(@PathVariable("id") int studentId) {
		
		if ((studentId >= theStudent.size()) ||(studentId < 0)) {
		throw new StudentNotFoundException("Student id not found- "+ studentId);	
		}
		return theStudent.get(studentId);
	}
	
	

}
