package com.hexagon.schoolservice.dal.service;

import com.hexagon.schoolservice.dal.entity.School;

import java.util.List;

public interface SchoolService {
    School create(School school);
    List<School> read();
    School findById(int id);
    School update(int id, School updatedSchool);
    void delete(int id);
}