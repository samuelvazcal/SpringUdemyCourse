package com.samuelvazquez.springdemo;

import org.springframework.beans.factory.annotation.Value;

public class BasketballCoach implements Coach{

    @Value("${foo.team}")
    private String teamName;

    @Value("${foo.email}")
    private String email;

    public String getTeamName() {
        return teamName;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String getDailyWorkout() {
        return "custom message for basketball coach getDailyWorkout";
    }

    @Override
    public String getDailyMotivation() {
        return "custom message for basketball coach getDailyMotivation";
    }
}
