package com.chusnaval.biblos.managed;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.primefaces.event.FlowEvent;
import org.springframework.dao.DataAccessException;

import com.chusnaval.biblos.model.Book;
import com.chusnaval.biblos.model.Course;
import com.chusnaval.biblos.model.Edition;
import com.chusnaval.biblos.model.Publisher;
import com.chusnaval.biblos.model.Recommendation;
import com.chusnaval.biblos.model.University;
import com.chusnaval.biblos.model.UniversityCourse;
import com.chusnaval.biblos.model.Writer;
import com.chusnaval.biblos.service.IEditionService;

@SessionScoped
@ManagedBean(name = "editionMB")
public class EditionManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6148224551170199523L;

	private static Logger logger = Logger.getLogger(EditionManagedBean.class.getName()); 
	
	@ManagedProperty(value = "#{EditionService}")
	private IEditionService editionService;

	private String textSearch;
	private String recommendationText;
	private String writersText;
	
	private List<Edition> editions;

	private Book book = new Book();
	private Course course = new Course();
	private Edition edition = new Edition();
	private Publisher publisher = new Publisher();
	private University university = new University();
	private List<String> selectedWriters = new ArrayList<String>();
	
	public List<Edition> getEditions() {
		return editions;
	}

	public IEditionService getEditionService() {
		return editionService;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public List<Publisher> getPublishers() {
		return editionService.getPublishers();
	}

	public List<Course> getCourses() {
		return editionService.getCourses();
	}

	public String getTextSearch() {
		return textSearch;
	}

	public List<University> getUniversities() {
		return editionService.getUniversities();
	}

	public University getUniversity() {
		return university;
	}

	public List<Writer> getWriters() {
		return editionService.getWriters();
	}

	/**
	 * Reset Fields
	 * 
	 */
	public void reset() {
		this.setTextSearch("");
	}

	public void search() {
		try {

			this.setEditions(getEditionService()
					.searchEditions(getTextSearch()));
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
	}

	private void setEditions(List<Edition> editionsParam) {
		this.editions = editionsParam;
	}

	public void setEditionService(IEditionService editionService) {
		this.editionService = editionService;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public void setTextSearch(String textSearch) {
		this.textSearch = textSearch;
	}

	public void setUniversity(University university) {
		this.university = university;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Edition getEdition() {
		return edition;
	}

	public void setEdition(Edition edition) {
		this.edition = edition;
	}

	public String getRecommendationText() {
		return recommendationText;
	}

	public void setRecommendationText(String recommendationText) {
		this.recommendationText = recommendationText;
	}

	public void saveBook() {
		
		for(String wr: selectedWriters){
			Writer writer = this.editionService.loadWriterBy(Long.valueOf(wr));
			this.book.getWriters().add(writer);
			writer.getBooks().add(book);
		}
		
		this.edition.setBook(getBook());
		this.editionService.saveBook(getBook());
		
		
		Publisher pub = new Publisher();
		pub.setId(this.getPublisher().getId());
		this.edition.setPublisher(pub);
		
		this.book.getEditions().add(this.edition);
		this.editionService.saveEdition(this.edition);
		
		
		this.setCourse(this.editionService.loadCourseBy(this.getCourse().getId()));
		this.setUniversity(this.editionService.loadUniversityBy(this.getUniversity().getId()));

		Recommendation rec = new Recommendation();
		UniversityCourse uc = this.editionService.loadUniversityCourseBy(this.getUniversity().getId(), this.getCourse().getId());
		
		rec.setUniversityCourse(uc);
		rec.setEdition(getEdition());
		rec.setText(getRecommendationText());
		this.edition.getRecommendations().add(rec);
		
		this.editionService.saveRecommendation(rec);
		
	}
	
	public String onFlowProcess(FlowEvent event){
		logger.info("Current wizard step:" + event.getOldStep());
		logger.info("Next step:" + event.getNewStep()); 
		return event.getNewStep();
	}

	public String getWritersText() {
		return writersText;
	}

	public void setWritersText(String writersText) {
		this.writersText = writersText;
	}

	public List<String> getSelectedWriters() {
		return selectedWriters;
	}

	public void setSelectedWriters(List<String> selectedWriters) {
		this.selectedWriters = selectedWriters;
	}


	
	
}
