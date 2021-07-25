package com.samuelvazquez.springdemo.rest;

import com.samuelvazquez.springdemo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    // define endpoint for "/students" - return list of students

    @GetMapping("/students")
    public List<Student> getStudents() {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Michael","Scott"));
        studentList.add(new Student("Dwight","Schrute"));
        studentList.add(new Student("Jim","Halpert"));
        studentList.add(new Student("Pam","Beesly"));
        studentList.add(new Student("Stanley","Hudson"));
        return studentList;
    }
}
