package com.samuelvazquez.aopdemo.aspect;

import com.samuelvazquez.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    private Logger myLogger = Logger.getLogger(getClass().getName());

    @Around("execution(* com.samuelvazquez.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
        // print out method we are advising on
        String method = theProceedingJoinPoint.getSignature().toShortString();
        myLogger.info("\n==> Executing @Around on method: " + method);
        // get begin timestamp
        long begin = System.currentTimeMillis();
        // now, let's execute the method
        Object result = null;

        result = theProceedingJoinPoint.proceed();
        // get end timestamp
        long end = System.currentTimeMillis();
        // compute duration and display it
        long duration = end - begin;
        myLogger.info("\n===> Duration: " + duration / 1000.0 + " seconds");
        return result;
    }

    @After("execution(* com.samuelvazquez.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {
        //print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        myLogger.info("\n==> Executing @After (finally) on method: " + method);
    }

    @AfterThrowing(
            pointcut = "execution(* com.samuelvazquez.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "theExc")
    public void afterThrowingFindAccountAdvice(
        JoinPoint theJoinPoint, Throwable theExc) {
        //print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        myLogger.info("\n==> Executing @AfterThrowing on method: " + method);
        //log the exception
        myLogger.info("\n==> The exception is: " + theExc);
    }

    //add a new advice for @AfterReturning on the findAccounts method
    @AfterReturning(
            pointcut="execution(* com.samuelvazquez.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result")
    public void afterReturningFindAccountsAdvice(
        JoinPoint theJoinPoint, List<Account> result) {

        //print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        myLogger.info("\n===> Executing @AfterReturning on method: " + method);
        //print out the results of the method call
        myLogger.info("\n===> result is " + result);
        //let's post-process the data ... let's modify it

        //convert the account names to uppercase
        convertAccountNamesToUpperCase(result);
        myLogger.info("\n===> result is " + result);
    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
        // loop through accounts
        for(Account tempAccount : result) {
            //get uppercase version of name
            String theUpperName = tempAccount.getName().toUpperCase();
            //update the name on the account
            tempAccount.setName(theUpperName);
        }

    }


//    @Before("com.samuelvazquez.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
//    public void beforeAddAccountAdvice() {
//        myLogger.info("\n ===> Executing @Before advice on method");
//    }
}
