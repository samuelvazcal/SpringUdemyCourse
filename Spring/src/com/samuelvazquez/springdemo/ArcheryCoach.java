package com.samuelvazquez.springdemo;

public class ArcheryCoach implements Coach {
    //define private field for dependency
    private MotivationService motivationService;
    private String emailAddress;
    private String team;

    //create a no-arg constructor
    public ArcheryCoach() {
        //System.out.println("You are inside the ArcheryCoach constructor");
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    //setter method, it'll be called by Spring when injecting the dependency
    public void setMotivationService(MotivationService motivationService) {
        this.motivationService = motivationService;
    }

    @Override
    public String getDailyWorkout() {
        return "Shoot 12 arrows using rubber training bands";
    }

    @Override
    public String getDailyMotivation() {
        return motivationService.getMotivation();
    }

    @Override
    public String getRandomMotivation() {
        return null;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getTeam() {
        return team;
    }
}
