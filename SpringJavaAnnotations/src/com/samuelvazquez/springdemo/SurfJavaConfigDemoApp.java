package com.samuelvazquez.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SurfJavaConfigDemoApp {

    public static void main(String[] args) {
        //read spring config Java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SurfConfig.class);

        //get the bean from spring container
        Coach surfCoach = context.getBean("surfCoach",Coach.class);


        System.out.println("Surf Main App");
        System.out.println(surfCoach.getDailyWorkout());
        System.out.println(surfCoach.getDailyMotivation());

        //close the context
        context.close();
    }
}
