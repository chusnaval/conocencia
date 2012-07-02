package com.chusnaval.biblos.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.chusnaval.biblos.model.Book;

@Repository(value = "BookDAO")
public class BookDAO implements IBookDAO {

	private EntityManager entityManagerFactory;

	public void addBook(Book book) {
		entityManagerFactory.persist(book);
	}

	public void updateBook(Book book) {
		entityManagerFactory.merge(book);
	}

	public void deleteBook(Book book) {
		entityManagerFactory.remove(book);
	}

	@Override
	public Book getBookById(long id) {
		return (Book) this.entityManagerFactory
				.createQuery("from Book where id=?").setParameter(0, id)
				.getSingleResult();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Book> getBooks() {
		return this.entityManagerFactory.createQuery("from Book")
				.getResultList();
	}

	public EntityManager getEntityManagerFactory() {
		return entityManagerFactory;
	}

	@PersistenceContext
	public void setEntityManagerFactory(EntityManager entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}

}
