package com.longnguyen.repository;

import com.longnguyen.model.ThanhPho;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ThanhPhoRepository extends PagingAndSortingRepository<ThanhPho , Long> {

    Iterable<ThanhPho> findAllByTenThanhPhoContaining(String name);

}
