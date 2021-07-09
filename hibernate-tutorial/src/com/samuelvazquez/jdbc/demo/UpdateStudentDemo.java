package com.samuelvazquez.jdbc.demo;

import com.samuelvazquez.jdbc.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class UpdateStudentDemo {
    public static void main(String[] args) {
        //create session factory
        SessionFactory factory =
                new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
        //create session
        Session session = factory.getCurrentSession();

        try {
            int studentId = 6;

            //get a new session and start transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            // retrieve student based on the id: PK
            System.out.println("\nGetting student with id: " + studentId);
            Student myStudent = session.get(Student.class,studentId);

            System.out.println("Updating student...");
            myStudent.setFirstName("Joanna");
            myStudent.setLastName("Wellick");
            myStudent.setEmail("j04nn4@testuapp.com");
            //commit the transaction
            session.getTransaction().commit();

            //NEW CODE
            session = factory.getCurrentSession();
            session.beginTransaction();

            //update email for all students
            System.out.println("Update email for all students");
            session.createQuery("update Student set email='default_test@testuapp.com'").executeUpdate();

            session.getTransaction().commit();
            System.out.println("Done!!");
        } finally {
            factory.close();
        }
    }
}
