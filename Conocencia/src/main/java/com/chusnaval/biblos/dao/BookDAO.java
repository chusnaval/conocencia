package com.chusnaval.biblos.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.chusnaval.biblos.model.Book;

@Repository(value = "BookDAO")
public class BookDAO implements IBookDAO {

	private SessionFactory sessionFactory;

	public void addBook(Book book) {
		getSessionFactory().getCurrentSession().save(book);
	}

	public void updateBook(Book book) {
		getSessionFactory().getCurrentSession().update(book);
	}

	public void deleteBook(Book book) {
		getSessionFactory().getCurrentSession().delete(book);
	}

	@SuppressWarnings("unchecked")
	public Book getBookById(long id) {
		List<Book> list = getSessionFactory().getCurrentSession()
				.createQuery("from Book where id=?").setParameter(0, id).list();
		return list.get(0);
	}

	@SuppressWarnings("unchecked")
	public List<Book> getBooks() {
		return getSessionFactory().getCurrentSession().createQuery("from Book")
				.list();

	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
