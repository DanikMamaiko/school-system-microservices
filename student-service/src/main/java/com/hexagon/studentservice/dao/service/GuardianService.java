package com.hexagon.studentservice.dao.service;

import com.hexagon.studentservice.dao.entity.Guardian;

import java.util.List;
import java.util.Optional;

public interface GuardianService {
    Guardian create(Guardian guardian);
    Optional<Guardian> getById(Long id);
    List<Guardian> getAll();
    Guardian update(Long id, Guardian guardian);
    void delete(Long id);
}


