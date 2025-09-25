package com.hexagon.schoolservice.dal.service;

import com.hexagon.schoolservice.dal.entity.School;
import com.hexagon.schoolservice.dal.repository.SchoolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolService {

    private final SchoolRepository schoolRepository;

    public School create(School school) {
        return schoolRepository.save(school);
    }

    public List<School> read() {
        return schoolRepository.findAll();
    }

    public School findById(int id) {
        return schoolRepository.findById(id).orElse(null);
    }

    public School update(int id, School updatedSchool) {
        return schoolRepository.findById(id)
                .map(school -> {
                    school.setSchoolName(updatedSchool.getSchoolName());
                    school.setPrincipalName(updatedSchool.getPrincipalName());
                    school.setLocation(updatedSchool.getLocation());
                    return schoolRepository.save(school);
                })
                .orElse(null);
    }

    public void delete(int id) {
        schoolRepository.deleteById(id);
    }
}