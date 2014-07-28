package com.reverend.imagePreProcess.dao;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.reverend.imagePreProcess.model.AttributeType;

/**
 * 
 * @author vgajula
 *
 */
@Repository
public class AttributeTypeHome {

	private static final Log log = LogFactory.getLog(AttributeTypeHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(AttributeType transientInstance) {
		log.debug("persisting AttributeType instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(AttributeType persistentInstance) {
		log.debug("removing AttributeType instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public AttributeType merge(AttributeType detachedInstance) {
		log.debug("merging AttributeType instance");
		try {
			AttributeType result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AttributeType findById(Long id) {
		log.debug("getting AttributeType instance with id: " + id);
		try {
			AttributeType instance = entityManager.find(AttributeType.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
