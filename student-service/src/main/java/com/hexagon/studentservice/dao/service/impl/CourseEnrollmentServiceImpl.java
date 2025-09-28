package com.hexagon.studentservice.dao.service.impl;

import com.hexagon.studentservice.dao.entity.CourseEnrollment;
import com.hexagon.studentservice.dao.repository.CourseEnrollmentRepository;
import com.hexagon.studentservice.dao.service.CourseEnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseEnrollmentServiceImpl implements CourseEnrollmentService {

    private final CourseEnrollmentRepository courseEnrollmentRepository;

    @Override
    public CourseEnrollment create(CourseEnrollment courseEnrollment) {
        return courseEnrollmentRepository.save(courseEnrollment);
    }

    @Override
    public Optional<CourseEnrollment> getById(Long id) {
        return courseEnrollmentRepository.findById(id);
    }

    @Override
    public List<CourseEnrollment> getAll() {
        return courseEnrollmentRepository.findAll();
    }

    @Override
    public CourseEnrollment update(Long id, CourseEnrollment courseEnrollment) {
        CourseEnrollment existing = courseEnrollmentRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("CourseEnrollment not found: " + id));
        existing.setStudentId(courseEnrollment.getStudentId());
        existing.setCourseCode(courseEnrollment.getCourseCode());
        existing.setSemester(courseEnrollment.getSemester());
        return courseEnrollmentRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        courseEnrollmentRepository.deleteById(id);
    }
}


