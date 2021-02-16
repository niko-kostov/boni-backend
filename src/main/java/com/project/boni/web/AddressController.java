package com.project.boni.web;

import com.project.boni.model.Address;
import com.project.boni.model.dto.EditAddressDto;
import com.project.boni.model.dto.GetAddressDto;
import com.project.boni.model.dto.SaveAddressDto;
import com.project.boni.service.AddressService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "api/address", produces = MediaType.APPLICATION_JSON_VALUE)
public class AddressController {
    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }


    @GetMapping("/user/{email}")
    public List<GetAddressDto> getAddressesForUser(@PathVariable String email) {
        return this.addressService.getAllAddressesForUser(email);
    }

    @DeleteMapping("/user/{id}")
    public Address deleteAddress(@PathVariable Long id) {
        return this.addressService.deleteById(id);
    }

    @PatchMapping("/user")
    public Address editAddress(@RequestBody EditAddressDto editAddressDto) {
        return this.addressService.edit(editAddressDto);
    }

    @PostMapping("/user")
    public Address addAddress(@RequestBody SaveAddressDto saveAddressDto) {
        return this.addressService.add(saveAddressDto);
    }
}