package com.chusnaval.biblos.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "universityCourses")
public class UniversityCourse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1689915069954541731L;
	private Long id;
	private University university;
	private Course course;
	
	@Id
	@GeneratedValue
	@Column(name = "id")	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "idUniversity", nullable = false)
	public University getUniversity() {
		return university;
	}

	public void setUniversity(University university) {
		this.university = university;
	}

	@ManyToOne
	@JoinColumn(name = "idCourse", nullable = false)
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
}
