package com.jefferson.demo.rest;

import com.jefferson.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/api")
@RestController
public class StudentRestController {

    private List<Student> students;

    // only load students once. This occurs when the Bean is created.
    @PostConstruct
    public void loadData() {
        // create a list of students
        students = new ArrayList<>();

        // add sample data
        students.add(new Student("Jefferson", "Garcia"));
        students.add(new Student("Adilson", "Lopez"));
        students.add(new Student("Jeff", "Jurado"));
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        // Although I am returning a list of students, Spring will automatically convert the list to JSON thanks to the Jackson library
        return students;

    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        // check the studentId against list size
        if ((students.size() <= studentId) || (studentId < 0)) {
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }

        return students.get(studentId);
    }

}
