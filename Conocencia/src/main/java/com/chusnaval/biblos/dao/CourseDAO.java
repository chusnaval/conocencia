package com.chusnaval.biblos.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.chusnaval.biblos.model.Course;

@Repository("CourseDAO")
public class CourseDAO implements ICourseDAO,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2946818959095358619L;
	private EntityManager entityManagerFactory;

	@Override
	@SuppressWarnings("unchecked")
	public List<Course> getCourses() {
		return this.entityManagerFactory.createQuery("from Course")
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
