package com.samuelvazquez.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PingPongCoach implements Coach{

    @Autowired
    @Qualifier("myRandomMotivationService")
    private MotivationService motivationService;

    public PingPongCoach() {

    }

    @Override
    public String getDailyWorkout() {
        return null;
    }

    @Override
    public String getDailyMotivation() {
        return motivationService.getFortune();
    }
}
