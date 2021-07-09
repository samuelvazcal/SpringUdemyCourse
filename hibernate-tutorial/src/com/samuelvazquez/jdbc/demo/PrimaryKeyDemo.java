package com.samuelvazquez.jdbc.demo;

import com.samuelvazquez.jdbc.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {
    public static void main(String[] args) {
        //create session factory
        SessionFactory factory =
                new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
        //create session
        Session session = factory.getCurrentSession();

        try {
            // create 3 student objects
            System.out.println("Creating new student object...");
            Student tempStudent1 = new Student("Elliot","Alderson","ell10t@testuapp.com");
            Student tempStudent2 = new Student("Tyrell","Wellick","tyr3ll@testuapp.com");
            Student tempStudent3 = new Student("Dominique","DiPierro","d0m1n1qu3@testuapp.com");
            //create a student object
            session.beginTransaction();
            //save the student object
            System.out.println("Saving the students...");
            session.save(tempStudent1);
            session.save(tempStudent2);
            session.save(tempStudent3);
            //commit transaction
            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}
