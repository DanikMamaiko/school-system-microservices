package com.hexagon.studentservice.dao.service;

import com.hexagon.studentservice.dao.entity.Address;

import java.util.List;
import java.util.Optional;

public interface AddressService {
    Address create(Address address);
    Optional<Address> getById(Long id);
    List<Address> getAll();
    Address update(Long id, Address address);
    void delete(Long id);
}


