package com.example.test_module_4.service;

import com.example.test_module_4.model.Country;

import java.util.Optional;

public interface ICountryService {
    Country save(Country country);
    Optional<Country>findById(Long id);
    void remove(Long id);
    Iterable<Country>findAll();
}
