package com.samuelvazquez.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CyclingCoach implements Coach{

    private MotivationService motivationService;

    public CyclingCoach () {
    }

    @Autowired
    @Qualifier("dailyMotivationService")
    public void setMotivationService(MotivationService motivationService) {
        this.motivationService = motivationService;
    }

//    @Autowired
//    public void doSomeCrazyStuff(MotivationService motivationService) {
//        System.out.println("<------>");
//        this.motivationService = motivationService;
//    }

    @Override
    public String getDailyWorkout() {
        return "Do planks, hold times of 30-60 seconds per round";
    }

    @Override
    public String getDailyMotivation() {
        return "Just do it!";
    }
}
