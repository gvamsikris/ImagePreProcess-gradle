package com.reverend.imagePreProcess.dao;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.reverend.imagePreProcess.model.Image;

/**
 * 
 * @author vgajula
 *
 */
@Repository
public class ImageHome {

	private static final Log log = LogFactory.getLog(ImageHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Image transientInstance) {
		log.debug("persisting Image instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Image persistentInstance) {
		log.debug("removing Image instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Image merge(Image detachedInstance) {
		log.debug("merging Image instance");
		try {
			Image result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Image findById(Long id) {
		log.debug("getting Image instance with id: " + id);
		try {
			Image instance = entityManager.find(Image.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
