package com.samuelvazquez.springdemo;

import org.springframework.stereotype.Component;

@Component
public class DailyMotivationService implements MotivationService {
    @Override
    public String getFortune() {
        return "Today is your lucky day!";
    }
}
