package com.example.blog.repository;
import java.util.*;

	
	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.stereotype.Repository;

import com.example.blog.model.Book;
	@Repository
	public interface BookRepository extends JpaRepository<Book,Long> {
public List<Book> findBybookTitle(String name);
	}
