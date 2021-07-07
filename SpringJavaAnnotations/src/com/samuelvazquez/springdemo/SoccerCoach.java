package com.samuelvazquez.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//@Component("mySoccerCoach")
@Component
//@Scope("prototype")
public class SoccerCoach implements Coach {

    private MotivationService motivationService;

    public SoccerCoach() {
    }

    @Autowired
    public SoccerCoach(@Qualifier("randomMotivationService") MotivationService motivationService) {
        this.motivationService = motivationService;
    }

    @Override
    public String getDailyWorkout() {
        return "Practice One-touch shooting for 20 minutes";
    }

    @Override
    public String getDailyMotivation() {
        return motivationService.getFortune();
    }

    //define my init method
    @PostConstruct
    public void doMyInitStuff() {
        System.out.println(">>SoccerCoach: inside doMyInitStuff()");
    }

    //define my destroy method
    @PreDestroy
    public void doMyCleanupStuff() {
        System.out.println(">>SoccerCoach: inside doMyCleanupStuff()");
    }
}
