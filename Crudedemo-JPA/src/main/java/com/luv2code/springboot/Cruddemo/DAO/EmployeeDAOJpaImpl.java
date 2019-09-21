package com.luv2code.springboot.Cruddemo.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.Cruddemo.entity.Employee;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOJpaImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	
	@Override
	public List<Employee> getList() {
		// create quert 
		Query theQuery = entityManager.createQuery("from Employee");
		// execute qyery
		List<Employee> theEmployee = theQuery.getResultList();
		// return results
		
		return theEmployee;
	}

	@Override
	public Employee findById(int theId) {
		// get employee
		Employee theEmployee =
				entityManager.find(Employee.class, theId);
		// return employee

		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		// save update employee
		Employee dbEmployee =
				entityManager.merge(theEmployee);
		 
		// update with id from db
		theEmployee.setId(dbEmployee.getId());
	
	}

	@Override
	public void deleteById(int employeeId) {
		// edlete by id
		Query theQuery = entityManager.createQuery("delete from Employee where id=:employeeId");
		theQuery.setParameter("employeeId", employeeId);
		theQuery.executeUpdate();
		
	}

}
