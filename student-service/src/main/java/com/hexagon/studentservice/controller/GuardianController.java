package com.hexagon.studentservice.controller;

import com.hexagon.studentservice.dao.entity.Guardian;
import com.hexagon.studentservice.dao.service.GuardianService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/student/guardians")
@RequiredArgsConstructor
public class GuardianController {

    private final GuardianService guardianService;

    @PostMapping
    public ResponseEntity<Guardian> create(@RequestBody Guardian guardian) {
        Guardian created = guardianService.create(guardian);
        return ResponseEntity.created(URI.create("/student/guardians/" + created.getId())).body(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Guardian> getById(@PathVariable Long id) {
        return guardianService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Guardian>> getAll() {
        return ResponseEntity.ok(guardianService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Guardian> update(@PathVariable Long id, @RequestBody Guardian guardian) {
        Guardian updated = guardianService.update(id, guardian);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        guardianService.delete(id);
    }
}


