package com.samuelvazquez.sundayexercise;

public class CaloriesInformationService implements InformationService {

    @Override
    public String getNutritionFacts(int value) {
        double result = value * 0.001;
        return String.valueOf(result);
    }
}
