package com.api.rest.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String title;
	@OneToOne(cascade=CascadeType.ALL)
	private Author a;
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(int id, String title, Author a) {
		super();
		this.id = id;
		this.title = title;
		this.a = a;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Author getAuthor() {
		return a;
	}
	public void setAuthor(Author a) {
		this.a = a;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + a + "]";
	}
	

}
