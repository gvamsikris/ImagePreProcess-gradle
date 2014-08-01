package com.reverend.imagePreProcess.dao;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.reverend.imagePreProcess.model.Attribute;

/**
 * 
 * @author vgajula
 *
 */
@Repository
public interface AttributeRepsoitory extends PagingAndSortingRepository<Attribute, Long>{}
