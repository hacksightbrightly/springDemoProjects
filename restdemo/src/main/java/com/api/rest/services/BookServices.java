package com.api.rest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.rest.dao.BookRepo;
import com.api.rest.entities.Book;
@Component
public class BookServices {
	@Autowired
	private BookRepo br;
	public List<Book> getAllBook() {
		List<Book>b1=(List<Book>)this.br.findAll();
		return b1;
	}
	public Book getBookById(int id) {
		Book b2=null;
		try{
		    b2=this.br.findById(id);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return b2;
	}
	public Book addBook(Book b3) {
		this.br.save(b3);
		return b3;
	}
	public void deleteBook(int id) {
		br.deleteById(id);
	}
	public Book updateBook(Book b3,int id) {
		Book b=new Book();
		b.setId(b3.getId());
		b.setAuthor(b3.getAuthor());
		b.setTitle(b3.getTitle());
		this.br.save(b);
		return b;
	}
	
}
