package com.hexagon.schoolservice.dal.service;

import com.hexagon.schoolservice.dal.entity.Canteen;
import com.hexagon.schoolservice.dal.repository.CanteenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CanteenService {

    private final CanteenRepository canteenRepository;

    @Transactional
    public void incrementRevenue(Integer optionalRevenue) {
        Canteen canteen = canteenRepository.findById(1L).get();

        int canteenOrders = canteen.getPurchaseCount() + 1;
        int canteenRevenue = canteen.getRevenue() + optionalRevenue;

        canteen.setRevenue(canteenRevenue);
        canteen.setPurchaseCount(canteenOrders);

        canteenRepository.save(canteen);
    }
}
