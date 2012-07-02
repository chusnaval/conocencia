package com.chusnaval.biblos.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "universities")
public class University implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2787537129829328893L;
	private long id;
	private String name;
	private Country country;
	private List<UniversityCourse> universityCourses  = new ArrayList<UniversityCourse>();

	@Id
	@GeneratedValue
	@Column(name = "id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToOne
	@JoinColumn(name = "idCountry", nullable = false)
	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@OneToMany(mappedBy = "university")
	public List<UniversityCourse> getUniversityCourses() {
		return universityCourses;
	}

	public void setUniversityCourses(List<UniversityCourse> universityCourses) {
		this.universityCourses = universityCourses;
	}

}
