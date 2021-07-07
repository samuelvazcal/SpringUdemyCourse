package com.samuelvazquez.springdemo;

public class TrackCoach implements Coach{
    //define a private field for the dependency
    private MotivationService motivationService;

    public TrackCoach() {
    }
    //define a constructor for dependency injection (DI)
    public TrackCoach(MotivationService motivationService) {
        this.motivationService = motivationService;
    }

    @Override
    public String getDailyWorkout() {
        return "Run a hard 5k";
    }

    @Override
    public String getDailyMotivation() {
        return motivationService.getMotivation();
    }

    @Override
    public String getRandomMotivation() {
        return null;
    }

    //add an init method
    public void doCustomInitMethod() {
        System.out.println("TrackCoach: inside method doCustomInitMethod");
    }
    //add a destroy method
    public void doCustomDestroyMethod() {
        System.out.println("TrackCoach: inside method doCustomDestroyMethod");
    }
}
