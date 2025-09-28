package com.hexagon.studentservice.controller;

import com.hexagon.studentservice.dao.entity.CourseEnrollment;
import com.hexagon.studentservice.dao.service.CourseEnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/student/enrollments")
@RequiredArgsConstructor
public class CourseEnrollmentController {

    private final CourseEnrollmentService enrollmentService;

    @PostMapping
    public ResponseEntity<CourseEnrollment> create(@RequestBody CourseEnrollment enrollment) {
        CourseEnrollment created = enrollmentService.create(enrollment);
        return ResponseEntity.created(URI.create("/student/enrollments/" + created.getId())).body(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseEnrollment> getById(@PathVariable Long id) {
        return enrollmentService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<CourseEnrollment>> getAll() {
        return ResponseEntity.ok(enrollmentService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseEnrollment> update(@PathVariable Long id, @RequestBody CourseEnrollment enrollment) {
        CourseEnrollment updated = enrollmentService.update(id, enrollment);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        enrollmentService.delete(id);
    }
}


