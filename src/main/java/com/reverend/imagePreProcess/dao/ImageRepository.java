package com.reverend.imagePreProcess.dao;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.reverend.imagePreProcess.model.Batch;
import com.reverend.imagePreProcess.model.Image;

/**
 * 
 * @author vgajula
 *
 */
@Repository
public interface ImageRepository extends PagingAndSortingRepository<Image, Long>{
	
	Iterable<Image> findByBatchAndStatus(Batch batch, String status);
	
}
