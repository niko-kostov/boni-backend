package com.project.boni.web;

import com.project.boni.model.Address;
import com.project.boni.model.Category;
import com.project.boni.model.Location;
import com.project.boni.model.dto.EditAddressDto;
import com.project.boni.model.dto.EditCategoryDto;
import com.project.boni.model.dto.SaveAddressDto;
import com.project.boni.model.dto.SaveCategoryDto;
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


//    @GetMapping("/{email}")
//    public List<Address> getAddressesForUser(@PathVariable String email)
//    {
//
//    }

    @DeleteMapping("/delete/{id}")
    public Address deleteAddress(@PathVariable Long id)
    {
        return this.addressService.deleteById(id);
    }

    @PostMapping("/edit")
    public Address editAddress (@RequestBody EditAddressDto editAddressDto){
        return this.addressService.edit(editAddressDto);
    }

    @PostMapping("/add")
    public Address addAddress (@RequestBody SaveAddressDto saveAddressDto){
        return this.addressService.add(saveAddressDto);
    }
}
