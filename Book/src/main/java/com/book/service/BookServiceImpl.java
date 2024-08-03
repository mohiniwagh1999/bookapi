package com.book.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.entity.Book;
import com.book.repo.BookRepo;
@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepo bookRepo;
	
	
	@Override
	public String upsert(Book book) {
		// TODO Auto-generated method stub
	  
				bookRepo.save(book);
				
				return "created successfully";
	}

	@Override
	public Book findById(Integer id) {
		// TODO Auto-generated method stub
		Optional<Book> byId = bookRepo.findById(id);
		if(byId.isPresent())
		{
			return byId.get();
		}
		
		return null;
	}

	@Override
	public List<Book> findAllBook(Book book) {
		// TODO Auto-generated method stub
		List<Book> all = bookRepo.findAll();
		
		return all;
	}

	@Override
	public String deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	if(bookRepo.existsById(id))
	{
		bookRepo.deleteById(id);
		return "delete successfully";
	}
		
	else
	{
		return "record not found";
	}
		
	}

}
