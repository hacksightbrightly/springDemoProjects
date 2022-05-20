package com.api.rest.dao;
import org.springframework.data.repository.CrudRepository;
import com.api.rest.entities.Book;

public interface BookRepo extends CrudRepository<Book,Integer>{
	public Book findById(int id);
}


