package com.reverend.imagePreProcess.dao;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.reverend.imagePreProcess.model.AttributeValue;

/**
 * 
 * @author vgajula
 *
 */
@Repository
public class AttributeValueHome {

	private static final Log log = LogFactory.getLog(AttributeValueHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(AttributeValue transientInstance) {
		log.debug("persisting AttributeValue instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(AttributeValue persistentInstance) {
		log.debug("removing AttributeValue instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public AttributeValue merge(AttributeValue detachedInstance) {
		log.debug("merging AttributeValue instance");
		try {
			AttributeValue result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AttributeValue findById(Long id) {
		log.debug("getting AttributeValue instance with id: " + id);
		try {
			AttributeValue instance = entityManager.find(AttributeValue.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
