package com.samuelvazquez.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

    public static void main(String[] args) {
        //read spring config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //get the bean from spring container
        Coach volleyballCoach = context.getBean("volleyballCoach",Coach.class);
        Coach soccerCoach = context.getBean("soccerCoach",Coach.class);

        BasketballCoach basketballCoach = context.getBean("basketballCoach",BasketballCoach.class);
        Coach pingPongCoach = context.getBean("pingPongCoach",Coach.class);

        //call a method on the bean
//        System.out.println(volleyballCoach.getDailyWorkout());
//        System.out.println(volleyballCoach.getDailyMotivation());
//
//        System.out.println(basketballCoach.getEmail());
//        System.out.println(basketballCoach.getTeamName());

        System.out.println(pingPongCoach.getDailyMotivation());

        System.out.println(soccerCoach.getDailyWorkout());
        System.out.println(soccerCoach.getDailyMotivation());

        //close the context
        context.close();
    }
}
