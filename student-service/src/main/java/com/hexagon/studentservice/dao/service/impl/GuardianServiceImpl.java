package com.hexagon.studentservice.dao.service.impl;

import com.hexagon.studentservice.dao.entity.Guardian;
import com.hexagon.studentservice.dao.repository.GuardianRepository;
import com.hexagon.studentservice.dao.service.GuardianService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GuardianServiceImpl implements GuardianService {

    private final GuardianRepository guardianRepository;

    @Override
    public Guardian create(Guardian guardian) {
        return guardianRepository.save(guardian);
    }

    @Override
    public Optional<Guardian> getById(Long id) {
        return guardianRepository.findById(id);
    }

    @Override
    public List<Guardian> getAll() {
        return guardianRepository.findAll();
    }

    @Override
    public Guardian update(Long id, Guardian guardian) {
        Guardian existing = guardianRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Guardian not found: " + id));
        existing.setFullName(guardian.getFullName());
        existing.setPhone(guardian.getPhone());
        existing.setEmail(guardian.getEmail());
        return guardianRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        guardianRepository.deleteById(id);
    }
}


