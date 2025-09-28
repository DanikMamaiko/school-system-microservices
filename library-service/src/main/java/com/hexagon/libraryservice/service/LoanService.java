package com.hexagon.libraryservice.service;

import com.hexagon.libraryservice.model.Loan;

import java.util.List;
import java.util.Optional;

public interface LoanService {
    Loan create(Loan loan);
    Optional<Loan> getById(String id);
    List<Loan> getAll();
    Loan update(String id, Loan loan);
    void delete(String id);
}


