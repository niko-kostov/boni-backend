package com.project.boni.service;

import com.project.boni.model.Address;

import java.util.List;

public interface AddressService {

    Address findById(Long id);

    Address deleteById(Long id);

    Address save(Address address);

    List<Address> findAll();
}
