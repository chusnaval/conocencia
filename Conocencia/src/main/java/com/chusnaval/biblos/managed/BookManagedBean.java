package com.chusnaval.biblos.managed;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import org.springframework.dao.DataAccessException;

import com.chusnaval.biblos.model.Book;
import com.chusnaval.biblos.service.IBookService;

@ManagedBean(name="bookMB")
public class BookManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final String SUCCESS = "success";
	private static final String ERROR   = "error";

	@ManagedProperty(value="#{BookService}")
	IBookService bookService;

	List<Book> books;
	
	private Long id;
	private String title;
	private String originalTitle;
	
	/**
	  * Add User
	  *
	  * @return String - Response Message
	  */
	 public String addUser() {
	  try {
	   Book book = new Book();
	   book.setId(getId());
	   book.setTitle(getTitle());
	   book.setOriginalTitle(getOriginalTitle());
	   getBookService().addBook(book);
	   return SUCCESS;
	  } catch (DataAccessException e) {
	   e.printStackTrace();
	  }  

	  return ERROR;
	 }

	 /**
	  * Reset Fields
	  *
	  */
	 public void reset() {
	  this.setId((long) 0);
	  this.setTitle("");
	  this.setOriginalTitle("");
	 }

	public List<Book> getBooks() {
		List<Book> books= new ArrayList<Book>();
		books = bookService.getBooks();
		for(Book actual: books){
			actual.getWriters();
		}
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public IBookService getBookService() {
		return bookService;
	}

	public void setBookService(IBookService bookService) {
		this.bookService = bookService;
	}

	public String getOriginalTitle() {
		return originalTitle;
	}

	public void setOriginalTitle(String originalTitle) {
		this.originalTitle = originalTitle;
	}

}
