package com.samuelvazquez.beanlifecycle;

import com.samuelvazquez.springdemo.Coach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleDemoApp {
    public static void main(String[] args) {
        //load the spring configuration file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanLifeCycle-applicationContext.xml");

        //retrieve bean from spring container
        Coach coachA = context.getBean("myCoach", Coach.class);

        System.out.println(coachA.getDailyWorkout());

        //close the context
        context.close();
    }
}
