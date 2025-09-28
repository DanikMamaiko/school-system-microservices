package com.hexagon.libraryservice.service.impl;

import com.hexagon.libraryservice.model.Loan;
import com.hexagon.libraryservice.repository.LoanRepository;
import com.hexagon.libraryservice.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoanServiceImpl implements LoanService {

    private final LoanRepository loanRepository;

    @Override
    public Loan create(Loan loan) {
        return loanRepository.save(loan);
    }

    @Override
    public Optional<Loan> getById(String id) {
        return loanRepository.findById(id);
    }

    @Override
    public List<Loan> getAll() {
        return loanRepository.findAll();
    }

    @Override
    public Loan update(String id, Loan loan) {
        Loan existing = loanRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Loan not found: " + id));
        existing.setBookId(loan.getBookId());
        existing.setMemberId(loan.getMemberId());
        existing.setLoanDate(loan.getLoanDate());
        existing.setDueDate(loan.getDueDate());
        existing.setReturnDate(loan.getReturnDate());
        return loanRepository.save(existing);
    }

    @Override
    public void delete(String id) {
        loanRepository.deleteById(id);
    }
}


