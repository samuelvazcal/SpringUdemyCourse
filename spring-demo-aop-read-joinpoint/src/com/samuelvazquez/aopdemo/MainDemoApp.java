package com.samuelvazquez.aopdemo;

import com.samuelvazquez.aopdemo.dao.AccountDAO;
import com.samuelvazquez.aopdemo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {
    public static void main(String[] args) {
        //read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        //get the bean business method
        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
        MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
        //call the business method
        Account myAccount = new Account();
        myAccount.setName("Elliot");
        myAccount.setLevel("Platinum");
        theAccountDAO.addAccount(myAccount,true);
        theAccountDAO.doWork();

        // call the account dao getter/setter methods
        theAccountDAO.setName("foobar");
        theAccountDAO.setServiceCode("silver");

        String name = theAccountDAO.getName();
        String code = theAccountDAO.getServiceCode();



        //call the Membership business method
        theMembershipDAO.addSillyMember();
        theMembershipDAO.goToSleep();
        //close the context
        context.close();
    }
}
