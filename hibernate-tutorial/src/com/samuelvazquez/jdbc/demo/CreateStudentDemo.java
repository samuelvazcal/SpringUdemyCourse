package com.samuelvazquez.jdbc.demo;

import com.samuelvazquez.jdbc.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateStudentDemo {
    public static void main(String[] args) {
        //create session factory
        SessionFactory factory =
                new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
        //create session
        Session session = factory.getCurrentSession();

        try {
            //use the session object to save Java object
            System.out.println("Creating new student object...");
            Student tempStudent = new Student("Samuel","Vazquez","s4mu3l@testuapp.com");
            //create a student object
            session.beginTransaction();
            //save the student object
            System.out.println("Saving the student...");
            session.save(tempStudent);
            //commit transaction
            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}
