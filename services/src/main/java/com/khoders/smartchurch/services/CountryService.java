package com.khoders.smartchurch.services;

import com.khoders.smartchurch.entities.Country;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CountryService {
    List<Country> findAll();

    Country save(Country position);

    Optional<Country> findEntityById(String id);

    void delete(String id);
}
