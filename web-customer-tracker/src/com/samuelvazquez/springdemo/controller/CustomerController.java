package com.samuelvazquez.springdemo.controller;

import com.samuelvazquez.springdemo.dao.CustomerDAO;
import com.samuelvazquez.springdemo.entity.Customer;
import com.samuelvazquez.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/customer")
public class CustomerController {

    //need to inject the customer service
    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomers(Model model) {
        //get customers from the service
        List<Customer> theCustomers = customerService.getCustomers();
        //add the customers to the model
        model.addAttribute("customers",theCustomers);
        return "list-customers";
    }
}
