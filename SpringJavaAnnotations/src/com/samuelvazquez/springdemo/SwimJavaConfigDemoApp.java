package com.samuelvazquez.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {

    public static void main(String[] args) {
        //read spring config Java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

        //get the bean from spring container
        Coach theCoach = context.getBean("swimCoach",Coach.class);
        BasketballCoach anotherCoach = context.getBean("basketballCoach",BasketballCoach.class);

        System.out.println("NO XML!");
        System.out.println(theCoach.getDailyWorkout());
        System.out.println(theCoach.getDailyMotivation());

        System.out.println(anotherCoach.getTeamName());
        System.out.println(anotherCoach.getEmail());

        //close the context
        context.close();
    }
}
