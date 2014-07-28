package com.reverend.imagePreProcess.dao;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.reverend.imagePreProcess.model.Batch;

/**
 * 
 * @author vgajula
 *
 */
@Repository
public class BatchHome {

	private static final Log log = LogFactory.getLog(BatchHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Batch transientInstance) {
		log.debug("persisting Batch instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Batch persistentInstance) {
		log.debug("removing Batch instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Batch merge(Batch detachedInstance) {
		log.debug("merging Batch instance");
		try {
			Batch result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Batch findById(Long id) {
		log.debug("getting Batch instance with id: " + id);
		try {
			Batch instance = entityManager.find(Batch.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
