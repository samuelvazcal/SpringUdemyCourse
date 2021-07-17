package com.samuelvazquez.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
    // this is where add all of our related advices for logging

    // let's start with an @Before advice
    @Before("execution(* com.samuelvazquez.aopdemo.dao.*.*(..))")
    public void beforeAddAccountAdvice() {
        System.out.println("\n ===> Executing @Before advice on method");
    }

}
