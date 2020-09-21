package com.example.blog.model;
import javax.persistence.*;
@Entity
@Table(name="tbl_book")

		public class Book {
			@Id
			@GeneratedValue(strategy=GenerationType.IDENTITY)
			private long bookId; 
		@Column
		private String bookTitle;
		   @Column
		 private String bookAuthor;
		public String getBookTitle() {
			return bookTitle;
		}
	
		public Book(long bookId, String bookTitle, String bookAuthor) {
			super();
			this.bookId = bookId;
			this.bookTitle = bookTitle;
			this.bookAuthor = bookAuthor;
		}
		public Book()
		{}

		public Book(String bookTitle, String bookAuthor) {
			super();
			this.bookTitle = bookTitle;
			this.bookAuthor = bookAuthor;
		}
		public void setBookTitle(String bookTitle) {
			this.bookTitle = bookTitle;
		}
		public String getBookAuthor() {
			return bookAuthor;
		}
		public void setBookAuthor(String bookAuthor) {
			this.bookAuthor = bookAuthor;
		}
		public long getBookId() {
			return bookId;
		}
		public void setBookId(long bookId) {
			this.bookId = bookId;
		}
		@Override
		public String toString() {
			return "Book [bookId=" + bookId + ", bookTitle=" + bookTitle + ", bookAuthor=" + bookAuthor + "]";
		}
		}
		
