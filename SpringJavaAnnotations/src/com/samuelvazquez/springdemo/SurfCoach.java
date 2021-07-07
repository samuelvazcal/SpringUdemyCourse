package com.samuelvazquez.springdemo;

public class SurfCoach implements Coach{

    private MotivationService motivationService;

    public SurfCoach(MotivationService motivationService) {
        this.motivationService = motivationService;
    }

    @Override
    public String getDailyWorkout() {
        return "Do chin-ups, two sets of six reps each";
    }

    @Override
    public String getDailyMotivation() {
        return motivationService.getFortune();
    }
}
