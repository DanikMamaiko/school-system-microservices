package com.hexagon.schoolservice.dal.repository;

import com.hexagon.schoolservice.dal.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School,Integer> {
}
