package com.samuelvazquez.springdemo;

import java.util.Random;

public class RandomMotivationService implements MotivationService{

    @Override
    public String getMotivation() {
        String [] array = {"Motivational Message 1","Motivational Message 2", "Motivational Message 3"};
        Random random = new Random();
        int output = random.nextInt(3);
        return array[output];
    }
}
