package com.chusnaval.biblos.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "universityrecommendations")
public class Recommendation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5492592229663511423L;
	private long id;
	private String text;
	private Edition edition;
	private University university;
	private Course course;

	@Id
	@GeneratedValue
	@Column(name = "id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "text")
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idEdition", nullable = false)
	public Edition getEdition() {
		return edition;
	}

	public void setEdition(Edition edition) {
		this.edition = edition;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idUniversity", nullable = false)
	public University getUniversity() {
		return university;
	}

	public void setUniversity(University university) {
		this.university = university;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idCourse", nullable = false)
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

}
