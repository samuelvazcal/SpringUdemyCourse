package com.samuelvazquez.jdbc.demo;

import com.samuelvazquez.jdbc.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.swing.*;


public class AddCoursesForDwightDemo {
    public static void main(String[] args) {
        //create session factory
        SessionFactory factory = new Configuration()
                        .configure("hibernate.cfg.xml")
                        .addAnnotatedClass(Instructor.class)
                        .addAnnotatedClass(InstructorDetail.class)
                        .addAnnotatedClass(Course.class)
                        .addAnnotatedClass(Review.class)
                        .addAnnotatedClass(Student.class)
                        .buildSessionFactory();
        // create session
        Session session = factory.getCurrentSession();

        try {
            // start a transaction
            session.beginTransaction();

            // get the student Dwight from database
            int studentId = 2;
            Student tempStudent = session.get(Student.class,studentId);

            System.out.println("\n Loaded student: " + tempStudent);
            System.out.println("Course: " + tempStudent.getCourses());

            // create more courses
            Course tempCourse1 = new Course("How to be the best farmer and salesman");
            Course tempCourse2 = new Course("Battlestar Galactica Leadership");

            // add student to courses
            tempCourse1.addStudent(tempStudent);
            tempCourse2.addStudent(tempStudent);

            // save the courses
            System.out.println("\nSaving the courses...");
            session.save(tempCourse1);
            session.save(tempCourse2);

            // commit transaction
            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            session.close();
            factory.close();
        }
    }
}
