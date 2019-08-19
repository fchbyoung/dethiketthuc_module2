package com.longnguyen.service;

import com.longnguyen.model.Country;

public interface QuocGiaService {

    Iterable<Country> findAll();

    Country findById(Long id);

    void save(Country country);

    void remove(Long id);

}
