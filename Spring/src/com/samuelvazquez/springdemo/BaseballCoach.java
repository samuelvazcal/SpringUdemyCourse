package com.samuelvazquez.springdemo;

public class BaseballCoach implements Coach{

    //define a private field for the dependency
    private MotivationService motivationService;

    //define a constructor for dependency injection
    public BaseballCoach(MotivationService motivationService) {
        this.motivationService = motivationService;
    }

    @Override
    public String getDailyWorkout() {
        return "Spend 30 minutes on batting practice";
    }

    @Override
    public String getDailyMotivation() {
        return motivationService.getMotivation();
    }

    @Override
    public String getRandomMotivation() {
        return null;
    }
}
