package com.longnguyen.repository;

import com.longnguyen.model.City;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ThanhPhoRepository extends PagingAndSortingRepository<City, Long> {

    Iterable<City> findAllByTenThanhPhoContaining(String name);

}
