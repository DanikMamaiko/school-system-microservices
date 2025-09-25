package com.hexagon.schoolservice.dal.service.impl;

import com.hexagon.schoolservice.dal.entity.School;
import com.hexagon.schoolservice.dal.repository.SchoolRepository;
import com.hexagon.schoolservice.dal.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolServiceImpl implements SchoolService {

    private final SchoolRepository schoolRepository;

    @Override
    @Transactional
    public School create(School school) {
        return schoolRepository.save(school);
    }

    @Override
    @Transactional(readOnly = true)
    public List<School> read() {
        return schoolRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public School findById(int id) {
        return schoolRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
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

    @Override
    @Transactional
    public void delete(int id) {
        schoolRepository.deleteById(id);
    }
}