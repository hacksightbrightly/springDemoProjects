package com.api.rest.controller;

import java.util.List;
import java.util.Optional;

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

import com.api.rest.entities.Book;
import com.api.rest.services.BookServices;

@RestController
public class BookController {
	@Autowired
	private BookServices bs;
	@GetMapping("/book")
	public ResponseEntity<List<Book>> handler1() {	
		List<Book>b=this.bs.getAllBook();
		if(b.size()<=0)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.of(Optional.of(b));		
	}
	@GetMapping("/book/{id}")	
	public ResponseEntity<Book> handler2(@PathVariable("id") int id) {		
		Book b= this.bs.getBookById(id);	
		if(b==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(b));
	}
	@PostMapping("/book")	
	public ResponseEntity<Book> handler3(@RequestBody Book b) {		
		try{
			this.bs.addBook(b);
			return ResponseEntity.status(HttpStatus.CREATED).body(b);
		}
		catch(Exception e)
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	@DeleteMapping("/book/{id}")
	public ResponseEntity<Void> handler4(@PathVariable("id") int id) {
		try {
		this.bs.deleteBook(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	@PutMapping("/book/{id}")
	public ResponseEntity<Book> handler5(@RequestBody Book b, @PathVariable("id") int id) {
		try{
		this.bs.updateBook(b,id);
		return ResponseEntity.of(Optional.of(b));
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
