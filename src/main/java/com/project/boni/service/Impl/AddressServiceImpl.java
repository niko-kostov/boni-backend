package com.project.boni.service.Impl;

import com.project.boni.model.Address;
import com.project.boni.model.exceptions.AddressNotFoundException;
import com.project.boni.repository.AddressRepository;
import com.project.boni.service.AddressService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address findById(Long id) {
        return this.addressRepository.findById(id).orElseThrow(() -> new AddressNotFoundException(id));
    }

    @Override
    public Address deleteById(Long id) {
        Address deleteAddress = this.addressRepository.findById(id).orElseThrow(() -> new AddressNotFoundException(id));
        this.addressRepository.deleteById(id);
        return deleteAddress;
    }

    @Override
    public Address save(Address address) {
        return this.addressRepository.save(address);
    }

    @Override
    public List<Address> findAll() {
        return this.addressRepository.findAll();
    }
}
