package com.example.blog.Controller;

import java.util.*;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	@GetMapping("/GetAllBook")
	public List<Book> getBook() {
		return  bookRepository.findAll(); 
	}
	@GetMapping("/GetBookByName/{name}")
	public List<Book> getBook(@PathVariable("name") String bookTitle) {
		return  bookRepository.findBybookTitle(bookTitle); 
	}
	@GetMapping("/GetBookById/{bookId}")
	public Optional<Book> getBook(@PathVariable("bookId") Long id) {
		return  bookRepository.findById(id); 
		
	}
	@PutMapping("/UpdateAndSave")
	public Book UpadteAndSaveBook(@Valid @RequestBody Book book) {
		return bookRepository.save(book); 
	}

	@DeleteMapping("/DeleteBookById/{bookId}")
	public String DeleteBook(@PathVariable("bookId") Long id) {
		Book b=bookRepository.getOne(id);
		 bookRepository.deleteById(id); 
		 return "deleted";
		
	}
	@PutMapping("/UpdateBook/{bookId}")
	public ResponseEntity<Book> updateBook(@PathVariable("bookId") Long id,  @RequestBody Book bookDetails)
	{
		Book book= bookRepository.findById(id).get();
		bookDetails.setBookId(id);
		bookRepository.save(bookDetails);
		return ResponseEntity.noContent().build();
}
}
