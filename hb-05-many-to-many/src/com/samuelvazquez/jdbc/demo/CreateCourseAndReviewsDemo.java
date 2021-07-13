package com.samuelvazquez.jdbc.demo;

import com.samuelvazquez.jdbc.hibernate.demo.entity.Course;
import com.samuelvazquez.jdbc.hibernate.demo.entity.Instructor;
import com.samuelvazquez.jdbc.hibernate.demo.entity.InstructorDetail;
import com.samuelvazquez.jdbc.hibernate.demo.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateCourseAndReviewsDemo {
    public static void main(String[] args) {
        //create session factory
        SessionFactory factory = new Configuration()
                        .configure("hibernate.cfg.xml")
                        .addAnnotatedClass(Instructor.class)
                        .addAnnotatedClass(InstructorDetail.class)
                        .addAnnotatedClass(Course.class)
                        .addAnnotatedClass(Review.class)
                        .buildSessionFactory();
        // create session
        Session session = factory.getCurrentSession();

        try {
            //start a transaction
            session.beginTransaction();;

            //create a course
            Course tempCourse = new Course("All the secrets about sales");
            //add some reviews
            tempCourse.addReview(new Review("Amazing course, love it!"));
            tempCourse.addReview(new Review("Great course, 5 stars!"));
            tempCourse.addReview(new Review("Not the greatest course at all!"));

            //save the course and leverage the cascade all
            System.out.println("Saving the course: " + tempCourse);
            System.out.println(tempCourse.getReviews());
            session.save(tempCourse);


            // commit transaction
            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            session.close();
            factory.close();
        }
    }
}
