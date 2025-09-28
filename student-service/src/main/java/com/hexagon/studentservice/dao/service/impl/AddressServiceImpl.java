package com.hexagon.studentservice.dao.service.impl;

import com.hexagon.studentservice.dao.entity.Address;
import com.hexagon.studentservice.dao.repository.AddressRepository;
import com.hexagon.studentservice.dao.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    @Override
    public Address create(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Optional<Address> getById(Long id) {
        return addressRepository.findById(id);
    }

    @Override
    public List<Address> getAll() {
        return addressRepository.findAll();
    }

    @Override
    public Address update(Long id, Address address) {
        Address existing = addressRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Address not found: " + id));
        existing.setStreet(address.getStreet());
        existing.setCity(address.getCity());
        existing.setState(address.getState());
        existing.setPostalCode(address.getPostalCode());
        return addressRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        addressRepository.deleteById(id);
    }
}


