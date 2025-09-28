package com.hexagon.paymentservice.service.impl;

import com.hexagon.paymentservice.model.Payout;
import com.hexagon.paymentservice.repository.PayoutRepository;
import com.hexagon.paymentservice.service.PayoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PayoutServiceImpl implements PayoutService {

    private final PayoutRepository payoutRepository;

    @Override
    public Payout create(Payout payout) {
        return payoutRepository.save(payout);
    }

    @Override
    public Optional<Payout> getById(Long id) {
        return payoutRepository.findById(id);
    }

    @Override
    public List<Payout> getAll() {
        return payoutRepository.findAll();
    }

    @Override
    public Payout update(Long id, Payout payout) {
        Payout existing = payoutRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Payout not found: " + id));
        existing.setTeacherId(payout.getTeacherId());
        existing.setAmount(payout.getAmount());
        existing.setCurrency(payout.getCurrency());
        existing.setStatus(payout.getStatus());
        existing.setCreatedAt(payout.getCreatedAt());
        return payoutRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        payoutRepository.deleteById(id);
    }
}


