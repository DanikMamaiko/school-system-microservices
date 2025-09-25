package com.hexagon.schoolservice.controller;

import com.hexagon.schoolservice.dal.entity.School;
import com.hexagon.schoolservice.dal.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/school")
@RequiredArgsConstructor
public class SchoolController {

    private final SchoolService schoolService;

    // CREATE
    @PostMapping
    public School createSchool(@RequestBody School school) {
        return schoolService.create(school);
    }

    // READ ALL
    @GetMapping
    public List<School> getAllSchools() {
        return schoolService.read();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public School getSchoolById(@PathVariable int id) {
        return schoolService.findById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public School updateSchool(@PathVariable int id, @RequestBody School school) {
        return schoolService.update(id, school);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deleteSchool(@PathVariable int id) {
        schoolService.delete(id);
    }
}