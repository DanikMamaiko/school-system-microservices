package com.hexagon.libraryservice.repository;

import com.hexagon.libraryservice.model.Loan;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LoanRepository extends MongoRepository<Loan, String> {
}


