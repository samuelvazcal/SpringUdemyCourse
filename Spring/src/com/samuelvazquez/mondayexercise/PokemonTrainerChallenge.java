package com.samuelvazquez.mondayexercise;

public class PokemonTrainerChallenge implements Challenge{
    //define the field dependency
    private TipService tipService;

    public PokemonTrainerChallenge() {

    }

    public void setTipService(TipService tipService) {
        this.tipService = tipService;
    }

    @Override
    public String getBreederChallenge() {
        return "Hatch 5 Pidgey eggs";
    }

    @Override
    public String getATip() {
        return tipService.getHelpfulTip();
    }

    public void doCustomInitMethod() {
        System.out.println("Connecting to the database");
    }

    public void doCustomDestroyMethod() {
        System.out.println("Closing connection to the database");
    }
}
