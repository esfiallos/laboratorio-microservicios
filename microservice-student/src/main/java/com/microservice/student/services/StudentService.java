package com.microservice.student.services;

import com.microservice.student.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.microservice.student.persistence.StudentRepository;

import java.util.List;

@Service
public class StudentService implements IStudentService
{
    @Autowired
    StudentRepository studenrepository;

    @Override
    public List<Student> findAll() {
        return (List<Student>) studenrepository.findAll();
    }

    @Override
    public Student findAllById(Long id) {
        return studenrepository.findById(id).orElseThrow();
    }

    @Override
    public void save(Student student) {
        studenrepository.save(student);
    }

    @Override
    public List<Student> findAllByCourse(Long idCourse) {
        return studenrepository.findAllByCourse(idCourse);
    }
}
