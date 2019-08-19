package com.longnguyen.service.impl;

import com.longnguyen.model.Country;
import com.longnguyen.repository.CountryRepository;
import com.longnguyen.service.QuocGiaService;
import org.springframework.beans.factory.annotation.Autowired;

public class QuocGiaServiceImpl implements QuocGiaService {

    @Autowired
    CountryRepository countryRepository;

    @Override
    public Iterable<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Country findById(Long id) {
        return countryRepository.findOne(id);
    }

    @Override
    public void save(Country country) {
        countryRepository.save(country);
    }

    @Override
    public void remove(Long id) {
        countryRepository.delete(id);
    }
}
