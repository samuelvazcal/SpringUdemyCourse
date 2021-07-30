package com.samuelvazquez.springboot.thymeleafdemo.controller;

import com.samuelvazquez.springboot.thymeleafdemo.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private List<Employee> employees;

    @PostConstruct
    private void loadData() {
        // create employees
        Employee emp1 = new Employee(1,"Michael","Scott","michael.s@test.com");
        Employee emp2 = new Employee(2,"Pam","Beesly","pam.b@test.com");
        Employee emp3 = new Employee(3,"Jim","Halpert","jim.h@test.com");
        Employee emp4 = new Employee(4,"Dwight","Schrute","dwight.s@test.com");
        Employee emp5 = new Employee(5,"Stanley","Hudson","stanley.h@test.com");
        // create the list
        employees = new ArrayList<>();
        // add to the list
        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);
        employees.add(emp4);
        employees.add(emp5);
    }
    // load employee data
    @GetMapping("/list")
    public String listEmployees (Model theModel) {
        // add to the spring model
        theModel.addAttribute("employees",employees);

        return "list-employees";
    }
}
