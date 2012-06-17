package com.chusnaval.biblos.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.chusnaval.biblos.dao.IBookDAO;
import com.chusnaval.biblos.model.Book;

@Transactional(readOnly = true)
public class BookService implements IBookService {

	IBookDAO bookDAO;

	@Transactional(readOnly = false)
	public void addBook(Book book) {
		bookDAO.addBook(book);

	}

	@Transactional(readOnly = false)
	public void updateBook(Book book) {
		bookDAO.updateBook(book);
	}

	@Transactional(readOnly = false)
	public void deleteBook(Book book) {
		bookDAO.deleteBook(book);
	}

	public Book getBookById(int id) {
		return bookDAO.getBookById(id);
	}

	public List<Book> getBooks() {
		return bookDAO.getBooks();
	}

	public IBookDAO getBookDAO() {
		return bookDAO;
	}

	public void setBookDAO(IBookDAO bookDAO) {
		this.bookDAO = bookDAO;
	}

}
