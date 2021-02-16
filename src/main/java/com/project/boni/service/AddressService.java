package com.project.boni.service;

import com.project.boni.model.Address;
import com.project.boni.model.Category;
import com.project.boni.model.Location;
import com.project.boni.model.User;
import com.project.boni.model.dto.EditAddressDto;
import com.project.boni.model.dto.EditCategoryDto;
import com.project.boni.model.dto.SaveAddressDto;
import com.project.boni.model.enums.Municipality;

import java.util.List;

public interface AddressService {

    Address findById(Long id);

    Address deleteById(Long id);

    Address save(Address address);

    List<Address> findAll();

    Address edit(EditAddressDto editAddressDto);

    Address add(SaveAddressDto saveAddressDto);
}
