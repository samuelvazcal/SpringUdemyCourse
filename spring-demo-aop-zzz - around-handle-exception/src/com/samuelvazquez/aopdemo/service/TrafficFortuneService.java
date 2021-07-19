package com.samuelvazquez.aopdemo.service;

import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class TrafficFortuneService {
    public String getFortune() throws InterruptedException {
        // simulate a delay
        TimeUnit.SECONDS.sleep(5);
        // return a fortune
        return "Message text from TrafficFortuneService";
    }

    public String getFortune(boolean tripWire) throws InterruptedException {
        if(tripWire) {
            throw new RuntimeException("Message because of a RunTimeException");
        }
        return getFortune();
    }
}
