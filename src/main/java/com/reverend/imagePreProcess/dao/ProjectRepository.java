package com.reverend.imagePreProcess.dao;


import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import com.reverend.imagePreProcess.model.Project;

/**
 * 
 * @author vgajula
 *
 */
@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {}
