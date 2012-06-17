package com.chusnaval.biblos.model; 

import javax.persistence.Entity; 
import javax.persistence.GeneratedValue; 
import javax.persistence.Id; 
import javax.persistence.Table;

@Entity
@Table(name="Books")
public final class Book {

	@Id
	@GeneratedValue
	private Long id;
	private String title;
	private String originalTitle;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String name) {
		this.title = name;
	}
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
	
	
	
}
