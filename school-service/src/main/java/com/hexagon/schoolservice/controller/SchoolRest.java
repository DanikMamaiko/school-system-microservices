package com.hexagon.schoolservice.controller;

import com.hexagon.schoolservice.dal.entity.School;
import com.hexagon.schoolservice.dal.service.impl.SchoolServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/school")
@RequiredArgsConstructor
public class SchoolRest {

    private final SchoolServiceImpl schoolServiceImpl;

    @PostMapping
    public School create(@RequestBody School school) {
        return schoolServiceImpl.create(school);
    }

    @GetMapping
    public List<School> read() {
        return schoolServiceImpl.read();
    }

    @GetMapping("/{id}")
    public School findById(@PathVariable int id) {
        return schoolServiceImpl.findById(id);
    }

    @PutMapping("/{id}")
    public School update(@PathVariable int id, @RequestBody School school) {
        return schoolServiceImpl.update(id, school);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        schoolServiceImpl.delete(id);
    }
}