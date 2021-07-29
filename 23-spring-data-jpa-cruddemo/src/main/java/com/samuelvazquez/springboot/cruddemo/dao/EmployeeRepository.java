package com.samuelvazquez.springboot.cruddemo.dao;

import com.samuelvazquez.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}
