package com.example.test_module_4.service;

import com.example.test_module_4.model.City;

import java.util.Optional;

public interface ICityService {
    City save(City city);
    Optional<City>findById(Long id);
    Iterable<City>findAll();
    void remove(Long id);
}
