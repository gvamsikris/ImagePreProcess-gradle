package com.reverend.imagePreProcess.dao;


import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.reverend.imagePreProcess.model.Project;

/**
 * 
 * @author vgajula
 *
 */
@Repository
public interface ProjectRepository extends PagingAndSortingRepository<Project, Long> {}
