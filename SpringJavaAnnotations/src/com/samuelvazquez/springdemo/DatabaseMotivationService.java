package com.samuelvazquez.springdemo;

import org.springframework.stereotype.Component;

@Component
public class DatabaseMotivationService implements MotivationService{
    @Override
    public String getFortune() {
        return null;
    }
}
