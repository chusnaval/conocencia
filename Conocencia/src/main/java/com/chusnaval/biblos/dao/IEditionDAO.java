package com.chusnaval.biblos.dao;

import java.util.List;

import com.chusnaval.biblos.model.Book;
import com.chusnaval.biblos.model.Course;
import com.chusnaval.biblos.model.Edition;
import com.chusnaval.biblos.model.Publisher;
import com.chusnaval.biblos.model.Recommendation;
import com.chusnaval.biblos.model.University;
import com.chusnaval.biblos.model.UniversityCourse;
import com.chusnaval.biblos.model.Writer;

public interface IEditionDAO {

	List<Edition> getEditions();

	List<Edition> searchEditions(String textSearch);

	void saveEdition(Edition edition);

	void saveBook(Book book);

	Publisher loadPublisherBy(Long id);

	Writer loadWriterBy(Long id);

	Course loadCourseBy(Long id);

	University loadUniversityBy(long id);

	UniversityCourse loadUniversityCourseBy(Long idUniversity, Long idCourse);

	void saveRecommendation(Recommendation rec);

}
