package com.hexagon.studentservice.dao.repository;

import com.hexagon.studentservice.dao.entity.Guardian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuardianRepository extends JpaRepository<Guardian, Long> {
}


