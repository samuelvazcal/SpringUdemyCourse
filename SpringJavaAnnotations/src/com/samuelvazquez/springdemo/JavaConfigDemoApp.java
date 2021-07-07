package com.samuelvazquez.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {

    public static void main(String[] args) {
        //read spring config Java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

        //get the bean from spring container
        Coach soccerCoach = context.getBean("soccerCoach",Coach.class);

        System.out.println("NO XML!");
        System.out.println(soccerCoach.getDailyWorkout());
        System.out.println(soccerCoach.getDailyMotivation());

        //close the context
        context.close();
    }
}
