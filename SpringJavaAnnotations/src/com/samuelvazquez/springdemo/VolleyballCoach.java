package com.samuelvazquez.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class VolleyballCoach implements Coach{

    @Autowired
    @Qualifier("randomMotivationService")
    private MotivationService motivationService;

    //default constructor
    public VolleyballCoach() {
    }

    @Override
    public String getDailyWorkout() {
        return "Volley the ball against the wall for 15 minutes";
    }

    @Override
    public String getDailyMotivation() {
        return motivationService.getFortune();
    }
}
