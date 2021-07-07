package com.samuelvazquez.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ActivityDI {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        SoccerCoach soccerCoach = context.getBean("mySoccerCoach",SoccerCoach.class);

        System.out.println(soccerCoach.getRandomMotivation());
        System.out.println(soccerCoach.getRandomMotivation());
        System.out.println(soccerCoach.getRandomMotivation());

        context.close();
    }
}
