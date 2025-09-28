package com.hexagon.paymentservice.service;

import com.hexagon.paymentservice.model.Payout;

import java.util.List;
import java.util.Optional;

public interface PayoutService {
    Payout create(Payout payout);
    Optional<Payout> getById(Long id);
    List<Payout> getAll();
    Payout update(Long id, Payout payout);
    void delete(Long id);
}


