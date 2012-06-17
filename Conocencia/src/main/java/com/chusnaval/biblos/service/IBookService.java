package com.chusnaval.biblos.service;

import java.util.List;

import com.chusnaval.biblos.model.Book;

public interface IBookService {

	public void addBook(Book book);

	public void updateBook(Book book);

	public void deleteBook(Book book);

	public Book getBookById(int id);

	public List<Book> getBooks();
}
