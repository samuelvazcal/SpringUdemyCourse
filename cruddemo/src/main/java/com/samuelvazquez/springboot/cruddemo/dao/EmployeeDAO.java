package com.samuelvazquez.springboot.cruddemo.dao;

import com.samuelvazquez.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
}
