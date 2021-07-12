package com.samuelvazquez.jdbc.demo;

import com.samuelvazquez.jdbc.hibernate.demo.entity.Course;
import com.samuelvazquez.jdbc.hibernate.demo.entity.Instructor;
import com.samuelvazquez.jdbc.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class EagerLazyDemo {
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

            //get the instructor from db
            int theId = 1;
            Instructor tempInstructor = session.get(Instructor.class,theId);

            System.out.println("> Instructor" + tempInstructor);

            //get course for the instructor
            System.out.println("> Courses: " + tempInstructor.getCourses());

            // commit transaction
            session.getTransaction().commit();
            System.out.println("> Done!");
        } finally {
            session.close();
            factory.close();
        }
    }
}
