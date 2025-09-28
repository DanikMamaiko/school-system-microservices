package com.hexagon.paymentservice.service.impl;

import com.hexagon.paymentservice.model.Payment;
import com.hexagon.paymentservice.repository.PaymentRepository;
import com.hexagon.paymentservice.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    @Override
    public Payment create(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public Optional<Payment> getById(Long id) {
        return paymentRepository.findById(id);
    }

    @Override
    public List<Payment> getAll() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment update(Long id, Payment payment) {
        Payment existing = paymentRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Payment not found: " + id));
        existing.setStudentId(payment.getStudentId());
        existing.setAmount(payment.getAmount());
        existing.setCurrency(payment.getCurrency());
        existing.setStatus(payment.getStatus());
        existing.setCreatedAt(payment.getCreatedAt());
        return paymentRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        paymentRepository.deleteById(id);
    }
}


