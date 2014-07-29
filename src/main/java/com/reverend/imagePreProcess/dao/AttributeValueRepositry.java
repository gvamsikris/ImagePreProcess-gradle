package com.reverend.imagePreProcess.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.reverend.imagePreProcess.model.AttributeValue;

/**
 * 
 * @author vgajula
 *
 */
@Repository
public interface AttributeValueRepositry extends CrudRepository<AttributeValue, Long>{}
