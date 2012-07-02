package com.chusnaval.biblos.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chusnaval.biblos.dao.ICourseDAO;
import com.chusnaval.biblos.dao.IEditionDAO;
import com.chusnaval.biblos.dao.IPublisherDAO;
import com.chusnaval.biblos.dao.IUniversityDAO;
import com.chusnaval.biblos.dao.IWriterDAO;
import com.chusnaval.biblos.model.Book;
import com.chusnaval.biblos.model.Course;
import com.chusnaval.biblos.model.Edition;
import com.chusnaval.biblos.model.Publisher;
import com.chusnaval.biblos.model.Recommendation;
import com.chusnaval.biblos.model.University;
import com.chusnaval.biblos.model.UniversityCourse;
import com.chusnaval.biblos.model.Writer;

@Transactional(readOnly = true)
@Service(value="EditionService")
public class EditionService implements IEditionService,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7280886725038398801L;
	@Autowired(required=true)
	private IEditionDAO editionDAO;
	
	@Override
	public List<Edition> getEditions() {
		return editionDAO.getEditions();
	}

	public IEditionDAO getEditionDAO() {
		return editionDAO;
	}

	public void setEditionDAO(IEditionDAO editionDAO) {
		this.editionDAO = editionDAO;
	}

	@Override
	public List<Edition> searchEditions(String textSearch) {
		return editionDAO.searchEditions(textSearch);
	}

	@Autowired(required = true)
	private IPublisherDAO publisherDAO;

	@Override
	public List<Publisher> getPublishers() {
		return publisherDAO.getPublishers();
	}

	public IPublisherDAO getPublisherDAO() {
		return publisherDAO;
	}

	public void setPublisherDAO(IPublisherDAO publisherDAO) {
		this.publisherDAO = publisherDAO;
	}
	
	@Autowired(required = true)
	private IWriterDAO writerDAO;

	@Override
	public List<Writer> getWriters() {
		return writerDAO.getWriters();
	}

	public IWriterDAO getWriterDAO() {
		return writerDAO;
	}

	public void setWriterDAO(IWriterDAO writerDAO) {
		this.writerDAO = writerDAO;
	}

	@Autowired(required = true)
	private IUniversityDAO universityDAO;

	@Override
	public List<University> getUniversities() {
		return universityDAO.getUniversities();
	}

	public IUniversityDAO getUniversityDAO() {
		return universityDAO;
	}

	public void setUniversityDAO(IUniversityDAO universityDAO) {
		this.universityDAO = universityDAO;
	}

	@Autowired(required = true)
	private ICourseDAO courseDAO;

	public ICourseDAO getCourseDAO() {
		return courseDAO;
	}

	public void setCourseDAO(ICourseDAO courseDAO) {
		this.courseDAO = courseDAO;
	}

	@Override
	public List<Course> getCourses() {
		return courseDAO.getCourses();
	}

	@Override
	@Transactional(readOnly = false)
	public void saveEdition(Edition edition) {
		this.editionDAO.saveEdition(edition);
	}

	@Override
	@Transactional(readOnly = false)
	public void saveBook(Book book) {
		this.editionDAO.saveBook(book);
	}

	@Override
	public Writer loadWriterBy(Long id) {
		return this.editionDAO.loadWriterBy(id);
	}

	@Override
	public Publisher loadPublisherBy(Long id) {
		return this.editionDAO.loadPublisherBy(id);
	}

	@Override
	public Course loadCourseBy(Long id) {
		return this.editionDAO.loadCourseBy(id);
	}

	@Override
	public University loadUniversityBy(long id) {
		return this.editionDAO.loadUniversityBy(id);
	}

	@Override
	public UniversityCourse loadUniversityCourseBy(Long idUniversity,
			Long idCourse) {
		return this.editionDAO.loadUniversityCourseBy(idUniversity, idCourse);
	}

	@Override
	public void saveRecommendation(Recommendation rec) {
		this.editionDAO.saveRecommendation(rec);
		
	}
}
