package com.example.test_module_4.service;

import com.example.test_module_4.model.Country;
import com.example.test_module_4.repo.ICountryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CountryService implements ICountryService{
    @Autowired
    private ICountryRepo countryRepo;
    @Override
    public Country save(Country country) {
        return countryRepo.save(country);
    }

    @Override
    public Optional<Country> findById(Long id) {
        return countryRepo.findById(id);
    }

    @Override
    public void remove(Long id) {
      countryRepo.findById(id);
    }

    @Override
    public Iterable<Country> findAll() {
        return null;
    }
}
