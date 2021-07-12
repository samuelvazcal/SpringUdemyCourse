package com.samuelvazquez.jdbc.demo;

import com.samuelvazquez.jdbc.hibernate.demo.entity.Course;
import com.samuelvazquez.jdbc.hibernate.demo.entity.Instructor;
import com.samuelvazquez.jdbc.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateInstructorDemo {
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
            // create the objects
            Instructor tempInstructor = new Instructor("Michael","Scott","m1ch43l@testuapp.com");
            InstructorDetail tempInstructorDetail = new InstructorDetail("thescrantonman","sell paper");

            // associate the objects
            tempInstructor.setInstructorDetail(tempInstructorDetail);
            //start a transaction
            session.beginTransaction();

            // save the instructor
            // this will ALSO save the details object because of CascadeType.ALL
            //
            System.out.println("Saving instructor: " + tempInstructor);

            session.save(tempInstructor);
            // commit transaction
            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }
    }
}
