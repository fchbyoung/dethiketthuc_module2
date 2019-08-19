package com.longnguyen.service;

import com.longnguyen.model.City;

public interface ThanhPhoService {

    Iterable<City> findAll();

    City findById(Long id);

    void save(City city);

    void remove(Long id);

    Iterable<City> findAllByTenThanhPhoContaining(String name);
}
