package com.samuelvazquez.jdbc.demo;

import com.samuelvazquez.jdbc.hibernate.demo.entity.Instructor;
import com.samuelvazquez.jdbc.hibernate.demo.entity.InstructorDetail;
import com.samuelvazquez.jdbc.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateDemo {
    public static void main(String[] args) {
        //create session factory
        SessionFactory factory = new Configuration()
                        .configure("hibernate.cfg.xml")
                        .addAnnotatedClass(Instructor.class)
                        .addAnnotatedClass(InstructorDetail.class)
                        .buildSessionFactory();
        // create session
        Session session = factory.getCurrentSession();

        try {
            // create the objects
//            Instructor tempInstructor = new Instructor("Chad","Darby","darby@testuapp.com");
//            InstructorDetail tempInstructorDetail = new InstructorDetail("luv2code","Luv 2 code!!!");
//            Instructor tempInstructor = new Instructor("Mateo","Ortega","mate0@testuapp.com");
//            InstructorDetail tempInstructorDetail = new InstructorDetail("mate0S","embedded systems");
//            Instructor tempInstructor = new Instructor("Elliot","Alderson","ell10t0@testuapp.com");
//            InstructorDetail tempInstructorDetail = new InstructorDetail("fsociety","hacking");
            Instructor tempInstructor = new Instructor("Gandalf","The Grey","g4nd4lf@testuapp.com");
            InstructorDetail tempInstructorDetail = new InstructorDetail("middleearthmagic4u","do tricks");
//            Instructor tempInstructor = new Instructor("Boring","Teacher","d3l3t3m3@testuapp.com");
//            InstructorDetail tempInstructorDetail = new InstructorDetail("4www","do nothing");

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
            factory.close();
        }
    }
}
