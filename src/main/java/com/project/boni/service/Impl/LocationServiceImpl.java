package com.project.boni.service.Impl;

import com.project.boni.model.Location;
import com.project.boni.model.exceptions.LocationNotFoundException;
import com.project.boni.repository.LocationRepository;
import com.project.boni.service.LocationService;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceImpl implements LocationService {
    private final LocationRepository locationRepository;

    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public Location save(Location location) {
        return this.locationRepository.save(location);
    }

    @Override
    public Location deleteById(Long id) {
        Location deletedLocation = this.locationRepository.findById(id).orElseThrow(() -> new LocationNotFoundException(id));
        this.locationRepository.deleteById(id);
        return deletedLocation;
    }

    @Override
    public Location findById(Long id) {
        return this.locationRepository.findById(id).orElseThrow(() -> new LocationNotFoundException(id));
    }
}