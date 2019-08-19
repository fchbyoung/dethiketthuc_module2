package com.longnguyen.service;

import com.longnguyen.model.ThanhPho;

public interface ThanhPhoService {

    Iterable<ThanhPho> findAll();

    ThanhPho findById(Long id);

    void save(ThanhPho thanhPho);

    void remove(Long id);

    Iterable<ThanhPho> findAllByTenThanhPhoContaining(String name);
}
