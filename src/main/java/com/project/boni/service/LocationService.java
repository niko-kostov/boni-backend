package com.project.boni.service;

import com.project.boni.model.Location;

public interface LocationService {
    Location save (Location location);

    Location deleteById(Long id);

    Location findById(Long id);
}
