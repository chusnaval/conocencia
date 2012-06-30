package com.chusnaval.biblos.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "writers")
public class Writer implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6404627660387055312L;
	private Long id;
	private String name;

	@Id
	@GeneratedValue
	@Column(name = "id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "name", nullable = false, length = 100)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Writer [id=" + id + ", name=" + name + "]";
	}

}
