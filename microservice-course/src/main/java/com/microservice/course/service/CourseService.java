package com.microservice.course.service;

import com.microservice.course.client.StudentClient;
import com.microservice.course.dto.StudentDTO;
import com.microservice.course.entities.Course;
import com.microservice.course.http.response.StudentByCourseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.microservice.course.persistence.ICourseRepository;

import java.util.List;

@Service
public class CourseService implements ICourseService {

    private final ICourseRepository course_repository;
    private final StudentClient student_client;

    @Autowired
    public CourseService(ICourseRepository course_repository, StudentClient student_client) {
        this.course_repository = course_repository;
        this.student_client = student_client;
    }

    @Override
    public List<Course> findAll() {
        return (List<Course>) course_repository.findAll();
    }

    @Override
    public Course findById(Long id) {
        return course_repository.findById(id).orElseThrow();
    }

    @Override
    public void save(Course course) {
        course_repository.save(course);
    }

    @Override
    public StudentByCourseResponse findStudentByIdCourse(Long idCourse) {
        // consultar el curso
        Course course = course_repository.findById(idCourse).orElse(new Course());

        // Obtener los estudiantes
        List<StudentDTO> student_dto_list = student_client.findAllStudentByCourse(idCourse);

        return StudentByCourseResponse
                .builder()
                .courseName(course.getName())
                .teacher(course.getTeacher())
                .student_dto(student_dto_list)
                .build();
    }
}