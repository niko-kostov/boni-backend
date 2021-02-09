package com.project.boni.service.Impl;

import com.project.boni.model.Address;
import com.project.boni.model.Location;
import com.project.boni.model.User;
import com.project.boni.model.dto.EditAddressDto;
import com.project.boni.model.dto.SaveAddressDto;
import com.project.boni.model.exceptions.AddressNotFoundException;
import com.project.boni.model.exceptions.UserNotFoundException;
import com.project.boni.repository.AddressRepository;
import com.project.boni.repository.LocationRepository;
import com.project.boni.repository.UserRepository;
import com.project.boni.service.AddressService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;

    private final UserRepository userRepository;

    private final LocationRepository locationRepository;

    public AddressServiceImpl(AddressRepository addressRepository, UserRepository userRepository, LocationRepository locationRepository) {
        this.addressRepository = addressRepository;
        this.userRepository = userRepository;
        this.locationRepository = locationRepository;
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

    @Override
    public Address edit(EditAddressDto editAddressDto) {
       // Optional<User> user=this.userRepository.findById(editAddressDto.getEmail());
        Address address=this.findById(editAddressDto.getId());
        address.setStreet(editAddressDto.getStreet());
        address.setNumber(editAddressDto.getNumber());
        address.setMunicipality(editAddressDto.getMunicipality());
        address.setLocation(editAddressDto.getLocation());
        return this.addressRepository.save(address);
    }

    public Address add(SaveAddressDto saveAddressDto)
    {
        Address address=new Address();
        Location location=new Location();
        User user=this.userRepository.findById(saveAddressDto.getEmail()).orElseThrow(()->new UserNotFoundException(saveAddressDto.getEmail()));
        location.setLatitude(saveAddressDto.getLatitude());
        location.setLongitude(saveAddressDto.getLongitude());
        address.setStreet(saveAddressDto.getStreet());
        address.setNumber(saveAddressDto.getNumber());
        address.setMunicipality(saveAddressDto.getMunicipality());
        this.addressRepository.save(address);
        address.setLocation(location);
        location.setAddress(address);
        address.setUser(user);
        this.locationRepository.save(location);
        return this.addressRepository.save(address);
    }


}
