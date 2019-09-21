package com.luv2code.springboot.Cruddemo.DAO;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.Cruddemo.entity.Employee;


@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	// define fileds for entitymanager
	@Autowired
	private EntityManager entityManager;
	
	// set up constructor injection
	// the entity manager class is generated automatically by spring boot
	
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	
	@Override
	public List<Employee> getList() {
	
		// get the current hibernate sessin
		Session currentSession = entityManager.unwrap(Session.class);
		
		// create query
		Query<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class);
		
		// execute query and get results
		List<Employee> employees = theQuery.getResultList();
		//return the results
		return employees;
	}

	@Override
	public void save(Employee theEmployee) {
		
		// get the current hibernate sessin
		Session currentSession = entityManager.unwrap(Session.class);
		
		// save employee
		currentSession.saveOrUpdate(theEmployee);
	}


	@Override
	public void deleteById(int theId) {
		// get the current hibernate sessin
		Session currentSession = entityManager.unwrap(Session.class);
		// create query
		Query theQuery = currentSession.createQuery("delete from Employee where id=:employeeId");
		theQuery.setParameter("employeeId", theId);
		
		theQuery.executeUpdate();					
	}


	@Override
	public Employee findById(int theId) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
				
		// create query
		Employee theEmployee = currentSession.get(Employee.class, theId);
		
		//return the results
		return theEmployee;
	
	}

}
