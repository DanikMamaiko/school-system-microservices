package com.hexagon.gradebookservice.service;

import com.hexagon.gradebookservice.dal.entity.Grade;
import com.hexagon.gradebookservice.repository.GradeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GradeService {

    private final GradeRepository gradeRepository;

    public Optional<Grade> getGradeById(Long id) {
        return gradeRepository.findById(id);
    }

    public Grade saveGrade(Grade grade) {
        return gradeRepository.save(grade);
    }
}