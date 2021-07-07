package com.samuelvazquez.springdemo;

public class SadMotivationService implements MotivationService{
    @Override
    public String getFortune() {
        return "Today is a rainy day";
    }
}
