package com.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.book.entity.Book;
import com.book.service.BookService;

@RestController
public class BookController {
	@Autowired
	private BookService bookservice;
	
	
	@PostMapping("/book")
	public ResponseEntity<String> upsert(@ RequestBody Book book)
	{
		
		String upsert = bookservice.upsert(book);
		
		return new ResponseEntity<>(upsert,HttpStatus.CREATED);
	}
	
	@GetMapping("/book/{id}")
	public  ResponseEntity<Book> getById(@PathVariable Integer id)
	{
		
		Book byId = bookservice.findById(id);
		
	return new ResponseEntity<>(byId,HttpStatus.OK);
	}
	
	@GetMapping("/book")
	public  ResponseEntity<List<Book>> getAll(Book book)
	{
		List<Book> all= bookservice.findAllBook(book);
		
		return new ResponseEntity<>(all,HttpStatus.OK);
	}
	
	@PutMapping("/book")
	public ResponseEntity<String> update(@ RequestBody Book book)
	{
		
		String upsert = bookservice.upsert(book);
		
		return new ResponseEntity<>(upsert,HttpStatus.CREATED);
	}
	
	
   @DeleteMapping("/book/{id}")
	public  ResponseEntity<String> deleteById(@PathVariable Integer id)
	{
		String byId = bookservice.deleteById(id);
		
		return new ResponseEntity<>(byId,HttpStatus.OK);
	}
	

}
