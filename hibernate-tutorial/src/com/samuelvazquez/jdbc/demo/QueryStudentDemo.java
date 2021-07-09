package com.samuelvazquez.jdbc.demo;

import com.samuelvazquez.jdbc.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class QueryStudentDemo {
    public static void main(String[] args) {
        //create session factory
        SessionFactory factory =
                new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
        //create session
        Session session = factory.getCurrentSession();

        try {
            //start a transaction
            session.beginTransaction();

            //query students
            List<Student> studentList = session.createQuery("from Student").getResultList();

            //display the students
            displayStudents(studentList);

            //query students: lastName = 'Doe'
            studentList = session.createQuery("from Student s where s.lastName = 'Vazquez'").getResultList();

            //display the students
            System.out.println("\nStudents who have last name Vazquez");
            displayStudents(studentList);

            //query students: lastName = 'Wellick' or firsName = 'Samuel'
            studentList =
                    session.createQuery("from Student s where s.lastName = 'Wellick' or s.firstName = 'Samuel'").getResultList();

            System.out.println("\nStudents who have last name Wellick or first name Samuel");
            displayStudents(studentList);

            //query students: email contains 'testuapp.com'
            studentList = session.createQuery("from Student s where email like '%l@testuapp.com'").getResultList();

            System.out.println("\n\nStudents who email contains *l@testuapp.com");
            System.out.println(studentList);


            //commit a transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }

    private static void displayStudents(List<Student> studentList) {
        for(Student tempStudent: studentList) {
            System.out.println(tempStudent);
        }
    }
}
