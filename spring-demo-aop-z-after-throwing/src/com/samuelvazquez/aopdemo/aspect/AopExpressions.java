package com.samuelvazquez.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {
    // this is where add all of our related advices for logging

    // let's start with an @Before advice
    @Pointcut("execution(* com.samuelvazquez.aopdemo.dao.*.*(..))")
    public void forDaoPackage() {}

    //create point cut for getter methods
    @Pointcut("execution(* com.samuelvazquez.aopdemo.dao.*.get*(..))")
    public void getter() {}
    //create pointcut for setter methods
    @Pointcut("execution(* com.samuelvazquez.aopdemo.dao.*.set*(..))")
    public void setter() {}
    //create point include package ... exclude getter/setter
    @Pointcut ("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter() {}

}
