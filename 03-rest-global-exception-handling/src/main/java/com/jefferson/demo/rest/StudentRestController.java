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

    // add an exception handler using @ExceptionHandler

    @ExceptionHandler // when an exception is thrown, this method will be called
    // ResponseEntity<StudentErrorResponse> is the type of response body
    // StudentErrorResponse is the Exception type we are going to catch
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc) {
        // create a StudentErrorResponse
        StudentErrorResponse error = new StudentErrorResponse();

        // set the status using the setter
        error.setStatus(HttpStatus.NOT_FOUND.value());
        // set the message using the setter
        error.setMessage(exc.getMessage());
        // set the timestamp using the setter
        error.setTimeStamp(System.currentTimeMillis());

        // return ResponseEntity. body, status
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // add another exception handler to catch any exception(catch all)
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exc) {
        // create a StudentErrorResponse
        StudentErrorResponse error = new StudentErrorResponse();

        // set the status using the setter
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        // set the message using the setter
        error.setMessage(exc.getMessage());
        // set the timestamp using the setter
        error.setTimeStamp(System.currentTimeMillis());

        // return ResponseEntity. body, status
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

    }
}
