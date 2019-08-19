package com.longnguyen.service.impl;

import com.longnguyen.model.City;
import com.longnguyen.repository.CityRepository;
import com.longnguyen.service.ThanhPhoService;
import org.springframework.beans.factory.annotation.Autowired;

public class ThanhPhoServiceImpl implements ThanhPhoService {

    @Autowired
    CityRepository cityRepository;

    @Override
    public Iterable<City> findAll() {
        return cityRepository.findAll();
    }

    @Override
    public City findById(Long id) {
        return cityRepository.findOne(id);
    }

    @Override
    public void save(City city) {
        cityRepository.save(city);
    }

    @Override
    public void remove(Long id) {
        cityRepository.delete(id);
    }

    @Override
    public Iterable<City> findAllByTenThanhPhoContaining(String name) {
        return cityRepository.findAllByTenThanhPhoContaining(name);
    }
}
