package com.hexagon.studentservice.dao.service;

import com.hexagon.studentservice.dao.entity.CourseEnrollment;

import java.util.List;
import java.util.Optional;

public interface CourseEnrollmentService {
    CourseEnrollment create(CourseEnrollment courseEnrollment);
    Optional<CourseEnrollment> getById(Long id);
    List<CourseEnrollment> getAll();
    CourseEnrollment update(Long id, CourseEnrollment courseEnrollment);
    void delete(Long id);
}


