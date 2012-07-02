package com.chusnaval.biblos.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.chusnaval.biblos.model.Book;
import com.chusnaval.biblos.model.Course;
import com.chusnaval.biblos.model.Edition;
import com.chusnaval.biblos.model.Publisher;
import com.chusnaval.biblos.model.Recommendation;
import com.chusnaval.biblos.model.University;
import com.chusnaval.biblos.model.UniversityCourse;
import com.chusnaval.biblos.model.Writer;

@Transactional(readOnly = true)
@Repository("EditionDAO")
public class EditionDAO implements IEditionDAO,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1161793175350102788L;
	private EntityManager entityManagerFactory;

	@Override
	@SuppressWarnings("unchecked")
	public List<Edition> getEditions() {
		return this.entityManagerFactory.createQuery("from Edition")
				.getResultList();
	}

	public EntityManager getEntityManagerFactory() {
		return entityManagerFactory;
	}

	@PersistenceContext
	public void setEntityManagerFactory(EntityManager entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Edition> searchEditions(String textSearch) {
		if (textSearch == null || textSearch.trim().isEmpty()) {
			return this.entityManagerFactory.createQuery("from Edition")
					.getResultList();
		}
		return this.entityManagerFactory
				.createQuery("from Edition edition where edition.book.title=?")
				.setParameter(0, textSearch).getResultList();
	}

	@Override
	@Transactional(readOnly = false)
	public void saveEdition(Edition edition) {
		this.entityManagerFactory.persist(edition);
	}

	@Override
	@Transactional(readOnly = false)
	public void saveBook(Book book) {
		this.entityManagerFactory.persist(book);
	}

	@Override
	public Publisher loadPublisherBy(Long id) {
		return this.entityManagerFactory.find(Publisher.class,id);
	}

	@Override
	public Writer loadWriterBy(Long id) {
		return this.entityManagerFactory.find(Writer.class,id);
	}

	@Override
	public Course loadCourseBy(Long id) {
		return this.entityManagerFactory.find(Course.class,id);
	}

	@Override
	public University loadUniversityBy(long id) {
		return this.entityManagerFactory.find(University.class,id);
	}

	@Override
	public UniversityCourse loadUniversityCourseBy(Long idUniversity,
			Long idCourse) {
		return (UniversityCourse)this.entityManagerFactory
				.createQuery("from UniversityCourse uc where uc.university.id=? and uc.course.id=?")
				.setParameter(1, idUniversity).setParameter(2, idCourse).getSingleResult();
	}

	@Override
	@Transactional(readOnly = false)
	public void saveRecommendation(Recommendation rec) {
		this.entityManagerFactory.persist(rec);
		
	}

}
