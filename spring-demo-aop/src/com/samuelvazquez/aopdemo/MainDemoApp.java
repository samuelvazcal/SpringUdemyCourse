package com.samuelvazquez.aopdemo;

import com.samuelvazquez.aopdemo.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {
    public static void main(String[] args) {
        //read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        //get the bean business method
        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
        //call the business method
        theAccountDAO.addAccount();
        // do it again!
        System.out.println("\n let's call it again!");
        theAccountDAO.addAccount();
        //close the context
        context.close();
    }
}
