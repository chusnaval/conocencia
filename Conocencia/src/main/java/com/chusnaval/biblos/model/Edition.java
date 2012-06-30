package com.chusnaval.biblos.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "editions")
public class Edition {

	private long id;
	private int number;
	private int year;
	private boolean buyed = false;
	private Publisher publisher;
	private Book book;
	private List<Recommendation> recommendations = new ArrayList<Recommendation>();

	@Id
	@GeneratedValue
	@Column(name = "id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "number")
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Column(name = "year")
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Column(name = "buyed")
	public boolean isBuyed() {
		return buyed;
	}

	public void setBuyed(boolean buyed) {
		this.buyed = buyed;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idPublisher", nullable = false)
	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idBook", nullable = false)
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@OneToMany(mappedBy = "edition")
	@Fetch(FetchMode.JOIN)
	public List<Recommendation> getRecommendations() {
		return recommendations;
	}

	public void setRecommendations(List<Recommendation> recommendations) {
		this.recommendations = recommendations;
	}

	
}
