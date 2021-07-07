package com.samuelvazquez.springdemo;

public class SwimCoach implements Coach{

    private MotivationService motivationService;

    public SwimCoach(MotivationService motivationService) {
        this.motivationService = motivationService;
    }

    @Override
    public String getDailyWorkout() {
        return "Swim 1000 meters as a warm up.";
    }

    @Override
    public String getDailyMotivation() {
        return motivationService.getFortune();
    }
}
