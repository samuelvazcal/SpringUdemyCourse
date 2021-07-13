package com.samuelvazquez.jdbc.demo;

import com.samuelvazquez.jdbc.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateCourseAndStudentsDemo {
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
            //start a transaction
            session.beginTransaction();;

            //create a course
            Course tempCourse = new Course("Michael Scott and how to be a leader");

            //save the course
            System.out.println("\nSaving the course...");
            session.save(tempCourse);
            System.out.println("Saved the course: " + tempCourse);

            //create the students
            Student tempStudent1 = new Student("Jim ", "Halpert","j1mh@testuapp.com");
            Student tempStudent2 = new Student("Dwight","Schrute","dw1ight@testuapp.com");

            //add students to the course
            tempCourse.addStudent(tempStudent1);
            tempCourse.addStudent(tempStudent1);

            //save the students
            System.out.println("\nSaving students...");
            session.save(tempStudent1);
            session.save(tempStudent2);
            System.out.println("Saved students" + tempCourse.getStudents());

            // commit transaction
            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            session.close();
            factory.close();
        }
    }
}
