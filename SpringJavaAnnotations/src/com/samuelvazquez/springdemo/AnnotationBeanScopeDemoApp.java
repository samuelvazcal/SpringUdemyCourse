package com.samuelvazquez.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {
    public static void main(String[] args) {
        //load spring config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //retrieve bean from spring container
        Coach alphaCoach = context.getBean("soccerCoach",Coach.class);

        Coach betaCoach = context.getBean("soccerCoach",Coach.class);

        //check if they are the same
        boolean result = (alphaCoach == betaCoach);

        //print out the results
        System.out.println("\nPointing to the same object: " + result);
        System.out.println("\nMemory location for the Coach: " + alphaCoach);
        System.out.println("\nMemory location for the alphaCoach: " + betaCoach);

        //close the context
        context.close();

    }
}
