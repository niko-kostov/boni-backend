package com.project.boni.web;

import com.project.boni.model.Address;
import com.project.boni.model.Location;
import com.project.boni.service.AddressService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "api/address", produces = MediaType.APPLICATION_JSON_VALUE)
public class AddressController {
    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    public List<Address> findAll(){
        return this.addressService.findAll();
    }
}