package com.example.test_module_4.service;

import com.example.test_module_4.model.City;
import com.example.test_module_4.repo.ICityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CityService implements ICityService{
    @Autowired
    private ICityRepo ctyRepo;
    @Override
    public City save(City city) {
         return ctyRepo.save(city);
    }

    @Override
    public Optional<City> findById(Long id) {
        return ctyRepo.findById(id);
    }

    @Override
    public Iterable<City> findAll() {
        return ctyRepo.findAll();
    }

    @Override
    public void remove(Long id) {
     ctyRepo.deleteById(id);
    }
}
