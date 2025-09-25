package com.hexagon.schoolservice.dal.service;

import com.hexagon.schoolservice.dal.entity.SchoolEntity;

import java.util.List;

public interface SchoolService {
    SchoolEntity create(SchoolEntity school);
    List<SchoolEntity> read();
    SchoolEntity findById(int id);
    SchoolEntity update(int id, SchoolEntity updatedSchool);
    void delete(int id);
}