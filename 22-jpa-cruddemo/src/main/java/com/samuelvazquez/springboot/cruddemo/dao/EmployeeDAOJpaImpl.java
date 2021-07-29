package com.samuelvazquez.springboot.cruddemo.dao;

import com.samuelvazquez.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;


public class EmployeeDAOJpaImpl implements EmployeeDAO{

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOJpaImpl(@Qualifier("EmployeeDAOJpaImpl") EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll() {
        // create a query
        Query theQuery = entityManager.createQuery("from Employee");

        // execute the query and get result list
        List<Employee> employees = theQuery.getResultList();

        return employees;
    }

    @Override
    public Employee findById(int theId) {

        // get employee
        Employee employee = entityManager.find(Employee.class,theId);

        // return employee
        return employee;
    }

    @Override
    public void save(Employee theEmployee) {

        // save ou update the employee
        Employee dbEmployee = entityManager.merge(theEmployee);

        // update with id from db ... wo we can get generated id for save/insert
        theEmployee.setId(dbEmployee.getId());

    }

    @Override
    public void deleteById(int theId) {
        //delete object with primary key
        Query theQuery = entityManager.createQuery("delete from Employee where id:=employeeId");

        theQuery.setParameter("employeeId",theId);
        theQuery.executeUpdate();
    }
}
