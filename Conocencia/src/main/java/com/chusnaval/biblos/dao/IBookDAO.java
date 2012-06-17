package com.chusnaval.biblos.dao;

import java.util.List;

import com.chusnaval.biblos.model.Book;

public interface IBookDAO {

	public void addBook(Book book);

	public void updateBook(Book book);

	public void deleteBook(Book book);

	public Book getBookById(long id);

	public List<Book> getBooks();
}
