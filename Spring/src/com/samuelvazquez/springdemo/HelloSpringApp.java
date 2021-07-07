package com.samuelvazquez.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {
    public static void main(String[] args) {
        //load the spring configuration file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //retrieve bean from spring container
        Coach coach = context.getBean("myCoach",Coach.class);
        Coach coach2 = context.getBean("myTrackCoach",Coach.class);

        ArcheryCoach coach3 = context.getBean("myArcheryCoach",ArcheryCoach.class);
        //call methods on the bean
        System.out.println(coach.getDailyWorkout());
        System.out.println(coach.getDailyMotivation());
        System.out.println(coach2.getDailyWorkout());
        System.out.println(coach2.getDailyMotivation());

        System.out.println(coach3.getDailyWorkout());
        System.out.println(coach3.getDailyMotivation());
        System.out.println(coach3.getEmailAddress());
        System.out.println(coach3.getTeam());
        //close context
        context.close();
    }
}
