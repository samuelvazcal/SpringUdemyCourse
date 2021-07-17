package com.samuelvazquez.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
    // this is where add all of our related advices for logging

    // let's start with an @Before advice

    // matching an specific class bi its fully qualified name
//    @Before("execution(public void com.samuelvazquez.aopdemo.dao.AccountDAO.addAccount())")
//    public void beforeAddAccountAdvice() {
//        System.out.println("\n ===> Executing @Before advice on method");
//    }

    // matching classes using wildcards
//    @Before("execution(public void add*())")
//    public void beforeAddAccountAdvice() {
//        System.out.println("\n ===> Executing @Before advice on method")
//    }

    //matching classes ignoring return types of classes using wildcards
    @Before("execution(* add*())")
    public void beforeAddAccountAdvice() {
        System.out.println("\n ===> Executing @Before advice on method");
    }

}
