package com.hexagon.paymentservice.service;

import com.hexagon.paymentservice.model.Payment;

import java.util.List;
import java.util.Optional;

public interface PaymentService {
    Payment create(Payment payment);
    Optional<Payment> getById(Long id);
    List<Payment> getAll();
    Payment update(Long id, Payment payment);
    void delete(Long id);
}


