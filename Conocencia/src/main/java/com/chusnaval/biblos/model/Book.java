package com.chusnaval.biblos.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "Books")
public final class Book {

	private Long id;
	private String title;
	private String originalTitle;
	private List<Writer> writers = new ArrayList<Writer>();
	private List<Edition> editions = new ArrayList<Edition>();

	@Id
	@GeneratedValue
	@Column(name = "id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "title", nullable = false, length = 200)
	public String getTitle() {
		return title;
	}

	public void setTitle(String name) {
		this.title = name;
	}

	@Column(name = "originalTitle", nullable = true, length = 200)
	public String getOriginalTitle() {
		return originalTitle;
	}

	public void setOriginalTitle(String originalTitle) {
		this.originalTitle = originalTitle;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", originalTitle="
				+ originalTitle + "]";
	}

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "bookwriters", joinColumns = { @JoinColumn(name = "idBook") }, inverseJoinColumns = { @JoinColumn(name = "idWriter") })
	@Fetch(FetchMode.JOIN)
	public List<Writer> getWriters() {
		return writers;
	}

	public void setWriters(List<Writer> writers) {
		this.writers = writers;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "book")
	public List<Edition> getEditions() {
		return editions;
	}

	public void setEditions(List<Edition> editions) {
		this.editions = editions;
	}

	
}
