package com.hexagon.paymentservice.service.impl;

import com.hexagon.paymentservice.model.Refund;
import com.hexagon.paymentservice.repository.RefundRepository;
import com.hexagon.paymentservice.service.RefundService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RefundServiceImpl implements RefundService {

    private final RefundRepository refundRepository;

    @Override
    public Refund create(Refund refund) {
        return refundRepository.save(refund);
    }

    @Override
    public Optional<Refund> getById(Long id) {
        return refundRepository.findById(id);
    }

    @Override
    public List<Refund> getAll() {
        return refundRepository.findAll();
    }

    @Override
    public Refund update(Long id, Refund refund) {
        Refund existing = refundRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Refund not found: " + id));
        existing.setPaymentId(refund.getPaymentId());
        existing.setAmount(refund.getAmount());
        existing.setReason(refund.getReason());
        existing.setStatus(refund.getStatus());
        existing.setCreatedAt(refund.getCreatedAt());
        return refundRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        refundRepository.deleteById(id);
    }
}


