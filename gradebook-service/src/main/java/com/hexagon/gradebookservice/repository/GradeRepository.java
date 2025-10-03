package com.hexagon.gradebookservice.repository;

import com.hexagon.gradebookservice.dal.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeRepository extends JpaRepository<Grade, Long> {
}