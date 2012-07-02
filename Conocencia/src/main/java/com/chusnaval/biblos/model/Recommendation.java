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
@Table(name = "universityrecommendations")
public class Recommendation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5492592229663511423L;
	private long id;
	private String text;
	private Edition edition;
	private UniversityCourse universityCourse;


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

	@ManyToOne
	@JoinColumn(name = "idEdition", nullable = false)
	public Edition getEdition() {
		return edition;
	}

	public void setEdition(Edition edition) {
		this.edition = edition;
	}

	@ManyToOne
	@JoinColumn(name = "idUniversityCourse", nullable = false)
	public UniversityCourse getUniversityCourse() {
		return universityCourse;
	}

	public void setUniversityCourse(UniversityCourse universityCourse) {
		this.universityCourse = universityCourse;
	}



}
