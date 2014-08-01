package com.reverend.imagePreProcess.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.reverend.imagePreProcess.model.Image;

/**
 * 
 * @author vgajula
 *
 */
@Repository
public interface ImageRepository extends PagingAndSortingRepository<Image, Long>{}
