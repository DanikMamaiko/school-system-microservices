package com.hexagon.schoolservice.dal.service.impl;

import com.hexagon.schoolservice.dal.entity.SchoolEntity;
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
    public SchoolEntity create(SchoolEntity school) {
        return schoolRepository.save(school);
    }

    @Override
    @Transactional(readOnly = true)
    public List<SchoolEntity> read() {
        return schoolRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public SchoolEntity findById(int id) {
        return schoolRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public SchoolEntity update(int id, SchoolEntity updatedSchool) {
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