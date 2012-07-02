package com.chusnaval.biblos.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.chusnaval.biblos.model.Publisher;

@Repository("PublisherDAO")
public class PublisherDAO implements IPublisherDAO, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2674069980443537678L;
	private EntityManager entityManagerFactory;

	@Override
	@SuppressWarnings("unchecked")
	public List<Publisher> getPublishers() {
		return entityManagerFactory.createQuery("from Publisher")
				.getResultList();
	}

	public EntityManager getEntityManagerFactory() {
		return entityManagerFactory;
	}

	@PersistenceContext
	public void setEntityManagerFactory(EntityManager entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}

}
