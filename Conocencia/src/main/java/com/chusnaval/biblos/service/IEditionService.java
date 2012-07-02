package com.chusnaval.biblos.service;

import java.util.List;

import com.chusnaval.biblos.model.Book;
import com.chusnaval.biblos.model.Course;
import com.chusnaval.biblos.model.Edition;
import com.chusnaval.biblos.model.Publisher;
import com.chusnaval.biblos.model.Recommendation;
import com.chusnaval.biblos.model.University;
import com.chusnaval.biblos.model.UniversityCourse;
import com.chusnaval.biblos.model.Writer;

public interface IEditionService {

	List<Edition> getEditions();

	List<Edition> searchEditions(String textSearch);

	List<Publisher> getPublishers();

	List<University> getUniversities();

	List<Writer> getWriters();

	List<Course> getCourses();

	void saveEdition(Edition edition);

	void saveBook(Book book);

	Writer loadWriterBy(Long id);

	Publisher loadPublisherBy(Long id);

	Course loadCourseBy(Long id);

	University loadUniversityBy(long id);

	UniversityCourse loadUniversityCourseBy(Long idUniversity, Long idCourse);

	void saveRecommendation(Recommendation rec);

}
