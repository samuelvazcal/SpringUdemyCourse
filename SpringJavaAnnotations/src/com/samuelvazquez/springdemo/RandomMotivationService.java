package com.samuelvazquez.springdemo;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomMotivationService implements MotivationService{

    //create an array of strings
    private String [] data = {"Motivation Message 1","Motivation Message 2","Motivation Message 3"};

    //create a random number generator

    private Random myRandom = new Random();



    @Override
    public String getFortune() {
        //pick a random string from the array
        int index = myRandom.nextInt(data.length);
        return data[index];
    }
}
