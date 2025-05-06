package com.microservice.course.controller;

import com.microservice.course.entities.Course;
import com.microservice.course.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.microservice.course.service.ICourseService;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private ICourseService course_service;

    @PostMapping("/created")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveStudent(@RequestBody Course course)
    {
        course_service.save(course);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAllStudent()
    {
        return ResponseEntity.ok(course_service.findAll());
    }

    @GetMapping("/search-course/{id}")
    public ResponseEntity<?> findAllById(@PathVariable Long id)
    {
        return ResponseEntity.ok(course_service.findById(id));
    }

    @GetMapping("/search-student/{idCourse}")
    public  ResponseEntity<?> findStudentByIdCourse(@PathVariable Long idCourse)
    {
        return ResponseEntity.ok(course_service.findStudentByIdCourse(idCourse));
    }
}
