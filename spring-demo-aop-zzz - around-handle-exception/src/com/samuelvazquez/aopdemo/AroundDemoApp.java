package com.samuelvazquez.aopdemo;

import com.samuelvazquez.aopdemo.dao.AccountDAO;
import com.samuelvazquez.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AroundDemoApp {
    public static void main(String[] args) throws InterruptedException {
        //read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        //get the bean from spring container
        TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

        System.out.println("\nMain Program: AroundDemoApp");
        System.out.println("Calling getFortune");

        String data = theFortuneService.getFortune();

        System.out.println("\nMy fortune is: " + data);

        System.out.println("Finished");
        //close the context
        context.close();
    }
}
