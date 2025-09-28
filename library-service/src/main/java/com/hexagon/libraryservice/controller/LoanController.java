package com.hexagon.libraryservice.controller;

import com.hexagon.libraryservice.model.Loan;
import com.hexagon.libraryservice.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/loans")
@RequiredArgsConstructor
public class LoanController {

    private final LoanService loanService;

    @PostMapping
    public ResponseEntity<Loan> create(@RequestBody Loan loan) {
        Loan created = loanService.create(loan);
        return ResponseEntity.created(URI.create("/api/v1/loans/" + created.getId())).body(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Loan> getById(@PathVariable String id) {
        return loanService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Loan>> getAll() {
        return ResponseEntity.ok(loanService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Loan> update(@PathVariable String id, @RequestBody Loan loan) {
        Loan updated = loanService.update(id, loan);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        loanService.delete(id);
    }
}


