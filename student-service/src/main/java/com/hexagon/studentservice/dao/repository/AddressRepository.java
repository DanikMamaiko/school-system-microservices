package com.hexagon.studentservice.dao.repository;

import com.hexagon.studentservice.dao.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}


