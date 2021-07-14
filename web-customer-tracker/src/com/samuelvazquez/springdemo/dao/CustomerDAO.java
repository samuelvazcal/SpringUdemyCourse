package com.samuelvazquez.springdemo.dao;

import com.samuelvazquez.springdemo.entity.Customer;

import java.util.List;

public interface CustomerDAO {
    List<Customer> getCustomers();
}
