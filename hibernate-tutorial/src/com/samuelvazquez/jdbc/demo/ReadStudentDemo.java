package com.samuelvazquez.jdbc.demo;

import com.samuelvazquez.jdbc.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class ReadStudentDemo {
    public static void main(String[] args) {
        //create session factory
        SessionFactory factory =
                new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
        //create session
        Session session = factory.getCurrentSession();

        try {
            //use the session object to save Java object
            System.out.println("Creating new student object...");
            Student tempStudent = new Student("Daffy","Duck","d4ffy@testuapp.com");
            //create a student object
            session.beginTransaction();
            //save the student object
            System.out.println("Saving the student...");
            System.out.println(tempStudent);
            session.save(tempStudent);
            //commit transaction
            session.getTransaction().commit();
            //new code
            //find out the student's id: PK
            System.out.println("Saved student. Generated id: " + tempStudent.getId());

            //now get a new session and start transaction
            session = factory.getCurrentSession();
            session.beginTransaction();
            // retrieve student based on the id: PK
            System.out.println("\nGetting student with id: " + tempStudent.getId());
            Student myStudent = session.get(Student.class,tempStudent.getId());

            System.out.println("Get complete: " + myStudent);
            //commit the transaction
            session.getTransaction().commit();

            System.out.println("Done!!");
        } finally {
            factory.close();
        }
    }
}
