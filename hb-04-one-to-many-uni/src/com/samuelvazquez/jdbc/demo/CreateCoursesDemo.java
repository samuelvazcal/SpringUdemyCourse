package com.samuelvazquez.jdbc.demo;

import com.samuelvazquez.jdbc.hibernate.demo.entity.Course;
import com.samuelvazquez.jdbc.hibernate.demo.entity.Instructor;
import com.samuelvazquez.jdbc.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.criteria.CriteriaBuilder;


public class CreateCoursesDemo {
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
            //create some courses
            Course tempCourse1 = new Course("How to sell paper");
            Course tempCourse2 = new Course("The art of being a salesman");

            //add courses to instructor
            tempInstructor.add(tempCourse1);
            tempInstructor.add(tempCourse2);

            //save the courses
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
