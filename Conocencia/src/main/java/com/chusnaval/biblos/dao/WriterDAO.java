package com.chusnaval.biblos.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.chusnaval.biblos.model.Writer;

@Repository("WriterDAO")
public class WriterDAO implements IWriterDAO, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3095064796660487765L;
	private EntityManager entityManagerFactory;

	@Override
	@SuppressWarnings("unchecked")
	public List<Writer> getWriters() {
		return entityManagerFactory.createQuery("from Writer").getResultList();
	}

	public EntityManager getEntityManagerFactory() {
		return entityManagerFactory;
	}

	@PersistenceContext
	public void setEntityManagerFactory(EntityManager entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}

}
