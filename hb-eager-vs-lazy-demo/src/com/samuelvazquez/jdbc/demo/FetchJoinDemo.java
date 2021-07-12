package com.samuelvazquez.jdbc.demo;

import com.samuelvazquez.jdbc.hibernate.demo.entity.Course;
import com.samuelvazquez.jdbc.hibernate.demo.entity.Instructor;
import com.samuelvazquez.jdbc.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class FetchJoinDemo {
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

            //option 2: Hibernate query with HQL

            //get the instructor from db
            int theId = 1;

            Query<Instructor> query = session.createQuery("select i from Instructor i" + " JOIN FETCH i.courses " +
                            " where i.id =: theInstructorId", Instructor.class);

            //set paramenter on query
            query.setParameter("theInstructorId",theId);

            //execute query and get instructor
            Instructor tempInstructor = query.getSingleResult();

            System.out.println("> Instructor" + tempInstructor);

            // commit transaction
            session.getTransaction().commit();
            session.close();
            System.out.println("> The session is now closed!");


            System.out.println("Courses: " + tempInstructor.getCourses());
            System.out.println("> Done!");
        } finally {
            session.close();
            factory.close();
        }
    }
}
