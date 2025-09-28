package com.hexagon.paymentservice.service;

import com.hexagon.paymentservice.model.Refund;

import java.util.List;
import java.util.Optional;

public interface RefundService {
    Refund create(Refund refund);
    Optional<Refund> getById(Long id);
    List<Refund> getAll();
    Refund update(Long id, Refund refund);
    void delete(Long id);
}


