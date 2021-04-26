package com.project.boni.service.Impl;

import com.project.boni.model.Address;
import com.project.boni.model.Location;
import com.project.boni.model.User;
import com.project.boni.model.dto.EditAddressDto;
import com.project.boni.model.dto.GetAddressDto;
import com.project.boni.model.dto.SaveAddressDto;
import com.project.boni.model.exceptions.AddressNotFoundException;
import com.project.boni.model.exceptions.LocationNotFoundException;
import com.project.boni.model.exceptions.UserNotFoundException;
import com.project.boni.repository.AddressRepository;
import com.project.boni.repository.LocationRepository;
import com.project.boni.repository.UserRepository;
import com.project.boni.service.AddressService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
        this.locationRepository.delete(deleteAddress.getLocation());
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
    public GetAddressDto edit(EditAddressDto editAddressDto) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.typeMap(Address.class, GetAddressDto.class).addMappings(mapper -> {
            mapper.map(Address::getLocation, GetAddressDto::setLocationDto);
        });

        Address address = this.findById(editAddressDto.getAddressId());
        address.setStreet(editAddressDto.getStreet());
        address.setNumber(editAddressDto.getNumber());
        address.setMunicipality(editAddressDto.getMunicipality());
        address.getLocation().setLongitude(editAddressDto.getLongitude());
        address.getLocation().setLatitude(editAddressDto.getLatitude());
        return modelMapper.map(this.addressRepository.save(address), GetAddressDto.class);
    }

    public GetAddressDto add(SaveAddressDto saveAddressDto) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.typeMap(Address.class, GetAddressDto.class).addMappings(mapper -> {
            mapper.map(Address::getLocation, GetAddressDto::setLocationDto);
        });

        Address address = new Address();
        Location location = new Location();
        User user = this.userRepository.findById(saveAddressDto.getEmail())
                .orElseThrow(() -> new UserNotFoundException(saveAddressDto.getEmail()));

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
        return modelMapper.map(this.addressRepository.save(address), GetAddressDto.class);
    }

    @Override
    public List<GetAddressDto> getAllAddressesForUser(String email) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.typeMap(Address.class, GetAddressDto.class).addMappings(mapper -> {
            mapper.map(Address::getLocation, GetAddressDto::setLocationDto);
        });

        return this.addressRepository.findAll()
                .stream().filter(address -> address.getUser().getEmail().equals(email))
                .map(address -> modelMapper.map(address, GetAddressDto.class)).collect(Collectors.toList());
    }
}
