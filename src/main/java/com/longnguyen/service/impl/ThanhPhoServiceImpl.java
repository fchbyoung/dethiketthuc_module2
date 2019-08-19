package com.longnguyen.service.impl;

import com.longnguyen.model.ThanhPho;
import com.longnguyen.repository.ThanhPhoRepository;
import com.longnguyen.service.ThanhPhoService;
import org.springframework.beans.factory.annotation.Autowired;

public class ThanhPhoServiceImpl implements ThanhPhoService {

    @Autowired
    ThanhPhoRepository thanhPhoRepository;

    @Override
    public Iterable<ThanhPho> findAll() {
        return thanhPhoRepository.findAll();
    }

    @Override
    public ThanhPho findById(Long id) {
        return thanhPhoRepository.findOne(id);
    }

    @Override
    public void save(ThanhPho thanhPho) {
        thanhPhoRepository.save(thanhPho);
    }

    @Override
    public void remove(Long id) {
        thanhPhoRepository.delete(id);
    }

    @Override
    public Iterable<ThanhPho> findAllByTenThanhPhoContaining(String name) {
        return thanhPhoRepository.findAllByTenThanhPhoContaining(name);
    }
}
