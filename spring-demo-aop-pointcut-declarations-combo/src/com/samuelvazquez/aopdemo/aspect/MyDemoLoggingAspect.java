package com.samuelvazquez.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
    // this is where add all of our related advices for logging

    // let's start with an @Before advice
    @Pointcut("execution(* com.samuelvazquez.aopdemo.dao.*.*(..))")
    private void forDaoPackage() {}

    //create point cut for getter methods
    @Pointcut("execution(* com.samuelvazquez.aopdemo.dao.*.get*(..))")
    private void getter() {}
    //create pointcut for setter methods
    @Pointcut("execution(* com.samuelvazquez.aopdemo.dao.*.set*(..))")
    private void setter() {}
    //create point include package ... exclude getter/setter
    @Pointcut ("forDaoPackage() && !(getter() || setter())")
    private void forDaoPackageNoGetterSetter() {}

    @Before("forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice() {
        System.out.println("\n ===> Executing @Before advice on method");
    }

    @Before("forDaoPackageNoGetterSetter()")
    public void beforeApiAnalytics() {
        System.out.println("\n ===$ Performing API analytics");
    }
}
