package com.reverend.imagePreProcess.dao;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.reverend.imagePreProcess.model.AttributeType;

/**
 * 
 * @author vgajula
 *
 */
@Repository
public interface AttributeTypeRepository extends PagingAndSortingRepository<AttributeType, Long>{}
