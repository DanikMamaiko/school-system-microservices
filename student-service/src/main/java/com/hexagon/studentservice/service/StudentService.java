package com.hexagon.studentservice.service;

import com.hexagon.studentservice.dto.School;
import com.hexagon.studentservice.dto.StudentResponse;
import com.hexagon.studentservice.model.Student;
import com.hexagon.studentservice.repository.StudentRepository;
import com.hexagon.studentservice.service.producer.Producer;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final RestTemplate restTemplate;
    private final Producer producer;

    public ResponseEntity<?> createStudent(Student student) {
        try {
            return new ResponseEntity<Student>(studentRepository.save(student), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> fetchStudentById(String id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) {
//            School school = restTemplate.getForObject("http://localhost:8082/school/" + student.get().getSchoolId(), School.class);
            School school = restTemplate.getForObject(
                "http://SCHOOL-SERVICE/school/" + student.get().getSchoolId(), School.class);
            StudentResponse studentResponse = new StudentResponse(
                student.get().getId(),
                student.get().getName(),
                student.get().getAge(),
                student.get().getGender(),
                school
            );
            return new ResponseEntity<>(studentResponse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No Student Found", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> fetchStudents() {
        List<Student> students = studentRepository.findAll();
        if (students.size() > 0) {
            return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No Students", HttpStatus.NOT_FOUND);
        }
    }

    @Transactional
    public String buyFoodInCanteen() {
        Random random = new Random();
        Integer foodPrice = random.nextInt(10);

        return producer.sendMessage(foodPrice);
    }
}
