package com.longnguyen.repository;

import com.longnguyen.model.Country;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface QuocGiaRepository extends PagingAndSortingRepository<Country, Long> {
}
