package com.longnguyen.service;

import com.longnguyen.model.QuocGia;

public interface QuocGiaService {

    Iterable<QuocGia> findAll();

    QuocGia findById(Long id);

    void save(QuocGia quocGia);

    void remove(Long id);

}
