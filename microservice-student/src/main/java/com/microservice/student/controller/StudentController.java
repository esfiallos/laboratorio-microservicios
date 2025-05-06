package com.microservice.student.controller;

import com.microservice.student.entities.Student;
import com.microservice.student.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentService student_service;

    @PostMapping("/created")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveStudent(@RequestBody Student student)
    {
        student_service.save(student);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAllStudent()
    {
        return ResponseEntity.ok(student_service.findAll());
    }

    @GetMapping("/search-student/{id}")
    public ResponseEntity<?> findAllById(@PathVariable Long id) {
        return ResponseEntity.ok(student_service.findAllById(id));
    }

    @GetMapping("/searchByCourse/{idCourse}")
    ResponseEntity<?> findByCourse(@PathVariable Long idCourse)
    {
        return ResponseEntity.ok(student_service.findAllByCourse(idCourse));
    }

}
