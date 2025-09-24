package com.hexagon.studentservice.dao.service;

import com.hexagon.studentservice.dao.entity.Student;
import com.hexagon.studentservice.dao.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final RestTemplate restTemplate;

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> fetchStudents() {
        return studentRepository.findAll();
    }
}