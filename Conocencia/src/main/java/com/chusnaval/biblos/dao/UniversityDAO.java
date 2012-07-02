package com.chusnaval.biblos.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.chusnaval.biblos.model.University;

@Repository("UniversityDAO")
public class UniversityDAO implements IUniversityDAO, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1643243680362961019L;
	private EntityManager entityManagerFactory;

	@Override
	@SuppressWarnings("unchecked")
	public List<University> getUniversities() {
		return entityManagerFactory.createQuery("from University")
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
