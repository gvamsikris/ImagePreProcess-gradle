package com.reverend.imagePreProcess.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.reverend.imagePreProcess.model.Batch;

/**
 * 
 * @author vgajula
 *
 */
@Repository
public interface BatchRepository extends PagingAndSortingRepository<Batch, Long> {}
