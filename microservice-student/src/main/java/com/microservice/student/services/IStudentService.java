package com.microservice.student.services;

import com.microservice.student.entities.Student;

import java.util.List;

public interface IStudentService {

    List<Student> findAll();

    Student findAllById(Long id);

    void save(Student student);

    List<Student> findAllByCourse(Long idCourse);
}
