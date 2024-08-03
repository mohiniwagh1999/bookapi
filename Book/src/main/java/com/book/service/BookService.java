package com.book.service;

import java.util.List;

import com.book.entity.Book;

public interface BookService {
	
	
	public String upsert(Book book);
	
	public Book findById(Integer id);
	
	public List<Book> findAllBook(Book book);
	
	public String deleteById(Integer id);
	
	

}
