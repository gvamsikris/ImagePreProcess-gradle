package com.reverend.imagePreProcess.dao;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.reverend.imagePreProcess.model.Attribute;

/**
 * 
 * @author vgajula
 *
 */
@Repository
public class AttributeHome {

	private static final Log log = LogFactory.getLog(AttributeHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Attribute transientInstance) {
		log.debug("persisting Attribute instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Attribute persistentInstance) {
		log.debug("removing Attribute instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Attribute merge(Attribute detachedInstance) {
		log.debug("merging Attribute instance");
		try {
			Attribute result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Attribute findById(Long id) {
		log.debug("getting Attribute instance with id: " + id);
		try {
			Attribute instance = entityManager.find(Attribute.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
