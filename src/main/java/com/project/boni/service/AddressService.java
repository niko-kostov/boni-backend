package com.project.boni.service;

import com.project.boni.model.Address;

public interface AddressService {

    Address findById(Long id);

    Address deleteById(Long id);

    Address save(Address address);
}
