package com.samuelvazquez.jdbc.demo;

import com.samuelvazquez.jdbc.hibernate.demo.entity.Course;
import com.samuelvazquez.jdbc.hibernate.demo.entity.Instructor;
import com.samuelvazquez.jdbc.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteCourseDemo {
    public static void main(String[] args) {
        //create session factory
        SessionFactory factory = new Configuration()
                        .configure("hibernate.cfg.xml")
                        .addAnnotatedClass(Instructor.class)
                        .addAnnotatedClass(InstructorDetail.class)
                        .addAnnotatedClass(Course.class)
                        .buildSessionFactory();
        // create session
        Session session = factory.getCurrentSession();

        try {
            //start a transaction
            session.beginTransaction();

            //get a course
            int theId = 10;
            Course tempCourse = session.get(Course.class,theId);

            //delete course
            System.out.println("Deleting course: " + tempCourse);
            //get the instructor from db
            session.delete(tempCourse);

            // commit transaction
            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            session.close();
            factory.close();
        }
    }
}
