package com.example.blog.Controller;

import java.util.*;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.blog.model.Book;
import com.example.blog.repository.BookRepository;



@RestController
public class BookController {
	@Autowired
	BookRepository bookRepository;
	@PostMapping("/bookSave")
	public Book insertBook(@Valid @RequestBody Book book) {
		return bookRepository.save(book); 
	}
	@PostMapping("/MultipleBookSave")
	public String insertBook( @RequestBody List<Book> book) {
		bookRepository.saveAll(book); 
		return "record is saved successfully";
	}

}
