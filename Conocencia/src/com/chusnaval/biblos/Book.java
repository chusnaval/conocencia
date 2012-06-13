package com.chusnaval.biblos; 

import javax.persistence.Entity; 
import javax.persistence.GeneratedValue; 
import javax.persistence.Id; 

@Entity
public final class Book {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String originalTitle;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOriginalTitle() {
		return originalTitle;
	}
	public void setOriginalTitle(String originalTitle) {
		this.originalTitle = originalTitle;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", originalTitle="
				+ originalTitle + "]";
	}
	
	
	
}
