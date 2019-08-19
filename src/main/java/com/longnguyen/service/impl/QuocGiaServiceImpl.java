package com.longnguyen.service.impl;

import com.longnguyen.model.QuocGia;
import com.longnguyen.repository.QuocGiaRepository;
import com.longnguyen.service.QuocGiaService;
import org.springframework.beans.factory.annotation.Autowired;

public class QuocGiaServiceImpl implements QuocGiaService {

    @Autowired
    QuocGiaRepository quocGiaRepository;

    @Override
    public Iterable<QuocGia> findAll() {
        return quocGiaRepository.findAll();
    }

    @Override
    public QuocGia findById(Long id) {
        return quocGiaRepository.findOne(id);
    }

    @Override
    public void save(QuocGia quocGia) {
        quocGiaRepository.save(quocGia);
    }

    @Override
    public void remove(Long id) {
        quocGiaRepository.delete(id);
    }
}
