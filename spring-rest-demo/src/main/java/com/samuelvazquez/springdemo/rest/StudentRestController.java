package com.samuelvazquez.springdemo.rest;

import com.samuelvazquez.springdemo.entity.Student;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

    // define @PostConstruct to load the student data --- only once!
    @PostConstruct
    public void loadData() {
        theStudents = new ArrayList<>();
        theStudents.add(new Student("Michael","Scott"));
        theStudents.add(new Student("Dwight","Schrute"));
        theStudents.add(new Student("Jim","Halpert"));
        theStudents.add(new Student("Pam","Beesly"));
        theStudents.add(new Student("Stanley","Hudson"));
    }

    // define endpoint for "/students" - return list of students

    @GetMapping("/students")
    public List<Student> getStudents() {
        return theStudents;
    }

    // define endpoint for "/students/{studentId}" - return student at index
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {

        // just index into the list ... keep it simple for now

        return theStudents.get(studentId);
    }
}
