package com.shivam.LibraryManagementSystem.service;

import java.util.List;

import com.shivam.LibraryManagementSystem.entity.Book;
import com.shivam.LibraryManagementSystem.entity.IssuedBook;

public interface LibrarianService {

	String authenticateLibrarian(String userid, String password);
	
	String saveBook(Book book);
	
	List<Book> getAllBooks();
	
	String issueBook(IssuedBook book);
	
	List<IssuedBook> getAllIssuedBooks();
	
	String returnBook(String bookNum);
}
