package com.chusnaval.biblos.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "courses")
public final class Course implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2801809157624646305L;
	private Long id;
	private String name;
	private List<UniversityCourse> universityCourses = new ArrayList<UniversityCourse>();

	@Id
	@GeneratedValue
	@Column(name = "id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + "]";
	}

	@OneToMany(mappedBy = "course")
	public List<UniversityCourse> getUniversityCourses() {
		return universityCourses;
	}

	public void setUniversityCourses(List<UniversityCourse> universityCourses) {
		this.universityCourses = universityCourses;
	}

	
}
