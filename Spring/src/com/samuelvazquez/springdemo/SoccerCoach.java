package com.samuelvazquez.springdemo;

public class SoccerCoach implements Coach{
    private RandomMotivationService random;

    public SoccerCoach () {
    }

    public void setRandomMotivationService(RandomMotivationService random) {
        this.random = random;
    }

    @Override
    public String getDailyWorkout() {
        return "first method";
    }

    @Override
    public String getDailyMotivation() {
        return "second method";
    }

    @Override
    public String getRandomMotivation() {
        return random.getMotivation();
    }
}
