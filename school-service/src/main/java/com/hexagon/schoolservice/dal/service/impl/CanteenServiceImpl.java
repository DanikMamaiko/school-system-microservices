package com.hexagon.schoolservice.dal.service.impl;

import com.hexagon.schoolservice.dal.entity.CanteenEntity;
import com.hexagon.schoolservice.dal.repository.CanteenRepository;
import com.hexagon.schoolservice.dal.service.CanteenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CanteenServiceImpl implements CanteenService {

    private final CanteenRepository canteenRepository;

    @Override
    @Transactional
    public void incrementRevenue(Integer optionalRevenue) {
        CanteenEntity canteenEntity = canteenRepository.findById(1L).get();

        int canteenOrders = canteenEntity.getPurchaseCount() + 1;
        int canteenRevenue = canteenEntity.getRevenue() + optionalRevenue;

        canteenEntity.setRevenue(canteenRevenue);
        canteenEntity.setPurchaseCount(canteenOrders);

        canteenRepository.save(canteenEntity);
    }
}
