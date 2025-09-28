package com.hexagon.paymentservice.repository;

import com.hexagon.paymentservice.model.Payout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayoutRepository extends JpaRepository<Payout, Long> {
}


