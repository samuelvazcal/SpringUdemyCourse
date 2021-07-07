package com.samuelvazquez.springdemo;

public class FinalMotivationService implements MotivationService{
    @Override
    public String getFortune() {
        return "This is the MotivationService implementation";
    }
}
