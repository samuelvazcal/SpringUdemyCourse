package com.samuelvazquez.springdemo;

public class DailyMotivationService implements MotivationService {

    @Override
    public String getMotivation() {
        return "You're awesome!";
    }
}
